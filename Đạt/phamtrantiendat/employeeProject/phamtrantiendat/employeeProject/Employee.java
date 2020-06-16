package phamtrantiendat.employeeProject;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String address;
	private String email;
	private int age;
	private double salary;

	public Employee() {

	}

	public Employee(String id, String name, String address, String email, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
		this.salary = salary;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "employee [ID =" + id + ", add =" + address + ", age =" + age + ", email =" + email + ", name =" + name
				+ ", salary =" + salary + "]";
	}
}
