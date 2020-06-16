package manage_staff;

import java.util.Vector;

public class Room {
	private String id;
	private String name;
	private Vector<Staff> staffs;
	
	public Room() {
		super();
		this.staffs = new Vector<Staff>();
	}
	
	public Room(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.staffs = new Vector<Staff>();
	}

	public void addStaff(Staff staff) {
		this.staffs.add(staff);
		staff.setRoom(this);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Vector<Staff> staffs) {
		this.staffs = staffs;
	}
	@Override
	public String toString() {
		return getName();
	}
	
}
