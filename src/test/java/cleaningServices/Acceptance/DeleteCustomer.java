package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;

import cleaning.services.staticdatabase.Customers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.Customer;

public class DeleteCustomer {
	Customer customerForDelete;
	@Given("there is a customer with id {int}")
	public void thereIsACustomerWithId(Integer id) {
		customerForDelete = Customers.findCustomer(id);
	}

	@Then("the customer will be deleted from the customer list")
	public void theCustomerWillBeDeletedFromTheCustomerList() {
		Customers.deleteCustomer(customerForDelete);
	}

	@Then("the message that the customer is not exist will be print")
	public void theMessageThatTheCustomerIsNotExistWillBePrint() {
		Customers.noCustomer();
	}

}
