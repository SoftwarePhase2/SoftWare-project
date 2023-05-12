package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import cleaning.services.staticdatabas.AppProducts;
import io.cucumber.java.en.Then;
import model.Product;

public class DeleteProduct {
	
	Product product=AppProducts.findProduct(2);
	@Then("the product will be deleted from the product list")
	public void theProductWillBeDeletedFromTheProductList() {
		int sizeBeforeDelete=AppProducts.getProducts().size();
	    AppProducts.deleteProduct(product);
	    assertEquals(sizeBeforeDelete,AppProducts.getProducts().size()+1);
	}

	@Then("the message that the product is not exist will be print")
	public void theMessageThatTheProductIsNotExistWillBePrint() {
		assertNull(product);
		AppProducts.noProduct();
	}



}
