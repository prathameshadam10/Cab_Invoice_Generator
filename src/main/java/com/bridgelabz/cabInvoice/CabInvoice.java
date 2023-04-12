package com.bridgelabz.cabInvoice;

public class CabInvoice {
    public static final int COST_PER_KM = 10;
    public static final int COST_PER_MIN = 1;
    public static final int MIN_FARE = 5;
    public static final int COST_PER_KM_PREMIUM = 15;
    public static final int COST_PER_MIN_PREMIUM = 2;
    public static final int MIN_FARE_PREMIUM = 20;

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

    public double calculatePremiumFare(double distance, double time) {
        double fare =  distance * COST_PER_KM_PREMIUM + time * COST_PER_MIN_PREMIUM;
        return fare<MIN_FARE_PREMIUM ? MIN_FARE_PREMIUM : fare;
    }
    public double calculatePremiumFare(Ride[] rides) {
        double aggFare=0;
        for (Ride ride : rides) {
            aggFare += calculatePremiumFare(ride.getDistance(),ride.getTime());
        }
        return aggFare;
    }
}
