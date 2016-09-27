package com.example.headstart.headstart;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Kodekryptexamfinish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kodekryptexamfinish);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6600")));
        }

        TextView tv = (TextView) findViewById(R.id.kk);
        tv.setText("You scored"+" " +Databasehandler.marks+" "+"marks");
        Databasehandler.marks = 0;
    }
}
