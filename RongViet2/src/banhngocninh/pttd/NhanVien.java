package banhngocninh.pttd;

import java.util.Scanner;

public abstract class NhanVien {
    protected String Ecode, name;
    protected long salary;

    public NhanVien() {
    }

    public NhanVien(String Ecode, String name, long salary) {
        this.Ecode = Ecode;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEcode() {
        return Ecode;
    }

    public long getSalary() {
        return salary;
    }

    public long tax() {
        if (pay() < 9000000) {
            System.out.println("This person doesn't need pay the tax!!!");
            return 0;
        } else if (pay() >= 9000000 && pay() < 15000000) {
            return (long) (pay() * 0.1);
        } else {
            return (long) (pay() * 0.12);
        }
    }
    public void update() {
    	System.out.print("Type new Employee Code: ");
		String NEC = new  Scanner(System.in).nextLine();
		this.Ecode = NEC;
		System.out.print("Type new name: ");
		String name = new  Scanner(System.in).nextLine();
		this.name = name;
		System.out.print("Type new Salary: ");
		long salary = new  Scanner(System.in).nextLong();
		this.salary = salary;
    };
    public abstract long pay();
    
    @Override
    public String toString() {
    	return "The Employee Code: " + Ecode + "\nThe Name of employee: " + name +"\nThe Salary: "+ salary;
    }
    public void Output() {
        System.out.println("The Employee Code: " + this.Ecode);
        System.out.println("The Name of employee: " + this.name);
        System.out.print("The Salary: ");
        System.out.printf("%,d", this.salary);
        System.out.println();
        System.out.print("The Pay: ");
        System.out.printf("%,d", this.pay());
        System.out.println();
        System.out.print("The Tax: ");
        System.out.printf("%,d", this.tax());
        System.out.println();
    }
}