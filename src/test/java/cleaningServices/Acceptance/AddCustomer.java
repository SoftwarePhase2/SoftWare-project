package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleaning.services.MyAppInfo;
import cleaning.services.staticdatabase.Customers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.Customer;

public class AddCustomer {
	MyAppInfo myAppInfo= new MyAppInfo();
	Customer customer;
	
	@Given("that the administrator is loged in")
	public void thatTheAdministratorIsLogedIn() {
		myAppInfo.login();
	}

	@Given("there is a customer with id {int},phone {int}, name {string} and address {string}")
	public void thereIsACustomerWithIdPhoneNameAndAddress(Integer id, Integer phone, String name, String address) {
	  customer = new Customer(id, phone, name, address);
	}

	@Then("the customer will be saved in the list")
	public void theCustomerWillBeSavedInTheList() {
		Customers.addCustomer(customer);
		assertEquals(customer, Customers.getCutomers().get(Customers.getCutomers().size()-1));
	}

	

}
