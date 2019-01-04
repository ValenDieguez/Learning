package org.practice.hotelpractice.Services;

import org.joda.time.DateTime;
import org.practice.hotelpractice.Data.RegisterList;
import org.practice.hotelpractice.Data.RegisterListDay;
import org.practice.hotelpractice.Data.RoomGenerator;



import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


//Servicio encargado de tener las llamadas al API
public class AvailabilitySvc {
    private RegisterList registerList = RegisterList.getMyRegisterList();
    private RoomGenerator roomGenerator= RoomGenerator.getMyRoomGenerator();
    private static AvailabilitySvc availabilitySvc;

    private AvailabilitySvc() {
    }

    public static AvailabilitySvc getAvailabilitySvc(){
        if (availabilitySvc == null) {
            availabilitySvc = new AvailabilitySvc();
        }
        return availabilitySvc;
    }

    //Este es la primera llamada
    public ArrayList<Booking> getAllRoomDisp(Date minDay, Date maxDay, MealPlan mealPlan) {
        Dates date = new Dates(minDay, maxDay);
        ArrayList<Room> listOfFreeRoom = registerList.searchFreeRoomsWithDate(date);
        ArrayList<Booking> completeFreeBooking = new ArrayList<>();
        for (Room room : listOfFreeRoom) {
            Booking booking = new Booking(room, mealPlan, date);
            BookingSvc bookingSvc =BookingSvc.getBookingSvc(booking);
            booking.setPrize(bookingSvc.prizeCalc(booking.getRoom(), booking.getDates(), booking.getMealPlan()));
            completeFreeBooking.add(booking);

        }
        //remove this when do not test
        return completeFreeBooking;

    }

    //Esta es la segunda llamada
    public Room getRoomDisp(UUID id, Dates date, MealPlan mealPlan) {
        ArrayList<Booking> allFreeRooms = getAllRoomDisp(date.getMinDate(), date.getMaxDate(), mealPlan);
        Room roomSearched = new Room();
        for (Room room : roomGenerator.getRoomList()
                ) {
            if (id == room.getId()) {
                roomSearched = room;
                for (Booking booking : allFreeRooms
                        ) {
                    if (booking.getRoom() == room) {
                        roomSearched.setFree(true);
                    }
                }
            }

        }
      return roomSearched;
    }

    public void rentRoom(UUID roomId, Dates dates, MealPlan mealPlan){
        Room room = getRoomDisp(roomId, dates, mealPlan);
        if(room.getFree()){
            Booking booking = new Booking(room,mealPlan,dates);
            BookingSvc bookingSvc = BookingSvc.getBookingSvc(booking);
            int nights = bookingSvc.getNightsInHotel();
            RegisterList registerList = RegisterList.getMyRegisterList();
            DateTime dayTimeMin = new DateTime (dates.getMinDate());

            for (int i = 0; i < nights; i++){
                RegisterListDay registerListDay = registerList.getARegisterDay(dayTimeMin.plusDays(i).toDate());
                registerListDay.addToRegister(booking);
                registerList.addDayToList(registerListDay);
            }

            System.out.println("Room Saved!");
        }else {
            System.err.println("room not free");
        }
    }

}






