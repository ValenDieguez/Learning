package org.practice.hotelpractice.Services;

import java.util.UUID;
public class Room implements RoomInterface {


    private String name;
    private String description;
    private boolean balcon;
    private String imgUrl;
    private int count = 0;
    private UUID id;
    private Boolean isFree = false;


    public Room(String name, String description, boolean balcon) {
        this.name = name;
        this.description = description;
        this.balcon = balcon;
        count = count+1;
    }

    public Room() {
    }

    public UUID getId() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
            return this.id;
        } else {
            return this.id;
        }
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public boolean isBalcon() {
        return balcon;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public void showRoom(){
        System.out.println("ROOM Showdown!");
        System.out.println("-------------------");
        System.out.println("Room name: "+name);
        System.out.println("Room desc: "+description);
        System.out.println("Have Balcony? "+balcon);
        System.out.println("-------------------");
        System.out.println("Is Free? "+isFree);
        System.out.println("Rent it !");

    }
}
