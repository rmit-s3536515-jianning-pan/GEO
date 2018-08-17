package com.example.pan.assignment1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pan.assignment1.R;
import com.example.pan.assignment1.controller.onTrackingItemClickedListener;
import com.example.pan.assignment1.model.tracking.Tracking;
import com.example.pan.assignment1.model.tracking.TrackingManager;
import com.example.pan.assignment1.view.fragments.EditTrackingActivity;

import java.util.List;

public class TrackingListAdapter extends RecyclerView.Adapter<TrackingListAdapter.ViewHolder> {

    private Context context;
    private List<Tracking> trackingDataset;

    //field for passing the variable to the next activity
    public static final String name ="Name";
    public static final String sT = "StartTime";
    public static final String eT = "EndTime";

    public TrackingListAdapter(Context context, List<Tracking> trackingDataset){
        this.context  = context;
        this.trackingDataset = trackingDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trackable_list_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
           Tracking t = trackingDataset.get(i);
           String sStartTime = TrackingManager.dateformat.format(t.getTargetStartTime());
           String sEndTime = TrackingManager.dateformat.format(t.getTargetEndTime());
            viewHolder.title.setText("Title: " + t.getTitle());
        viewHolder.startTime.setText("Start Time:" + sStartTime );
        viewHolder.endTime.setText("End Time:" + sEndTime);
        viewHolder.trackableName.setText("");

        viewHolder.view.setOnClickListener(new onTrackingItemClickedListener(context,t.getTitle(),sStartTime,sEndTime,t.getTrackingId()));
    }


    @Override
    public int getItemCount() {
        return trackingDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView startTime;
        public TextView endTime;
        public TextView trackableName;
        public View view;
        public ViewHolder(View v){
            super(v);
            view = v;
            title = v.findViewById(R.id.name);
            startTime = v.findViewById(R.id.category);
            endTime = v.findViewById(R.id.description);
            trackableName = v.findViewById(R.id.url);
        }
    }
}
