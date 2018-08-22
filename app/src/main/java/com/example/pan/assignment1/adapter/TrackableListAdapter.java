package com.example.pan.assignment1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pan.assignment1.R;
import com.example.pan.assignment1.model.trackable.Trackable;

import com.example.pan.assignment1.model.tracking.TrackingManager;
import com.example.pan.assignment1.view.fragments.AddTracking;

import java.util.List;

public class TrackableListAdapter extends RecyclerView.Adapter<TrackableListAdapter.ViewHolder> {

    private Context context;
    private static List<Trackable> dataset;

    public TrackableListAdapter(Context context, List<Trackable> dataset){
        this.context = context;
        this.dataset = dataset;
    }

    public static void updateDataset(List<Trackable> data){ //update dataset
        dataset = data;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trackable_list_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Trackable item = dataset.get(i);
        viewHolder.name.setText("Name : " + item.getName());
        viewHolder.category.setText("Category : " +item.getCategory());
        viewHolder.description.setText("Description : " +item.getDescription());
        viewHolder.url.setText("URL : " + item.getUrl());

        //Click to add tracking
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddTracking.class);
                System.out.println("Id "+ item.getId());
                intent.putExtra("TrackableId",Integer.toString(item.getId()));

                context.startActivity(intent);
            }
        });

        viewHolder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                   TrackingManager.displayRoute(item.getId());
                   return true;
            }
        }); // long click to show route information
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView category;
        public TextView description;
        public TextView url;
        public View view;
        public ViewHolder(View v){
            super(v);
            view = v;
            name = v.findViewById(R.id.name);
            category = v.findViewById(R.id.category);
            description = v.findViewById(R.id.description);
            url = v.findViewById(R.id.url);
        }
    }

}
