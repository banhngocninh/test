package BTRenLuyen2;

public abstract class StaffMember {
    String name, address, phone;

    public StaffMember() {

    }

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public abstract double pay();

    public void Output() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Phone mumber: " + this.phone);

    }

}