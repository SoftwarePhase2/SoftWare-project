package cleaning.services.staticdatabas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import cleaning.services.AppLogger;
import model.Customer;

public class AppCustomers {
	
	
	private AppCustomers() {
	    throw new IllegalStateException("Utility class");
	}
	private static final Logger LOGGER = Logger.getLogger(AppCustomers.class.getName());
	private static List <Customer> customers=new ArrayList<Customer>();
        
        static
        {
        	AppLogger.setLevel(LOGGER);
        	customers.add(new Customer(0,12345,"ahmad","jenin"));
        	customers.add(new Customer(1,12345,"mohammad","jerusalem"));
        	customers.add(new Customer(2,12345,"khaled","hebron"));
        }


	public static List<Customer> getCutomers() {
		return customers;
	}

	public static void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public static Customer findCustomer(int id) {
		for(Customer customer:AppCustomers.getCutomers())
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
		LOGGER.warning("The Customer Is Not Exist");
	}

	public static List<Customer> findCustomerByName(String name) {
		List<Customer> customersByName = new ArrayList();
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
			LOGGER.warning("This customer is not exist");
		}
		else 
			LOGGER.info("id: "+customer.getId()+"\tname: "+customer.getName()+"\tphone: "+customer.getPhone()+"\tAddress: "+customer.getAddress());
	}
	public static void displayCustomers(List<Customer> customers) {
		for(Customer c:customers)
		{
			displayCustomer(c);	
		}
		
	}
}
