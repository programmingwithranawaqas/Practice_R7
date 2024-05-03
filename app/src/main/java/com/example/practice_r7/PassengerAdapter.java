package com.example.practice_r7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PassengerAdapter extends ArrayAdapter<Passenger> {

    PassengerClicked parentActivit;
    public interface PassengerClicked{
        public void passengerClick(int position);
    }

    public PassengerAdapter(Context context, ArrayList<Passenger> list)
    {
        super(context, 0, list);
        parentActivit = (PassengerClicked) context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v == null)
        {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.passenger_listitem_design, parent, false);
        }
        ImageView ivPreference = v.findViewById(R.id.tvPreference);
        TextView tvName = v.findViewById(R.id.tvName);

        Passenger p = getItem(position);

        tvName.setText(p.getName());

        if(p.getPreference().equals("bus"))
        {
            ivPreference.setImageResource(R.drawable.ic_bus);
        }
        else if(p.getPreference().equals("plane"))
        {
            ivPreference.setImageResource(R.drawable.ic_plane);
        }
        else if(p.getPreference().equals("train"))
        {
            ivPreference.setImageResource(R.drawable.ic_train);
        }

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivit.passengerClick(position);
            }
        });

        return v;
    }
}
