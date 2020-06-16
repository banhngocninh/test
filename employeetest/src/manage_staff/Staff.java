package manage_staff;

import java.io.Serializable;
import java.util.Date; 

public class Staff implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Date dateBegin;
	private Date birthday;
	private Room room;
	
	
	public Staff(String id, String name, Date dateBegin, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.dateBegin = dateBegin;
		this.birthday = birthday;
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
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
