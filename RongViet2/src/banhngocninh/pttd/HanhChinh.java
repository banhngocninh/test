package banhngocninh.pttd;

import banhngocninh.pttd.NhanVien;

public class HanhChinh extends NhanVien {
	public HanhChinh(String Ecode, String name, long salary) {
		super(Ecode, name, salary);
	}

	public HanhChinh() {

	}

	@Override
	public long pay() {
		return getSalary();
	}

	public void Output() {
		super.Output();
	}

	public void update() {
		super.update();
	}

}