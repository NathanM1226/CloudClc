package com.gcu.data;

public class carsModel {
    Long id;
    String make;
    String model; 
    int year;
    int miles;
    Float price;

    public carsModel(){

    }

    public carsModel(long id, String make, String model, int year, int miles, Float price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    
    
}
