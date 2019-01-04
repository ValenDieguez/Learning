package org.practice.hotelpractice.Data;

import org.practice.hotelpractice.Services.Booking;
import org.practice.hotelpractice.Services.Dates;
import org.practice.hotelpractice.Services.Room;


import java.util.ArrayList;
import java.util.Date;


public class RegisterList {
    private ArrayList<RegisterListDay> registerList = new ArrayList();
    private RoomGenerator completRoomListClass = RoomGenerator.getMyRoomGenerator();
    private static RegisterList myRegisterList;

    private RegisterList() {
    }

    public static RegisterList getMyRegisterList() {
        if (myRegisterList == null) {
            myRegisterList = new RegisterList();
        }
        return myRegisterList;
    }


    public boolean isInRegister(RegisterListDay register) {
        return registerList.contains(register);
    }

    public void deleteDay(RegisterListDay register) {
        if (isInRegister(register)) {
            registerList.remove(register);
        }
    }

    public ArrayList<RegisterListDay> getRegisterList() {
        return registerList;
    }

    public void addDayToList(RegisterListDay register) {
        if (isInRegister(register)) {
            deleteDay(register);
            registerList.add(register);
        } else {
            registerList.add(register);
        }
    }

    public RegisterListDay getARegisterDay(Date date) {
        RegisterListDay registerListDay = null;
        for (RegisterListDay day : registerList
                ) {
            if (day.getDate() == date) {
                registerListDay = day;
            }
        }
        return registerListDay;
    }

    //Simula la lista de registros de la db
    public ArrayList<Room> searchFreeRoomsWithDate(Dates dates) {
        ArrayList<Room> notFreeRoom = new ArrayList<>();
        ArrayList<Room> freeRoom = new ArrayList<>();
        Long minDateGiven = dates.getMinDate().getTime();
        Long maxDateGiven = dates.getMaxDate().getTime();
        ArrayList<Room> completRoomList = completRoomListClass.getRoomList();
        if (registerList.size() == 0) {
            freeRoom = completRoomList;
        } else {
            for (RegisterListDay registerOfADay : registerList
                    ) {
                if (registerOfADay.getDate().getTime() >= minDateGiven && registerOfADay.getDate().getTime() <= maxDateGiven) {
                    ArrayList<Booking> dayRegister = registerOfADay.getRegisterList();
                    for (Room room : completRoomList
                            ) {
                        for (Booking booking : dayRegister
                                ) {
                            if (booking.getRoom() == room) {
                                if (!notFreeRoom.contains(room)) {
                                    notFreeRoom.add(room);
                                }
                            }

                        }
                    }
                }
            }

            for (Room room : completRoomList
                    ) {
                if (!notFreeRoom.contains(room)) {
                    freeRoom.add(room);
                }
            }
        }
        return freeRoom;
    }
}
