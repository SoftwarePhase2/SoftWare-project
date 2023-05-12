package cleaningServices.Acceptance;

import java.util.List;

import cleaning.services.staticdatabase.Customers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Customer;

public class FindCustomerByName {
	List <Customer> customers;

	@When("search about the customer with name {string}")
	public void searchAboutTheCustomerWithName(String name) {
		customers= Customers.findCustomerByName(name);

	}


	@Then("display all information about customers found")
	public void displayAllInformationAboutCustomersFound() {
		Customers.displayCustomers(customers);
	}
	
	
}
