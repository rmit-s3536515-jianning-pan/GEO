package com.example.pan.assignment1.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.pan.assignment1.model.tracking.Tracking;

import java.util.List;

public class OnLongClickToRemoveItem implements View.OnLongClickListener {

    private List<Tracking> data;
    private Tracking item;
    private  RecyclerView.Adapter adapter;
    public OnLongClickToRemoveItem(List<Tracking> data ,Tracking item, RecyclerView.Adapter adapter){
        this.data = data;
        this.item =item;
        this.adapter = adapter;
    }
    @Override
    public boolean onLongClick(View v) {
        int pos  = data.indexOf(item);
        data.remove(pos);
        adapter.notifyItemRemoved(pos);
        return true;
    }
}
