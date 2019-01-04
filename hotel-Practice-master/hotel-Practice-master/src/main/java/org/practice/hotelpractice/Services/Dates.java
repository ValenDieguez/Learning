package org.practice.hotelpractice.Services;

import java.util.Date;

public class Dates {
 private Date minDate;
 private Date maxDate;
 private int nightsInHotel;


    public Dates(Date minDate, Date maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    public Date getMinDate() {
        return minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }



}
