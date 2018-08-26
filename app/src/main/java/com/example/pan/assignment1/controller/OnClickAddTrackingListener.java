package com.example.pan.assignment1.controller;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pan.assignment1.R;
import com.example.pan.assignment1.helper.InputValidationCheck;
import com.example.pan.assignment1.model.tracking.MeelEvent;
import com.example.pan.assignment1.model.tracking.Tracking;
import com.example.pan.assignment1.model.tracking.TrackingManager;
import com.example.pan.assignment1.view.fragments.TrackingList;

import java.text.ParseException;
import java.util.Date;

public class OnClickAddTrackingListener implements OnClickListener{

    private Context context;
    private Spinner startTime;
    private Spinner endTime;
    private EditText et;
    private String extra;

    public OnClickAddTrackingListener(Context context, Spinner startTime, Spinner endTime, EditText et, String extra) {
        this.context = context;
        this.startTime = startTime;
        this.endTime = endTime;
        this.et = et;
        this.extra = extra;
    }

    @Override
    public void onClick(View v) {
        if (!InputValidationCheck.checkTrackingTitleIsEmpty(context,et) && !InputValidationCheck.checkDuplicateTrackingTitle(context,et)){
            try {

                Date startDate = TrackingManager.dateformat.parse(startTime.getSelectedItem().toString());
                Date endDate = TrackingManager.dateformat.parse(endTime.getSelectedItem().toString());

                Tracking t = new MeelEvent();
                t.setTitle(et.getText().toString());
                t.setTargetStartTime(startDate);
                t.setTargetEndTime(endDate);
                t.setTrackableId(Integer.parseInt(extra));
                TrackingManager.addTracking(t);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            Intent intent = new Intent(context, TrackingList.class);
            context.startActivity(intent);
        }
    }
}
