package model;

public class Worker extends Person {
	private boolean available;
	public Worker(int id, int phone, String name, String address) {
		super(id, phone, name, address);
		available=true;
		
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	

}
