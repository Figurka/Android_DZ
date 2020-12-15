package com.example.drawshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    private final static int MAX_POINTS = 5;
    public static final String TYPE_RECT = "rect";
    //    public static final String TYPE_RECT = "rect";
    int width;
    int height;
    int sizeGrid = 48;
    float density;

    String typeShape = TYPE_RECT;
    String color = "000000";

    int counterPoints;
    PointF[] points = new PointF[MAX_POINTS];

    int counterRect;
    Rect[] rects = new Rect[100];

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        density = getResources().getDisplayMetrics().density;
        sizeGrid *= density;
    }

//    public MyView(Context context) {
//        super(context);
//        density = getResources().getDisplayMetrics().density;
//        sizeGrid *= density;
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawColor(Color.RED);

        canvas.getWidth();
        canvas.getHeight();

        Paint paint = new Paint();
        paint.setStrokeWidth(20);
        paint.setColor(Color.RED);

        drawGrid(canvas);
        drawPoints(canvas);
        drawRects(canvas);
    }

    private void drawGrid(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(density);
        int numBlockWidth = canvas.getWidth() / sizeGrid;
        int numBlockHeight = canvas.getHeight() / sizeGrid;

        int yStop = canvas.getHeight();
        for (int i = 1; i <= numBlockWidth; i++) {
            int x = i * sizeGrid;
            canvas.drawLine(x, 0, x, yStop, paint);
        }

        int xStop = canvas.getWidth();
        for (int i = 1; i <= numBlockHeight; i++) {
            int y = i * sizeGrid;
            canvas.drawLine(0, y, xStop, y, paint);
        }
    }

    void drawRects(Canvas canvas) {
        Paint paint = new Paint();

        for (int i = 0; i < counterRect; i++) {
            Rect rect = rects[i];
            rect.draw(canvas, paint);
        }
    }

    void drawPoints(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);


        int counter = Math.min(counterPoints, MAX_POINTS);

        for (int i = 0; i < counter; i++) {
            PointF pointF = points[i];
            canvas.drawCircle(pointF.x, pointF.y, 20, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            sizeGrid += 20;
//            this.invalidate();
            float x = event.getX();
            float y = event.getY();
            if (counterPoints < MAX_POINTS) {
                points[counterPoints] = new PointF(x, y);
                counterPoints++;

                switch (this.typeShape) {
                    case TYPE_RECT: checkPointsForCreateRect();
                }

                this.invalidate();
            }
        }
        return true;
    }

    private void checkPointsForCreateRect() {
        if (counterPoints >= 2) {
            // создаем прямоугольник
            Rect rect = new Rect(this.color, points[0], points[1]);

            rects[counterRect] = rect;
            counterRect++;

            counterPoints = 0;
            this.invalidate();
        }
    }
}
