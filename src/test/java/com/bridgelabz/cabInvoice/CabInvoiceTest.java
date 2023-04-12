package com.bridgelabz.cabInvoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CabInvoiceTest {
    CabInvoice cabInvoice;

    @BeforeEach
    public void init() {
        cabInvoice = new CabInvoice();
    }

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        double fare = cabInvoice.calculateFare(40, 20);
        Assertions.assertEquals(420, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare() {
        double fare = cabInvoice.calculateFare(0.2, 1);
        Assertions.assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare(){
        Ride ride1 = new Ride(40,20);
        Ride ride2 = new Ride(30,15);
        Ride ride3 = new Ride(0.2,1);
        Ride ride4 = new Ride(0.3,1);
        Ride [] rides = {ride1, ride2, ride3, ride4};
        double aggFare = cabInvoice.calculateFare(rides);
        Assertions.assertEquals(745,aggFare,0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnInvoice(){
        Ride ride1 = new Ride(40,20);
        Ride ride2 = new Ride(30,15);
        Ride ride3 = new Ride(0.2,1);
        Ride ride4 = new Ride(0.3,1);
        Ride [] rides = {ride1, ride2, ride3, ride4};
        Invoice expectedInvoice = new Invoice(4,745.0,745.0/4);
        Invoice invoice = cabInvoice.generateInvoice(rides);
        Assertions.assertEquals(expectedInvoice,invoice);
    }
}