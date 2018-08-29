package com.example.pan.assignment1.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.pan.assignment1.adapter.TrackingListAdapter;
import com.example.pan.assignment1.view.fragments.EditTrackingActivity;

public class onTrackingItemClickedListener implements View.OnClickListener {
    private Context context;
    private String title;
    private String st;
    private String et;
    private String trackingId;
    private String meet;
    public onTrackingItemClickedListener(Context context, String title, String st, String et,String trackingId,String meet) {
        this.context = context;
        this.title = title;
        this.st = st;
        this.et = et;
        this.trackingId = trackingId;
        this.meet = meet;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, EditTrackingActivity.class);
        intent.putExtra(TrackingListAdapter.name,title);
        intent.putExtra(TrackingListAdapter.sT,st);
        intent.putExtra(TrackingListAdapter.eT,et);
        intent.putExtra(TrackingListAdapter.ID,trackingId);
        intent.putExtra(TrackingListAdapter.meet,meet);
        context.startActivity(intent);
    }
}
