package cleaning.services.staticdatabase;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Product;

public class Customers {
	private static List <Customer> customers=new ArrayList<Customer>(){{
        add(new Customer(0,12345,"ahmad","jenin"));
        add(new Customer(1,12345,"mohammad","jenin"));
        add(new Customer(2,12345,"khaled","jenin"));
        }};


	public static List<Customer> getCutomers() {
		return customers;
	}

	public static void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public static Customer findCustomer(int id) {
		for(Customer customer:Customers.getCutomers())
		{
			if(customer.getId()==id) 
			{
				return customer;
			}
		}
		return null;
	}

	public static void deleteCustomer(Customer customer) {
		customers.remove(customer);
		
	}

	public static void noCustomer() {
		System.out.println("The Customer Is Not Exist");		
	}

	public static List<Customer> findCustomerByName(String name) {
		List<Customer> customersByName = new ArrayList<>();
		for(Customer c:customers)
		{
			if(c.getName().contains(name))
				customersByName.add(c);
		}
		return customersByName;
	}

	public static void displayCustomer(Customer customer) {
		if(customer==null)
		{
			System.out.println("This customer is not exist");
		}
		else 
			System.out.println("id: "+customer.getId()+"	name: "+customer.getName()+"	phone: "+customer.getPhone()+"	Address: "+customer.getAddress());
	}
	public static void displayCustomers(List<Customer> customers) {
		for(Customer c:customers)
		{
			displayCustomer(c);	
		}
		
	}
}
