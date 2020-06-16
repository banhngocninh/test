package BTRenLuyen2;

import BTRenLuyen2.StaffMember;

public abstract class Employee extends StaffMember {
    String socialSecurityNumber;
    double payRate;

    public Employee() {
    }

    public Employee(String name, String address, String phone, String socialSecurityNumber, double payRate) {
        super(name, address, phone);
        this.socialSecurityNumber = socialSecurityNumber;
        this.payRate = payRate;
    }

    public double getpayRate() {
        return payRate;
    }

    public abstract double pay();

    public void Output() {
        super.Output();
        System.out.println("Social Security Number: " + socialSecurityNumber);
        System.out.println("Pay rate: " + payRate);

    }
}