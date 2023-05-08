package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;

import cleaningServices.AppCalculations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalculatePrice {

	int height,width;
	String catogery;
	@Given("the height of the product {int}")
	public void theHeightOfTheProduct(Integer height) {
		this.height=height;
	}

	@Given("the width of the product {int}")
	public void theWidthOfTheProduct(Integer width) {
		this.width=width;
	}

	@Given("the catogery of the product {string}")
	public void theCatogeryOfTheProduct(String catogery) {
		this.catogery=catogery;
	}

	@Then("the result will be {int}")
	public void theResultWillBe(Integer result) {
		assertEquals( AppCalculations.calculatePrice(height,width,catogery), result);
	}
}
