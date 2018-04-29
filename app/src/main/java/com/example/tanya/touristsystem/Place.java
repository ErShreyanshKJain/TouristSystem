package com.example.tanya.touristsystem;

public class Place {
    private String name;
    //private String imageUrl;

    public Place(String name) {
        this.name = name;
        //this.imageUrl = imageUrl;
    }

    public Place(){
        name = "";
        //imageUrl = "";
    }

    public String getName() {
        return name;
    }

    /*public String getImageUrl() {
        //return imageUrl;
    }*/
}
