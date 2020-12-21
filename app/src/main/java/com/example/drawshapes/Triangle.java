package com.example.drawshapes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;

public class Triangle extends Shape {

    float[] tri_points;
    float[] tri1_points;

    Triangle(String color,PointF first_point,PointF second_point,PointF third_point) {
        super(color);
//        this.tri_points= new float[]{first_point.x, first_point.y, second_point.x, second_point.y, second_point.x, second_point.y,third_point.x, third_point.y,third_point.x, third_point.y,first_point.x, first_point.y};
        this.tri1_points= new float[]{first_point.x, first_point.y, second_point.x, second_point.y, third_point.x, third_point.y};
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.parseColor("#"+color));
        paint.setStrokeWidth(10);
//        canvas.drawLines(tri_points,paint);
//        canvas.drawVertices(Canvas.VertexMode.TRIANGLES,6 , tri1_points,0 ,null,0,new int[]{0,256,65000},0,null,0,0,paint);


        canvas.drawVertices(Canvas.VertexMode.TRIANGLES ,
                6,
                tri1_points,
                0,
                null,
                0,
                new int[]{(int)Long.parseLong("ff"+color,16),(int)Long.parseLong("ff"+color,16),(int)Long.parseLong("ff"+color,16)},
                0,
                null,
                0,
                0,
                paint);
//        Log.i("FF",String.valueOf((int)Long.parseLong("ff"+color,16)));
//        Log.i("FF",String.valueOf(paint.getColor()));



    }
}
