package com.example.pan.assignment1.view.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pan.assignment1.MainActivity;
import com.example.pan.assignment1.R;
import com.example.pan.assignment1.adapter.TrackableListAdapter;
import com.example.pan.assignment1.adapter.TrackingListAdapter;
import com.example.pan.assignment1.model.trackable.TrackableManager;
import com.example.pan.assignment1.model.tracking.TrackingManager;
import com.example.pan.assignment1.service.TrackingService;

public class TrackingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_list);

        init();
    }

    private void init(){
        RecyclerView rv;
        RecyclerView.LayoutManager layoutmanager;
        RecyclerView.Adapter adapter;


        rv = findViewById(R.id.recycleView);
        rv.setHasFixedSize(true);

        layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setMeasurementCacheEnabled(false);
        rv.setLayoutManager(layoutmanager);


        adapter = new TrackingListAdapter(this, TrackingManager.getTrackingList());

        rv.setAdapter(adapter);
    }
}
