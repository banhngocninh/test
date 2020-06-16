package BTRenLuyen2;

import BTRenLuyen2.StaffMember;

public class Volunteer extends StaffMember {

    public Volunteer() {

    }

    public Volunteer(String name, String address, String phone) {
        super(name, address, phone);
    }

    public void Output() {
        super.Output();
    }

    @Override
    public double pay() {
        return 0;
    }

}