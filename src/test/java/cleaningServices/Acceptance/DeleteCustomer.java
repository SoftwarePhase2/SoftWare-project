package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;

import cleaning.services.staticdatabas.AppCustomers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.Customer;

public class DeleteCustomer {
	Customer customerForDelete;
	@Given("there is a customer with id {int}")
	public void thereIsACustomerWithId(Integer id) {
		customerForDelete = AppCustomers.findCustomer(id);
	}

	@Then("the customer will be deleted from the customer list")
	public void theCustomerWillBeDeletedFromTheCustomerList() {
		AppCustomers.deleteCustomer(customerForDelete);
	}

	@Then("the message that the customer is not exist will be print")
	public void theMessageThatTheCustomerIsNotExistWillBePrint() {
		AppCustomers.noCustomer();
	}

}
