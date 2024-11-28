package com.akshatnama.project.uber.uberApp.strategies;

import com.akshatnama.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}