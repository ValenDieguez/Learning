package org.practice.hotelpractice.Services;

import java.util.Date;


//contiene las operaciones de un Booking
public class BookingSvc {
    private Booking booking;
    private static BookingSvc bookingSvc;

    private  BookingSvc( Booking booking) {
        this.booking = booking;
    }

    public static BookingSvc getBookingSvc(Booking booking){
        if (bookingSvc == null) {
            bookingSvc = new BookingSvc(booking);
        }
        return bookingSvc;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }


    //Dates
    public int getNightsInHotel() {
        return (int)((this.booking.getDates().getMaxDate().getTime()-this.booking.getDates().getMinDate().getTime())/86400000);

    }

    public int getNightsInHotel(Dates dates) {
        return (int)((dates.getMaxDate().getTime()-dates.getMinDate().getTime())/86400000);

    }

    public boolean isCorrectDate(){
        if((int)((this.booking.getDates().getMaxDate().getTime()-this.booking.getDates().getMinDate().getTime())/86400000) >= 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCorrectDate(Dates date){
        if((int)(date.getMaxDate().getTime()-date.getMinDate().getTime())/86400000 >= 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean sameDate(Date newDate){
        if (newDate.getTime() >= this.booking.getDates().getMinDate().getTime() && newDate.getTime()<=this.booking.getDates().getMaxDate().getTime()){
            return true;
        }else{
            return false;
        }
    }

    public boolean sameDate(Date newDate, Dates date){
        if (newDate.getTime() >= date.getMinDate().getTime() && newDate.getTime()<=date.getMaxDate().getTime()){
            return true;
        }else{
            return false;
        }
    }

    public int prizeCalc (Room room, Dates dates, MealPlan mealPlan){
        int roomDay = 50 + (room.isBalcon()? 10 : 0)+(mealPlan == MealPlan.Complete? 30: 0);
        return  getNightsInHotel(dates)*roomDay;
    }


    public void saveBooking(){

    }

    public void cancelBooking(){}
}
