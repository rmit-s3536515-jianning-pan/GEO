package com.example.pan.assignment1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.pan.assignment1.controller.OnSpinnerItemSelectedListener;
import com.example.pan.assignment1.adapter.TrackableListAdapter;
import com.example.pan.assignment1.model.trackable.TrackableManager;
import com.example.pan.assignment1.view.fragments.TrackingList;


import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static Context context;

//    private  List<Trackable> data;
    private TrackableListAdapter t;
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestTrackingService.test(this); //this one initalize list of tracking
        context = this;
        setRecycleView();
        setSpinnerView();

    }

    public static Context getContext(){ //pass the reference of context to TrackableManager, so it can read the file
        return context;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.showlistoption,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_show_tracking:
                Intent intent = new Intent(this, TrackingList.class);
                startActivity(intent);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    private void setSpinnerView(){
        Spinner spinner = findViewById(R.id.filterSpinner);

        List<String> categories = TrackableManager.getAllCategories();
        Collections.sort(categories);
        categories.add(0,"All");
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categories);

        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinneradapter);

//        spinner.setDropDownVerticalOffset(100); // offset

        spinner.setOnItemSelectedListener(new OnSpinnerItemSelectedListener(this,adapter));
    }

    private void setRecycleView(){

        rv = findViewById(R.id.recycleView);
        rv.setHasFixedSize(true);

        layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setMeasurementCacheEnabled(false);
        rv.setLayoutManager(layoutmanager);


        adapter = new TrackableListAdapter(this, TrackableManager.findTrackableByCategory(null));

        rv.setAdapter(adapter);


    }

}
