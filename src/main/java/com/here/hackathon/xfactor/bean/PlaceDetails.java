package com.here.hackathon.xfactor.bean;

public class PlaceDetails {

    private String name;
    private String address;
    private String contact;

    public PlaceDetails() {}

    public PlaceDetails(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
