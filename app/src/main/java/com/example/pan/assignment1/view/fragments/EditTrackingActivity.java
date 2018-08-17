package com.example.pan.assignment1.view.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pan.assignment1.R;
import com.example.pan.assignment1.adapter.TrackingListAdapter;
import com.example.pan.assignment1.controller.OnEditTrackingButtonClickedListener;
import com.example.pan.assignment1.model.tracking.Tracking;
import com.example.pan.assignment1.model.tracking.TrackingManager;

import java.text.ParseException;
import java.util.List;

public class EditTrackingActivity extends AppCompatActivity {
    private EditText text;
    private Button btn;
    private Spinner startTime;
    private Spinner endtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tracking); //use the add tracking layout instead of "activity_edit_tracking"

       init();
    }
    private void init() {
        Intent ref = getIntent();
        String name = ref.getStringExtra(TrackingListAdapter.name);
        String sT = ref.getStringExtra(TrackingListAdapter.sT);
        String eT = ref.getStringExtra(TrackingListAdapter.eT);
        String tId = ref.getStringExtra("ID");
        text = findViewById(R.id.trackingNameField);
        text.setText(name);
        btn = findViewById(R.id.addBtn);
        btn.setText("Edit Tracking");

        List<String> datetime = TrackingManager.getAllTime();

        startTime = findViewById(R.id.startTime);
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, datetime);
        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        startTime.setAdapter(spinneradapter);
        startTime.setSelection(spinneradapter.getPosition(sT));


        endtime = findViewById(R.id.endTime);
        endtime.setAdapter(spinneradapter);
        endtime.setSelection(spinneradapter.getPosition(eT));

        btn.setOnClickListener(new OnEditTrackingButtonClickedListener(this,name,sT,eT,tId));
    }
}
