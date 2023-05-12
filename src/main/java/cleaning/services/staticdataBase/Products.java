package cleaning.services.staticdatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import model.Product;

public class Products {
	   private static final Logger LOGGER = Logger.getLogger(Products.class.getName());
	   private static String COMPLETE = "complete";  // Compliant

	   private static List<Product> products=new ArrayList();

	   private Products() {
		    throw new IllegalStateException("Utility class");
	   }
        static
        {
        	LOGGER.setLevel(Level.INFO);
        	products.add(new Product(0,"pro1","carpets",15,20,"desc",1,1,COMPLETE));
        	products.add(new Product(1,"pro2","covers",10,20,"desc",0,2,COMPLETE));
        	products.add(new Product(2,"pro3","covers",10,20,"desc",1,0,COMPLETE));
        	
        }

	public static List<Product> getProducts() {
		return products;
	}

	public static void addProduct(Product product) {
		products.add(product);
	}
	
	public static Product findProduct(Integer id) {
		for(Product pro:Products.getProducts())
		{
			if(pro.getId()==id) 
			{
				return pro;
			}
		}
		return null;
		
	}

	public static void displayProduct(Product product) {
		if(product==null)
		{
			LOGGER.info("This product is not exist");
		}
		else 
			LOGGER.info(" Id: "+product.getId()+" name: "+product.getName()+"\tcategory: "+product.getCategory()+"\tdescription: "+product.getDescription()+"\twidth: "+product.getWidth()+" height: "+product.getHeight()+" owner customer id: "+product.getIdCustomer()+" worker id: "+product.getIdWorker()+" status: "+product.getStatus());
	}
	public static void displayProducts(List<Product> product) {
		for(Product p:product)
		{
			displayProduct(p);	
		}
		
	}
	public static void deleteProduct(Product proudct) {
		products.remove(proudct);
		
	}

	public static void noProduct() {
		LOGGER.warning("The Product Is Not Exist");
	}

	public static List<Product> findProductsByName(String name) {
		List<Product> productsByName=new ArrayList<Product>();
		for(Product product : products)
		{
			if(product.getName().contains(name)) 
			{
				productsByName.add(product);	
			}
		}
		return productsByName;
	}
	
	

}
