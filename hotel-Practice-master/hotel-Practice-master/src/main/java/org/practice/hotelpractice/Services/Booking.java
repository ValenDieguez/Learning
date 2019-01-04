package org.practice.hotelpractice.Services;

public class Booking {
    private Room room;
    private MealPlan mealPlan;
    private Dates dates;
    private int prize;


    public Booking(Room room, MealPlan mealPlan, Dates dates) {
        this.room = room;
        this.mealPlan = mealPlan;
        this.dates = dates;
    }

    public Room getRoom() {
        return room;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public Dates getDates() {
        return dates;
    }

    public int getPrize() {

        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

//    private int calculatePrize(){
//
//    }
}
