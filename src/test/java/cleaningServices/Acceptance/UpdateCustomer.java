package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cleaning.services.staticdatabase.Customers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Customer;

public class UpdateCustomer {
	Customer customer;
	@When("the admin want to change the name of the customer to {string}")
	public void theAdminWantToChangeTheNameOfTheCustomerTo(String name) {
	    customer = Customers.findCustomer(2);
		customer.setName(name);
	}

	@Then("the customer's name should be {string}")
	public void theCustomerSNameShouldBe(String name) {
		assertTrue(customer.getName().equals(name));
	}

	@When("the admin want to change the address of the customer to {string}")
	public void theAdminWantToChangeTheAddressOfTheCustomerTo(String address) {
		customer = Customers.findCustomer(2);
		customer.setAddress(address);
	}

	@Then("the customer's address should be {string}")
	public void theCustomerSAddressShouldBe(String address) {
		assertTrue(customer.getAddress().equals(address));
	   
	}

	@When("the admin want to change the phone of the customer to {int}")
	public void theAdminWantToChangeThePhoneOfTheCustomerTo(Integer phone) {
		customer = Customers.findCustomer(2);
		customer.setPhone(phone);
	}

	@Then("the customer's phone should be {int}")
	public void theCustomerSPhoneShouldBe(Integer phone) {
		assertTrue(customer.getPhone()==phone);

	   
	}


}
