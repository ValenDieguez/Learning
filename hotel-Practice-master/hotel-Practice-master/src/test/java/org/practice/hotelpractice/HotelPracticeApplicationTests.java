package org.practice.hotelpractice;

import org.practice.hotelpractice.Data.RegisterList;
import org.practice.hotelpractice.Data.RoomGenerator;
import org.practice.hotelpractice.Services.AvailabilitySvc;
import org.practice.hotelpractice.Services.Booking;
import org.practice.hotelpractice.Services.BookingSvc;
import org.practice.hotelpractice.Services.Dates;
import org.practice.hotelpractice.Services.MealPlan;
import org.practice.hotelpractice.Services.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelPracticeApplicationTests {

    //rooms
    private Room ares = new Room("Ares","A destructive and Warlike Room. With Big Axes and swords as decoration, this room is perfect for the sons of the war. Have spiky TV, a big thematic bed and some weaponMade Chairs", false);
    private Room apolo = new Room("Apolo","Mystic Room. Future, Healing and Past are inside this room. A exoteric Tv, An hospital bed, and an archaic cooler make happy the best aurispice", true);

    //Dates
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    String date = sdf.format(new Date());
    Date begining= new Date(1220227200);
    Date intermediate= new Date(1520227200);
    Date finale = new Date(1920227200);
    Date wrongDay=new Date(1020227200);
    private Dates vacaciones= new Dates(begining,finale);
    private Dates incorrect= new Dates(begining,wrongDay);
    //Booking
    Booking reserva = new Booking(ares,MealPlan.Complete,vacaciones);
    Booking failBooking = new Booking(apolo,MealPlan.Standard,incorrect);
   //services
    BookingSvc bookingSvc =BookingSvc.getBookingSvc(reserva);
    AvailabilitySvc availabilitySvc = AvailabilitySvc.getAvailabilitySvc();

    //Utils
    RoomGenerator roomGen= RoomGenerator.getMyRoomGenerator();
    RegisterList registerList = RegisterList.getMyRegisterList();


    //Rooms Tests
    @Test
    public void roomText(){
        ares.setImgUrl("https://cdna.artstation.com/p/assets/images/images/003/624/616/large/mike-jensen-pfuz-mystery-room.jpg?1475728634");
        assertEquals("Ares", ares.getName());
        assertFalse( ares.isBalcon());
        assertEquals("https://cdna.artstation.com/p/assets/images/images/003/624/616/large/mike-jensen-pfuz-mystery-room.jpg?1475728634", ares.getImgUrl());
        assertNotNull(ares);
        ares.showRoom();
        apolo.showRoom();

    }

    @Test
    public void roomIdText(){
        assertNotNull(apolo.getId());
        assertNotNull(ares.getId());
        assertTrue(apolo.getId() != ares.getId());
    }

    //Dates Tests

    @Test
    public void datesTest(){
        bookingSvc.setBooking(reserva);
        assertEquals(bookingSvc.getNightsInHotel(),8);
        assertTrue(bookingSvc.sameDate(intermediate));
        bookingSvc.setBooking(failBooking);
        assertFalse(bookingSvc.isCorrectDate());
    }

//    Data test

    @Test
    public void roomGeneratorTest(){
        ArrayList<Room> roomList = roomGen.getRoomList();
        System.out.println(roomList);
        assertTrue(roomList.size() == 12);
    }

//    Availability Tests
    @Test
    public void availabilityTest(){
        ArrayList<Booking> availability= availabilitySvc.getAllRoomDisp(begining,finale,MealPlan.Complete);
        assertTrue(availability.size() == 12);
    }

    @Test
    public void  freeRoomTest(){
        UUID roomId = roomGen.getRoomList().get(0).getId();
        Room aresIsFree =availabilitySvc.getRoomDisp(roomId,vacaciones,MealPlan.Standard);
        aresIsFree.showRoom();
        assertTrue(aresIsFree.getFree());
    }

    @Test
    public void rentRoomtest(){
        UUID roomId = roomGen.getRoomList().get(0).getId();
        availabilitySvc.rentRoom(roomId, vacaciones, MealPlan.Standard);
        System.out.println(registerList.getRegisterList());
        System.out.println(registerList.getARegisterDay(vacaciones.getMinDate()).getRegisterList());
        System.out.println(availabilitySvc.getRoomDisp(roomId,vacaciones,MealPlan.Standard).getFree());
        assertFalse(availabilitySvc.getRoomDisp(roomId,vacaciones,MealPlan.Standard).getFree());
    }
}
