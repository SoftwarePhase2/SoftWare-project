package cleaningServices.Acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cleaning.services.staticdatabase.*;

public class UpdateProduct {	

Product product;


@Given("there is a product with id {int}")
public void thereIsAProductWithId(Integer id) {
	product = AppProducts.findProduct(id);
}

@When("the admin want to change the name of the product to {string}")
public void theAdminWantToChangeTheNameOfTheProductTo(String name) {
	product.setName(name);
}
@Then("the product's name should be {string}")
public void theProductSNameShouldBe(String name) {
	assertEquals( product.getName(),name);
}

@When("the admin want to change the status of the product to {string}")
public void theAdminWantToChangeTheStatusOfTheProductTo(String status) {
	product.setStatus(status);

}

@Then("the product's Status should be {string}")
public void theProductSStatusShouldBe(String status) {
	assertEquals(product.getStatus(),status);
}


}
