package com.example.practice_r7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements PassengerAdapter.PassengerClicked {
    Fragment addPassengerFrag, infoFragment, passengersFragment;
    PassengerAdapter adapter;
    FragmentManager manager;
    View addPassengerFragView, infoFragmentView, passengersFragmentView;
    // hooks for addPassengerFragment
    EditText etName, etPhone, etTicketPrice, etPref;
    Button btnAdd, btnClear;

    // hooks for infoFragment
    TextView tvName, tvPrice, tvPhone;
    ImageView ivPreference;

    // hooks for passengersFragment
    ListView lvPassenger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String price = etTicketPrice.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String pref = etPref.getText().toString().trim();

                Passenger p = new Passenger(name, phone, pref, Float.parseFloat(price));
                MyApplication.passengers.add(p);
                adapter.notifyDataSetChanged();

            }
        });
    }

    private void init()
    {
        manager=getSupportFragmentManager();
        addPassengerFrag = manager.findFragmentById(R.id.addpassengerfragment);
        infoFragment = manager.findFragmentById(R.id.infofragment);
        passengersFragment = manager.findFragmentById(R.id.passengersfragment);
        addPassengerFragView = addPassengerFrag.getView();
        passengersFragmentView = passengersFragment.getView();
        infoFragmentView = infoFragment.getView();
        etName = addPassengerFragView.findViewById(R.id.etName);
        etPhone = addPassengerFragView.findViewById(R.id.etPhone);
        etTicketPrice = addPassengerFragView.findViewById(R.id.etPrice);
        etPref = addPassengerFragView.findViewById(R.id.etPreference);
        btnAdd = addPassengerFragView.findViewById(R.id.btnAdd);
        btnClear = addPassengerFragView.findViewById(R.id.btnClear);
        tvName = infoFragmentView.findViewById(R.id.tvName);
        tvPhone = infoFragmentView.findViewById(R.id.tvPhone);
        tvPrice = infoFragmentView.findViewById(R.id.tvPrice);
        ivPreference = infoFragmentView.findViewById(R.id.ivPreference);
        lvPassenger = passengersFragmentView.findViewById(R.id.lvPassengers);

        adapter = new PassengerAdapter(this, MyApplication.passengers);
        lvPassenger.setAdapter(adapter);
    }

    @Override
    public void passengerClick(int position) {
        Passenger p = MyApplication.passengers.get(position);
        tvName.setText(p.getName());
        tvPhone.setText(p.getPhone());
        tvPrice.setText(p.getTicketPrice()+"");

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

    }
}