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

    public onTrackingItemClickedListener(Context context, String title, String st, String et,String trackingId) {
        this.context = context;
        this.title = title;
        this.st = st;
        this.et = et;
        this.trackingId = trackingId;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, EditTrackingActivity.class);
        intent.putExtra(TrackingListAdapter.name,title);
        intent.putExtra(TrackingListAdapter.sT,st);
        intent.putExtra(TrackingListAdapter.eT,et);
        intent.putExtra(TrackingListAdapter.ID,trackingId);
        context.startActivity(intent);
    }
}
