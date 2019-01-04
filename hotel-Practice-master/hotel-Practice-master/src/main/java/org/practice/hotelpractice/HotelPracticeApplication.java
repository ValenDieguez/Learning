package org.practice.hotelpractice;

import org.practice.hotelpractice.Services.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelPracticeApplication {

    //https://drive.google.com/drive/u/0/folders/1C_sZ6zenpTJl3P3M1eW3qI6jgaYwXhBA
    // Falta añadir anotaciones spring  a todos los controladores. Ya hay la primera llamada realizada (AvailabilitySvc)
    // Data simula la BD
    //Messages tendra los JSON de prueba
    // Hay test para las clases basicas, Servicios no testeados

    public static void main(String[] args) {
        SpringApplication.run(HotelPracticeApplication.class, args);


        Room ares= new Room("Ares","A destructive and Warlike Room. With Big Axes and swords as decoration, this room is perfect for the sons of the war. Have spiky TV, a big thematic bed and some weaponMade Chairs", false);

        ares.showRoom();

    }




    }


