package BTRenLuyen2;

import BTRenLuyen2.Employee;

public class Hourly extends Employee {

    int hoursWorked;

    public Hourly() {
    }

    public Hourly(String name, String address, String phone, String socialSercurity, double payRate, int hoursWorked) {
        super(name, address, phone, socialSercurity, payRate);
        this.hoursWorked = hoursWorked;
    }

    public double pay() {

        return hoursWorked * getpayRate();
    }

    public void Output() {
        super.Output();
        System.out.println("Hour worked: " + this.hoursWorked);
        System.out.println("Pay: " + pay());
    }

}