package com.example.aokly.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        Random r = new Random();
        db.addRec("First "+r.nextInt(100),r.nextInt(100));
        db.addRec("Second "+r.nextInt(100),r.nextInt(100));
        db.addRec("Third "+r.nextInt(100),r.nextInt(100));
    }

    public void btnClick(View v){
        List <String> strLst = db.getStringList();
        for (String s:strLst)
            Log.d("STRING", s);
        List <Integer> intLst = db.getIntegerList();
        for (Integer i:intLst)
            Log.d("INTEGER", i+"");
    }

}
