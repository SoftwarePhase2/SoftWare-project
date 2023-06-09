package cleaningServices.Acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cleaning.services.staticdatabase.AppCustomers;
import cleaning.services.staticdatabase.AppProducts;
import cleaning.services.staticdatabase.AppWorkers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.Customer;
import model.Product;

public class AddProduct {
Product product;
String name, category, desc,status;
int id,width,height,idCustomer,idWorker;
@Given("there is a product with id {int}, name {string},category {string}, width {int}, height {int} , description {string} and status {string}")
public void thereIsAProductWithIdNameCategoryWidthHeightDescriptionAndStatus(int id, String name, String category, Integer width, Integer height, String desc, String status) {
	this.id=id;
	this.name=name;
	this.category=category;
	this.desc=desc;
	this.width=width;
	this.height=height;
	this.status=status;
	
}





@Given("the customer id is {int}")
public void theCustomerIdIs(Integer idCustomer) {
	this.idCustomer=idCustomer;

}

@Given("there is an available worker with id")
public void thereIsAnAvailableWorkerWithId() {
	idWorker=AppWorkers.getAvailableWorkerId();
	
}



@Then("the product will be saved in the product list with in treatment state")
public void theProductWillBeSavedInTheProductListWithInTreatmentState() {
	int numOfProductBeforeAdd=AppProducts.getProducts().size();
	product=new Product(id,name,category,width,height,desc,idCustomer,idWorker,"in treatment");
	AppProducts.addProduct(product);
	int numOfProductAfterAdd=AppProducts.getProducts().size();
	assertEquals(numOfProductBeforeAdd+1,numOfProductAfterAdd);
	assertEquals("in treatment",product.getStatus());

}




@Given("there is not an available worker")
public void thereIsNotAnAvailableWorker() {
	idWorker=AppWorkers.getAvailableWorkerId();
	

}

@Then("the product will be saved in the product list with waiting state")
public void theProductWillBeSavedInTheProductListWithWaitingState() {
	int numOfProductBeforeAdd=AppProducts.getProducts().size();
	product=new Product(id,name,category,width,height,desc,idCustomer,idWorker,"waiting");
	AppProducts.addProduct(product);
	int numOfProductAfterAdd=AppProducts.getProducts().size();
	assertEquals(numOfProductBeforeAdd+1,numOfProductAfterAdd);
	assertEquals( "waiting",product.getStatus());
}


@Then("the worker will be not available")
public void theWorkerWillBeNotAvailable() {
	AppWorkers.getWorkers().get(idWorker).setAvailable(false);
	assertNotEquals(AppWorkers.getAvailableWorkerId(),idWorker);
	
	
}
@Then("the product will not be saves and error message will appear")
public void theProductWillNotBeSavesAndErrorMessageWillAppear() {
	assertNull(AppProducts.findProduct(idCustomer));
	AppProducts.noProduct();

}



}




