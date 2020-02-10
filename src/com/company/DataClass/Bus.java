package com.company.DataClass;

import java.io.Serializable;

public class Bus implements FilterCheck {
    private int ID;
    private String departureDate;   //Дата отпраления
    private String departureTime;   //Время отправления
    private String destination;     //Пункт назначения
    private String departureStation;    //Вокзал отправления
    private String departurePlatform;   //Платформа отправления
    private String arrivalStation;  //Вокзал прибытия
    private double ticketPrice;     //Стоимость билета
    private String busBrand;        //Марка автобуса
    private String travelTime;      //Время в пути
    private String fromCity;        //Город отправления

    public Bus(int ID, String departureDate, String departureTime, String destination, String departureStation, String departurePlatform, String arrivalStation, double ticketPrice, String busBrand, String travelTime, String fromCity) {
        this.ID = ID;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.departureStation = departureStation;
        this.departurePlatform = departurePlatform;
        this.arrivalStation = arrivalStation;
        this.ticketPrice = ticketPrice;
        this.busBrand = busBrand;
        this.travelTime = travelTime;
        this.fromCity = fromCity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getDeparturePlatform() {
        return departurePlatform;
    }

    public void setDeparturePlatform(String departurePlatform) {
        this.departurePlatform = departurePlatform;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getBusBrand() {
        return busBrand;
    }

    public void setBusBrand(String busBrand) {
        this.busBrand = busBrand;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
}
