package org.example.models;

import java.lang.String;


public class Futsal {

    int futsal_id;

    String futsal_name;

    String location;

    int futsal_price;

    boolean futsal_isavailable;

    public int getFutsal_id() {
        return futsal_id;
    }

    public void setFutsal_id(int futsal_id) {
        this.futsal_id = futsal_id;
    }

    public String getFutsal_name() {
        return futsal_name;
    }

    public void setFutsal_name(String futsal_name) {
        this.futsal_name = futsal_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFutsal_price() {
        return futsal_price;
    }

    public void setFutsal_price(int futsal_price) {
        this.futsal_price = futsal_price;
    }

    public boolean isFutsal_isavailable() {
        return futsal_isavailable;
    }

    public void setFutsal_isavailable(boolean futsal_isavailable) {
        this.futsal_isavailable = futsal_isavailable;
    }

    public void rent(){
        futsal_isavailable = false;
    }

    public void game_completion() {
        futsal_isavailable = true;
    }

    public Futsal(int futsal_id, String futsal_name, String location, int futsal_price, boolean futsal_isavailable) {
        this.futsal_id = futsal_id;
        this.futsal_name = futsal_name;
        this.location = location;
        this.futsal_price = futsal_price;
        this.futsal_isavailable = true; // Initially, I assumed the Futsal is available first.
    }

    public void futprint(){
        String name = this.getFutsal_name();
        int id = this.getFutsal_id();

        System.out.println(id+"\t"+"Futsal Name:"+name);


    }
    public void futsal_detailprint(){
        String name = this.getFutsal_name();
        int id = this.getFutsal_id();
        String location = this.getLocation();
        int price = this.getFutsal_price();
        boolean available = this.isFutsal_isavailable();
        System.out.println("Futsal ID:"+id+"\n"+"Futsal Name:"+name+"\n"+"Futsal Location:"+location+"\n"+"Price per Hour:"+price+"\n");
    }

}

