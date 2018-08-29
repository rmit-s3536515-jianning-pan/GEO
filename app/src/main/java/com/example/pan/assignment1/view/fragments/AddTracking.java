package com.example.pan.assignment1.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pan.assignment1.R;
import com.example.pan.assignment1.controller.OnClickAddTrackingListener;
import com.example.pan.assignment1.controller.OnSpinnerItemSelectedListener;
import com.example.pan.assignment1.model.tracking.MeelEvent;
import com.example.pan.assignment1.model.tracking.Tracking;
import com.example.pan.assignment1.model.tracking.TrackingManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddTracking extends AppCompatActivity {

    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tracking);

        init();
    }


    private void init(){
        String extra = getIntent().getStringExtra("TrackableId");

        et = findViewById(R.id.trackingNameField);

        List<String> datetime = TrackingManager.getAllTime(); //get the list of time and date

        Spinner startTime = findViewById(R.id.startTime);
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,datetime);
        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startTime.setAdapter(spinneradapter);
//        startTime.setSelection(spinneradapter.getPosition(datetime.get(4).toString()));

        Spinner endTime = findViewById(R.id.endTime);
        endTime.setAdapter(spinneradapter);

        Spinner meetTime = findViewById(R.id.meetTimeSpinner);
        meetTime.setAdapter(spinneradapter);

        Button addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new OnClickAddTrackingListener(this,startTime,endTime,et,extra,meetTime));

    }
}
