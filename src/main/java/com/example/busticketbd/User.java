package com.example.busticketbd;

public class User {
    private String BusName;
    private String BusSpecification;
    private String BusType;
    private String SeatFormation;
    private String From;
    private String To;

    private String DepartureTime;
    int AvailableSeat;
    int Fare;
    int ID;

    public User(String busName, String busSpecification, String busType, String seatFormation, String from, String to, String departureTime, int availableSeat, int fare, int ID) {
        BusName = busName;
        BusSpecification = busSpecification;
        BusType = busType;
        SeatFormation = seatFormation;
        From = from;
        To = to;
        DepartureTime = departureTime;
        AvailableSeat = availableSeat;
        Fare = fare;
        this.ID = ID;
    }

    public String getBusName() {
        return BusName;
    }

    public String getBusSpecification() {
        return BusSpecification;
    }

    public String getBusType() {
        return BusType;
    }

    public String getSeatFormation() {
        return SeatFormation;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public int getAvailableSeat() {
        return AvailableSeat;
    }

    public int getFare() {
        return Fare;
    }

    public int getID() {
        return ID;
    }
}
