package com.example.pan.assignment1.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.example.pan.assignment1.helper.InputValidationCheck;
import com.example.pan.assignment1.model.tracking.Tracking;
import com.example.pan.assignment1.model.tracking.TrackingManager;
import com.example.pan.assignment1.view.fragments.TrackingList;

import java.text.ParseException;

public class OnEditTrackingButtonClickedListener implements View.OnClickListener {

    private Context context;
    private String tId;
    private EditText et;
    public OnEditTrackingButtonClickedListener(Context context, String tId, EditText et) {
        this.context = context;
        this.tId = tId;
        this.et = et;
    }

    @Override
    public void onClick(View v) {
        if (!InputValidationCheck.checkTrackingTitleIsEmpty(context,et)) {
            Intent intent = new Intent(context, TrackingList.class);
            context.startActivity(intent);
        }
    }
}

