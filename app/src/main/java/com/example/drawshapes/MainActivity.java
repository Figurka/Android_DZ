package com.example.drawshapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class Listener implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                Log.i("onCLick", "вызван метод onClick в Listener");
            }
        }

        Button undoBtn = findViewById(R.id.undoBtn);
        undoBtn.setOnClickListener(new Listener());
    }

    @Override
    public void onClick(View v) {
        Log.i("onClick", "onClick");
    }
}