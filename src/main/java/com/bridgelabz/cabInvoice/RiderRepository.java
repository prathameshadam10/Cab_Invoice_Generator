package com.bridgelabz.cabInvoice;

public class RiderRepository {

    public Invoice generateInvoice(int userNo, Ride[] rides) {
        CabInvoice cabInvoice = new CabInvoice();
        int totalRides = rides.length;
        double aggFare = cabInvoice.calculateFare(rides);
        double avgFare = (aggFare/totalRides);
        return new Invoice(totalRides, aggFare, avgFare, userNo);
    }

    public Invoice generateInvoice(int userNo, Ride[] rides, UserType userType) {
        CabInvoice cabInvoice = new CabInvoice();
        if(userType.NORMAL.equals(userType)){
            int totalRides = rides.length;
            double aggFare = cabInvoice.calculateFare(rides);
            double avgFare = (aggFare/totalRides);
            return new Invoice(totalRides, aggFare, avgFare, userNo);
        }
        else if(userType.PREMIUM.equals(userType)){
            int totalRides = rides.length;
            double aggFare = cabInvoice.calculatePremiumFare(rides);
            double avgFare = (aggFare/totalRides);
            return new Invoice(totalRides, aggFare, avgFare, userNo);
        }
        return null;


    }
}
