package com.example.revision_class;

public class MyBills extends Bill{
    public MyBills(double gallons, double kilowatts, double minutes) {
        super(gallons, kilowatts, minutes);
    }

    //default constructor;
    public MyBills(){
        super(0,0,0);
    }
    
    public double getElectricityBill(){
        double kilowatts = getKilowatts();
        
        if(kilowatts <= 50){
            return 0.0;
        } else if (kilowatts <= 150) {
            return (kilowatts - 50)*0.05;
        } else {
            return (100 * 0.50) + ((kilowatts - 150) * 1.20);
        }
    }

    public  double getTelephoneBill(){
        double minutes = getMinutes();
        if(minutes <= 5){
            return 0.0;
        } else{
            return (minutes-5)*0.60;
        }
    }

    public double getTotalBill(){
        return getElectricityBill()+getTelephoneBill()+getWaterBIll();
    }
}
