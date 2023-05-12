package cleaning.services;

import cleaning.services.staticdataBase.Products;
import model.Product;

public class AppCalculations {
	
	private AppCalculations() {
	    throw new IllegalStateException("Utility class");
	  }

	public static Integer calculatePrice(int height, int width, String catogery) {
		if(catogery.equals("covers"))
		{
			return height * width;
		}
		else if(catogery.equals("carpets"))
		{
			return height * width *2;
		}
		else return 0;
	}

	public static int calculatePriceWithDiscount(int height, int width, String catogery) {
		return (int) Math.round(calculatePrice(height,width,catogery)*(1-0.25));
	}
	
	public static Integer calculatePriceForAllProducts(int id) {
		int sum=0;
		for(Product prodcut:Products.getProducts())
		{
			if(prodcut.getIdCustomer()==id)
			{
				sum+=calculatePrice(prodcut.getHeight(),prodcut.getWidth(), prodcut.getCategory());
			}
		}
		return sum;
		
	}

	
	
	
	

}
