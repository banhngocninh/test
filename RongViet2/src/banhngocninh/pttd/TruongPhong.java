package banhngocninh.pttd;

import java.util.Scanner;

import banhngocninh.pttd.NhanVien;

public class TruongPhong extends NhanVien {
    private long Responsibility;

    public TruongPhong(String Ecode, String name, long salary, long Responsibility) {
        super(Ecode, name, salary);
        this.Responsibility = Responsibility;
    }

    public TruongPhong() {

    }

    public long getResponsibility() {
        return Responsibility;
    }

    public long pay() {
        return getResponsibility() + getSalary();
    }

    public void update() {
		super.update();
		System.out.print("Type new Responsibility: ");
		long responsibility = new  Scanner(System.in).nextLong();
		this.Responsibility = responsibility;
	}
    public void Output() {

        System.out.print("Salary of Responsibility: ");
        System.out.printf("%,d", this.Responsibility);
        System.out.println();
        super.Output();
    }

}