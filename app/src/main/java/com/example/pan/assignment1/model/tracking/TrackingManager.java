package com.example.pan.assignment1.model.tracking;

import android.util.Log;

import com.example.pan.assignment1.MainActivity;
import com.example.pan.assignment1.service.TrackingService;

import java.text.DateFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrackingManager {

    private static List<Tracking> trackingList = new ArrayList<>();

    public static DateFormat dateformat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM);

    // Sort the array by start time
    public static List<Tracking> getTrackingList(){
        Collections.sort(trackingList, new Comparator<Tracking>() {
            @Override
            public int compare(Tracking o1, Tracking o2) {
                return o1.getTargetStartTime().compareTo(o2.getTargetStartTime());
            }
        });
        return trackingList;
    }

    private static final String TAG = TrackingManager.class.getName();

    public static void displayRoute(int id){
            List<Tracking> t = TrackingService.getSingletonInstance(MainActivity.getContext()).getTrackingList();;

            for(Tracking tr : t){
                if(tr.getTrackableId() == id && tr.getStopTime()!=0){
                    Log.i(TAG,tr.toString());
                }
            }
    }

    public static void addTracking(Tracking tracking){
        trackingList.add(tracking);
    }

    public static List<String> getAllTime(){

        List<String> dateTime = new ArrayList<>();

        List<Tracking> trackings = TrackingService.getSingletonInstance(MainActivity.getContext()).getTrackingList();

        for(Tracking t : trackings){
            String sDate = dateformat.format(t.getTargetStartTime());

            dateTime.add(sDate);
        }
        Set<String> set = new HashSet<>(dateTime);

        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
         return result;
    }

}
