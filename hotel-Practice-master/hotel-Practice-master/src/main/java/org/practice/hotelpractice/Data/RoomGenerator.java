package org.practice.hotelpractice.Data;

import org.practice.hotelpractice.Services.Room;

import java.util.ArrayList;

//Simula las habitaciones en la DB
public class RoomGenerator {

    private ArrayList<Room> roomList;
    private static  RoomGenerator myRoomGenerator;

    private RoomGenerator() {
    }

    public static RoomGenerator getMyRoomGenerator() {
        if (myRoomGenerator == null){
            myRoomGenerator = new RoomGenerator();
        }
        return myRoomGenerator;
    }

    public ArrayList<Room> getRoomList() {
        if (roomList != null) {
            return myRoomGenerator.roomList;
        } else {
            myRoomGenerator.roomList = new ArrayList<Room>();
            Room ares = new Room("Ares", "A destructive and Warlike Room. With Big Axes and swords as decoration, this room is perfect for the sons of the war. Have spiky TV, a big thematic bed and some weaponMade Chairs", false);
            Room apolo = new Room("Apolo", "Mystic Room. Future, Healing and Past are inside this room. A exoteric Tv, An hospital bed, and an archaic cooler make happy the best aurispice", true);
            Room poseidon = new Room("Poseidon", "Sea Room, decorated with seashells, and painted like if where a beach. Have a sound system that repeat the sond of waves (stoppable)", true);
            Room zeus = new Room("Zeus", "Our Kings room. Olimpian decorated room, like a greek temple. with a big throne in a lateral seeming the Zeus throne. A light tv and a good gold bed", false);
            Room atenea = new Room("Atenea", "Our Smart Room, With strategi books and some paintings. Also have an olive tree in the balcony. For the best Amazons", true);
            Room hades = new Room("Hades", "the hell in the earth. Dark decoration with paintings of the estigian Lake. Dark lights give an special ambient to this room. You will be our persephone", false);
            Room afrodita = new Room("Afrodita", "Love is in the air. A romantic date? be a casanova and surprise with this hearth form bed, jacuzzi and special minibar", false);
            Room hermes = new Room("Hermes", "A Room for whom wants to rest quickly and continue early their work. Silenced and very confortable have 2 bathroom for being quicker", false);
            Room demeter = new Room("Demeter", "Farmlike Room, Rustic and confortable room, with farm sounds, wake up hearing the cock. painted like if you where in a cereal farm", false);
            Room dionisio = new Room("Dionisio", "Like Party? this is your room, prepared with a variety of alcohol, games and a good soundsystem.Dont stop the party!", true);
            Room hefesto = new Room("Hefesto", "Its a cold day? this room is warmer than a vulcano. Equiped with a hot bath and a Sauna is the best way to stay warm in a cold night", false);
            Room artemisa = new Room("Artemisa", "The forest in a room, A quiet room with bird sound. Be like in the wildness without the problem of weather and animals. This room have no bed, but is equiped with special floor to make it confortable", true);
            myRoomGenerator.roomList.add(ares);
            myRoomGenerator.roomList.add(apolo);
            myRoomGenerator.roomList.add(poseidon);
            myRoomGenerator.roomList.add(zeus);
            myRoomGenerator.roomList.add(atenea);
            myRoomGenerator.roomList.add(hades);
            myRoomGenerator.roomList.add(afrodita);
            myRoomGenerator.roomList.add(hermes);
            myRoomGenerator.roomList.add(demeter);
            myRoomGenerator.roomList.add(dionisio);
            myRoomGenerator.roomList.add(hefesto);
            myRoomGenerator.roomList.add(artemisa);


            return myRoomGenerator.roomList;
        }
    }
}
