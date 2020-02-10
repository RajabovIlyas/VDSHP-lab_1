package com.company.DataClass;

import java.io.Serializable;

public class Train implements FilterCheck {
    private int ID;
    private String departureDate;   //Дата отпраления
    private String departureTime;   //Время отправления
    private String destination;     //Пункт назначения
    private String departureStation;    //Вокзал отправления
    private String departurePlatform;   //Платформа отправления
    private String arrivalStation;  //Вокзал прибытия
    private double ticketPrice;     //Стоимость билета
    private String typeTicket;      //Тип билета
    private String dateOfArrival;        //Дата прибывания
    private String timeOfArrival;      //Время прибывания
    private String fromCity;        //Город отправления

    public void print(){
        System.out.println(ID+","+departureDate+","+departureTime+","+destination+","+departureStation+","+
                departurePlatform+","+arrivalStation+","+ticketPrice+","+typeTicket+","+dateOfArrival+","+timeOfArrival+","+fromCity);
    }

    public Train(int ID, String departureDate, String departureTime, String destination, String departureStation,
                 String departurePlatform, String arrivalStation, double ticketPrice, String typeTicket,
                 String dateOfArrival, String timeOfArrival, String fromCity) {
        this.ID = ID;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.departureStation = departureStation;
        this.departurePlatform = departurePlatform;
        this.arrivalStation = arrivalStation;
        this.ticketPrice = ticketPrice;
        this.typeTicket = typeTicket;
        this.dateOfArrival = dateOfArrival;
        this.timeOfArrival = timeOfArrival;
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

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public String getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(String timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
}
