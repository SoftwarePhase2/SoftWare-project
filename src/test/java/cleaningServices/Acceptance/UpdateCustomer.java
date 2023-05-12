package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cleaning.services.staticdatabas.AppCustomers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Customer;

public class UpdateCustomer {
	Customer customer;
	@When("the admin want to change the name of the customer to {string}")
	public void theAdminWantToChangeTheNameOfTheCustomerTo(String name) {
	    customer = AppCustomers.findCustomer(2);
		customer.setName(name);
	}

	@Then("the customer's name should be {string}")
	public void theCustomerSNameShouldBe(String name) {
		assertEquals(customer.getName(),name);
	}

	@When("the admin want to change the address of the customer to {string}")
	public void theAdminWantToChangeTheAddressOfTheCustomerTo(String address) {
		customer = AppCustomers.findCustomer(2);
		customer.setAddress(address);
	}

	@Then("the customer's address should be {string}")
	public void theCustomerSAddressShouldBe(String address) {
		assertEquals(customer.getAddress(),address);
	   
	}

	@When("the admin want to change the phone of the customer to {int}")
	public void theAdminWantToChangeThePhoneOfTheCustomerTo(Integer phone) {
		customer = AppCustomers.findCustomer(2);
		customer.setPhone(phone);
	}

	@Then("the customer's phone should be {int}")
	public void theCustomerSPhoneShouldBe(Integer phone) {
		assertEquals((int)phone, customer.getPhone());

	   
	}


}
