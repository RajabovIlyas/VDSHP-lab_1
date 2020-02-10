package com.company.DataClass;

public class Airplane implements FilterCheck {
    private int ID;
    private String departureDate;   //Дата вылета
    private String departureTime;   //Время вылета
    private String destination;     //Пункт назначения
    private String departureAirport;    //Аэропорт вылета
    private String distance;   //Растояние полета
    private String arrivalAirport;  //Аэропорт прилета
    private double ticketPrice;     //Стоимость билета
    private String typeTicket;      //Тип билета
    private String dateArrival;        //Дата прибывания
    private String timeArrival;      //Время прибывания
    private int numberOfTransfers;      //Количество пересадок
    private String airlineName;     //Название авиакомпании
    private String maximumLuggage;  //Максимальный богаж
    private String maximumHandLuggage;    //Максимальная ручная кладь
    private String fromCity;        //Город отправления

    public void print(){
        System.out.println(ID+","+departureDate+","+departureTime+","+destination+","+departureAirport+","+distance+","+arrivalAirport+","+ticketPrice+","+typeTicket+","
                +dateArrival+","+timeArrival+","+numberOfTransfers+","+airlineName+","+maximumLuggage+","+maximumHandLuggage+","+fromCity);
    }

    public Airplane(int ID, String departureDate, String departureTime, String destination, String departureAirport,
                    String distance, String arrivalAirport, double ticketPrice, String typeTicket, String dateArrival,
                    String timeArrival, int numberOfTransfers, String airlineName, String maximumLuggage,
                    String doublemaximumHandLuggage, String fromCity) {
        this.ID = ID;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.distance = distance;
        this.arrivalAirport = arrivalAirport;
        this.ticketPrice = ticketPrice;
        this.typeTicket = typeTicket;
        this.dateArrival = dateArrival;
        this.timeArrival = timeArrival;
        this.numberOfTransfers = numberOfTransfers;
        this.airlineName = airlineName;
        this.maximumLuggage = maximumLuggage;
        this.maximumHandLuggage = doublemaximumHandLuggage;
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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
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

    public String getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public int getNumberOfTransfers() {
        return numberOfTransfers;
    }

    public void setNumberOfTransfers(int numberOfTransfers) {
        this.numberOfTransfers = numberOfTransfers;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getMaximumLuggage() {
        return maximumLuggage;
    }

    public void setMaximumLuggage(String maximumLuggage) {
        this.maximumLuggage = maximumLuggage;
    }

    public String getMaximumHandLuggage() {
        return maximumHandLuggage;
    }

    public void setMaximumHandLuggage(String maximumHandLuggage) {
        this.maximumHandLuggage = maximumHandLuggage;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
}
