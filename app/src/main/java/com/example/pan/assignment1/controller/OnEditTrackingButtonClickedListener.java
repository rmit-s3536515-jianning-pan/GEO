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
    private String title;
    private String sT;
    private String eT;
    private String tId;

    public OnEditTrackingButtonClickedListener(Context context, String title, String sT, String eT, String tId) {
        this.context = context;
        this.title = title;
        this.sT = sT;
        this.eT = eT;
        this.tId = tId;
    }

    @Override
    public void onClick(View v) {
        for(Tracking t : TrackingManager.getTrackingList()){
            if(t.getTrackingId().equals(tId)){
                try {
                    t.setTargetStartTime(TrackingManager.dateformat.parse(sT));
                    t.setTargetEndTime(TrackingManager.dateformat.parse(eT));
                    t.setTitle(title);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                break;
            }
        }
        Intent intent = new Intent(context, TrackingList.class);
        context.startActivity(intent);
    }
}

