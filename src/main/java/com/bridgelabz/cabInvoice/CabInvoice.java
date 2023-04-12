package com.bridgelabz.cabInvoice;

public class CabInvoice {
    public static final int COST_PER_KM = 10;
    public static final int COST_PER_MIN = 1;
    public static final int MIN_FARE = 5;
    public double calculateFare(double distance, double time) {
        double fare =  distance * COST_PER_KM + time * COST_PER_MIN;
        return fare<MIN_FARE ? MIN_FARE : fare;

    }

    public double calculateFare(Ride[] rides) {
        double aggFare=0;
        for (Ride ride : rides) {
            aggFare += calculateFare(ride.getDistance(),ride.getTime());
        }
        return aggFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        int totalRides = rides.length;
        double aggRides = calculateFare(rides);
        double avgRides = (aggRides/totalRides);
        return new Invoice(totalRides, aggRides, avgRides);

    }
}
