package model;

public class Person {

	
	private int id,phone;
	private String name,address;
		
		
		public Person(int id,int phone,String name,String address)
		{
				this.id=id;
				this.phone=phone;
				this.name=name;
				this.address=address;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPhone() {
			return phone;
		}

		public void setPhone(int phone) {
			this.phone = phone;
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
			
		
		
}
