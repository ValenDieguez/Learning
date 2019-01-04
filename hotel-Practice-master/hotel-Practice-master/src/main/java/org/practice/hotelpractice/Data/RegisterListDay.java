package org.practice.hotelpractice.Data;


import org.practice.hotelpractice.Services.Booking;

import java.util.ArrayList;
import java.util.Date;

//Un dia de registro de la DB

public class RegisterListDay {
    private Date date;
    private ArrayList<Booking> registerList = new ArrayList<>();


    public RegisterListDay(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public boolean isInArray (Booking booking){
        return this.registerList.contains(booking);
    }

    public void addToRegister(Booking booking){
        this.registerList.add(booking);
    }

    public void deleteFromRegister(Booking booking){
        this.registerList.remove(booking);
    }

    public ArrayList getRegisterList() {
        if (this.registerList != null) {
            return this.registerList;
        } else {
            registerList = new ArrayList<>();
            return registerList;
        }
    }
}
