package com.example.practice_r7;

public class Passenger {
    private String name, phone, preference;
    private float ticketPrice;

    public Passenger() {
    }

    public Passenger(String name, String phone, String preference, float ticketPrice) {
        this.name = name;
        this.phone = phone;
        this.preference = preference;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
