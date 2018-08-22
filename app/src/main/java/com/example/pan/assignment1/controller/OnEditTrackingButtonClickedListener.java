package com.example.pan.assignment1.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.pan.assignment1.model.tracking.Tracking;
import com.example.pan.assignment1.model.tracking.TrackingManager;
import com.example.pan.assignment1.view.fragments.TrackingList;

import java.text.ParseException;

public class OnEditTrackingButtonClickedListener implements View.OnClickListener {

    private Context context;
    private String tId;

    public OnEditTrackingButtonClickedListener(Context context, String tId) {
        this.context = context;
        this.tId = tId;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(context, TrackingList.class);
        context.startActivity(intent);
    }
}

