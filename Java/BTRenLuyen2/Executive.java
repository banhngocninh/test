package BTRenLuyen2;

import BTRenLuyen2.Employee;

public class Executive extends Employee {
    double bonus;

    public Executive() {

    }

    public Executive(String name, String address, String phone, String socialSecurityNumber, double payRate, double bonus) {
        super(name, address, phone, socialSecurityNumber, payRate);
        this.bonus = bonus;
    }

    public void Output() {
        super.Output();
        System.out.println("Pay: " + (pay() + execBonus()));
    }

    public double execBonus() {
        return bonus;
    }

    public double pay() {
        return 3000;
    }
}