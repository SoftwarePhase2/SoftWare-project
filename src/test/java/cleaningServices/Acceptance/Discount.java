package cleaningServices.Acceptance;

import static org.junit.Assert.assertTrue;

import cleaning.services.AppCalculations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Discount {
	int height ,width;
	String catogery;

	@Given("the total money for this customer is above {int}")
	public void theTotalMoneyForThisCustomerIsAbove(Integer priceForDiscount) {
		assertTrue(AppCalculations.calculatePriceForAllProducts(1)>priceForDiscount);
	}

	@Given("product with hieght {int}, width {int} , catogery {string}")
	public void productWithHieghtWidthCatogery(Integer height, Integer width, String catogery) {
		this.width=width;
		this.height=height;	
		this.catogery=catogery;
	}
	@Then("the customer will have a discount by {double} for the total price")
	public void theCustomerWillHaveADiscountByForTheTotalPrice(Double discountRate) {
		int priceWithDiscount=AppCalculations.calculatePriceWithDiscount(height, width, catogery);
		assertTrue(AppCalculations.calculatePrice(height, width, catogery)*(1-discountRate)==priceWithDiscount);
		
	}
}
