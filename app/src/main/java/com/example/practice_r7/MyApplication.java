package com.example.practice_r7;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<Passenger> passengers;


    @Override
    public void onCreate() {
        super.onCreate();
        passengers = new ArrayList<>();
        passengers.add(new Passenger("Ali", "+92334163264","bus", 3500));
        passengers.add(new Passenger("Abdullah", "+92334163951","plane", 3900));
        passengers.add(new Passenger("Subhani", "+92334162222","train", 300));
    }
}
