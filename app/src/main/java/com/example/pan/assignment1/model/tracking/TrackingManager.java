package com.example.pan.assignment1.model.tracking;

import com.example.pan.assignment1.MainActivity;
import com.example.pan.assignment1.service.TrackingService;

import java.text.DateFormat;
import java.util.ArrayList;

import java.util.List;

public class TrackingManager {

    private static List<Tracking> trackingList = new ArrayList<>();

    public static DateFormat dateformat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM);

    public static List<Tracking> getTrackingList(){
        return trackingList;
    }

    public static void displayRoute(int id){
            List<Tracking> t = TrackingService.getSingletonInstance(MainActivity.getContext()).getTrackingList();;

            for(Tracking tr : t){
                if(tr.getTrackableId() == id){
                    System.out.println(tr);

                }
            }
    }

    public static void addTracking(Tracking tracking){
        trackingList.add(tracking);
    }

    public static List<String> getAllTime(){
//        String datetime = "05/07/2018 1:0:00 PM";
        List<String> dateTime = new ArrayList<>();

        List<Tracking> trackings = TrackingService.getSingletonInstance(MainActivity.getContext()).getTrackingList();
        System.out.println("SIZE " + trackings.size());
        for(Tracking t : trackings){
            String sDate = dateformat.format(t.getTargetStartTime());
            System.out.println("Time : "+ sDate );
            dateTime.add(sDate);
        }
        return dateTime;
    }
}
