package banhngocninh.pttd;

import java.util.Scanner;

import banhngocninh.pttd.NhanVien;

public class TiepThi extends NhanVien {
    private long sale;
    private int commission;

    public TiepThi() {
    }

    public TiepThi(String Ecode, String name, long salary, long sale, int commission) {
        super(Ecode, name, salary);
        this.sale = sale;
        this.commission = commission;
    }

    public long getSale() {
        return sale;
    }

    public long getComission() {
        return commission;
    }

    public long pay() {
        return (getComission() * getSale()) + getSalary();
    }

    public void Output() {

        System.out.print("The Sale: ");
        System.out.printf("%,d", this.sale);
        System.out.println();
        System.out.println("The Commission: " + this.commission);
        super.Output();

    }
    public void update() {
		super.update();
		System.out.print("Type new Sale: ");
		long Sale = new  Scanner(System.in).nextLong();
		this.sale = Sale;
		System.out.print("Type new Commission: ");
		int Com = new  Scanner(System.in).nextInt();
		this.commission = Com;
	}

}