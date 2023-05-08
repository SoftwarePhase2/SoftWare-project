package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Product;
import cleaningServices.StaticDataBase.*;

public class findProductByName {

	
	
List <Product> products;

@Given("search about the product with name {string}")
public void searchAboutTheProductWithName(String name) {
	products= Products.findProductsByName(name);	
}

@Then("display all information about products found")
public void displayAllInformationAboutProductsFound() {
	Products.displayProducts(products);
	assertEquals(1, products.get(0).getId());

}


}
