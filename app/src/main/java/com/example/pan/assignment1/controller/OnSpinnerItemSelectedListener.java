package com.example.pan.assignment1.controller;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.pan.assignment1.adapter.TrackableListAdapter;
import com.example.pan.assignment1.model.trackable.TrackableManager;

public class OnSpinnerItemSelectedListener implements AdapterView.OnItemSelectedListener{
    private Context context;
    private  RecyclerView.Adapter adapter;

    public  OnSpinnerItemSelectedListener(Context context, RecyclerView.Adapter adapter){
        this.context = context;
        this.adapter = adapter;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TrackableListAdapter.updateDataset(TrackableManager.findTrackableByCategory(adapterView.getItemAtPosition(i).toString()));
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
