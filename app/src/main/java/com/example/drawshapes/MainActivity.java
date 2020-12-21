package com.example.drawshapes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView myView = findViewById(R.id.myView);
        RadioGroup shapes = findViewById(R.id.shapes);
        Spinner Color = findViewById(R.id.colors);
        class Listener implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

            @Override
            public void onClick(View v) {
                myView.undo();
            }

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rectRadio:myView.setTypeShape(MyView.TYPE_RECT); break;
                    case R.id.circleRadio:myView.setTypeShape(MyView.TYPE_CIRCLE); break;
                    case R.id.triangleRadio:myView.setTypeShape(MyView.TYPE_TRIANGLE); break;
                }
            }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] all_colors=getResources().getStringArray(R.array.colors);
                myView.setColor(all_colors[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                myView.setColor("000000");
            }
        }

        Button undoBtn = findViewById(R.id.undoBtn);
        undoBtn.setOnClickListener(new Listener());
        shapes.setOnCheckedChangeListener(new Listener());
        Color.setOnItemSelectedListener(new Listener());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
//        outState.putParcelable("Try",myView.onSaveInstanceState());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        myView.onRestoreInstanceState(savedInstanceState.getParcelable("Try"));
    }

    @Override
    public void onClick(View v) {
        Log.i("onClick", "onClick");
    }
}