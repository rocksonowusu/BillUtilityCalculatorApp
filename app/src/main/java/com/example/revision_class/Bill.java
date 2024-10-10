package com.example.revision_class;

public class Bill {
    private final double gallons;
    private final double kilowatts;
    private final double minutes;

    public Bill(double gallons, double kilowatts, double minutes){
        this.gallons = gallons;
        this.kilowatts = kilowatts;
        this.minutes = minutes;

    }

    public double getGallons() {
        return gallons;
    }

    public double getKilowatts() {
        return kilowatts;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getWaterBIll(){
        if(gallons <= 50){
            return 0.0;
        } else {
            return (gallons-50)*1.05;
        }
    }
}
