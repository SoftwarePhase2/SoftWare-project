package cleaning.services;

import java.util.Scanner;
import java.util.logging.*;

import cleaning.services.staticdatabase.Customers;
import cleaning.services.staticdatabase.Products;
import cleaning.services.staticdatabase.Workers;
import model.Customer;
import model.Product;

public class MainApp {
	   private static final Logger LOGGER = Logger.getLogger(MainApp.class.getName());

	
	public static void main(String[] args) {
	      LOGGER.setLevel(Level.INFO);
		MyAppInfo myAppInfo=new MyAppInfo();
		Scanner scan=new Scanner(System.in);
		int customerId=3;
		int productId=3;
		
		while(true)
		{
		    LOGGER.info("Enter username: ");
			String username=scan.nextLine().trim();
			if(username.equals("exit"))break;
		    LOGGER.info("Enter password: ");
			myAppInfo.loggInCheck(username,scan.nextLine());
			if(!myAppInfo.isLoggedIn())
			{
				myAppInfo.refuseLoggIn();
				continue;
			}
			
		    LOGGER.info("Hello Admin");
			while(true)
			{
				try {

				LOGGER.info("---------------Menu---------------");
				LOGGER.info("1- Customers");
				LOGGER.info("2- Products");
				LOGGER.info("3- sign out");				
				String open=scan.nextLine();
				if(open.equals("1"))
				{
/////////////////////////////////////////////////////////////////////////////////////////////////////////					
					while(true)
					{
						LOGGER.info("---------------Customers---------------");
						LOGGER.info("0- display Customers");
						LOGGER.info("1- Add Customer");
						LOGGER.info("2- Find Customers");
						LOGGER.info("3- Update Customer Information");
						LOGGER.info("4- Delete Customer");
						LOGGER.info("5- Back");
						
						String openCus=scan.nextLine();
						if(openCus.equals("0"))
						{
							Customers.displayCustomers(Customers.getCutomers());
						}
						else if(openCus.equals("1"))
						{
							LOGGER.info("Please Enter customer name");
							String name=scan.nextLine();
							LOGGER.info("Please Enter customer phone");
							int phone=scan.nextInt();
							LOGGER.info("Please Enter customer address");
							scan.nextLine();
							Customer customer=new Customer(customerId++, phone, name, scan.nextLine());
							Customers.addCustomer(customer);
							LOGGER.info("The customer is added successfully");

						}
						else if(openCus.equals("2"))
						{
							while(true)
							{
								LOGGER.info("---------------Find Customers---------------");
								LOGGER.info("1- Find Customer By ID");
								LOGGER.info("2- Find Customers By Name");
								LOGGER.info("3- Back");
								String openCusFind=scan.nextLine();
								if(openCusFind.equals("1"))
								{
									LOGGER.info("The ID of the customer you want: ");
									Customers.displayCustomer(Customers.findCustomer(scan.nextInt()));
									scan.nextLine();
									
								}
								else if(openCusFind.equals("2"))
								{
									LOGGER.info("The name of the customers you want: ");
									Customers.displayCustomers(Customers.findCustomerByName(scan.nextLine()));
								}
								else if(openCusFind.equals("3"))
								{
									break;
								}
								else 
								{
									LOGGER.warning("Please enter valid input");
								}

								
							}
						}
						else if(openCus.equals("3"))
						{
							LOGGER.info("The ID of the customer for updating: ");
							Customer customerUpdate = Customers.findCustomer(scan.nextInt());
							scan.nextLine();
							Customers.displayCustomer(customerUpdate);
							if(customerUpdate==null)
							{
								break;
							}
							while(true)
							{
								LOGGER.info("---------------Update Customer---------------");
								LOGGER.info("1- Change Name");
								LOGGER.info("2- Change Phone");
								LOGGER.info("3- Change Address");
								LOGGER.info("4- Back");

								String openCusFind=scan.nextLine();
								if(openCusFind.equals("1"))
								{
									LOGGER.info("The new name of the customer you want to update: ");
									customerUpdate.setName(scan.nextLine());
									Customers.displayCustomer(customerUpdate);
									
								}
								else if(openCusFind.equals("2"))
								{
									LOGGER.info("The new phone number of the customer you want to update: ");
									customerUpdate.setPhone(scan.nextInt());
									scan.nextLine();
									Customers.displayCustomer(customerUpdate);
								}
								else if(openCusFind.equals("3"))
								{
									LOGGER.info("The new address of the customer you want to update: ");
									customerUpdate.setAddress(scan.nextLine());
									Customers.displayCustomer(customerUpdate);
								}
								else if(openCusFind.equals("4"))
								{
									break;
								}
								else 
								{
									LOGGER.info("Please enter valid input");

								}
								
							}
							
						}
						else if(openCus.equals("4"))
						{
							LOGGER.info("The ID of the customer for deleting: ");
							Customer customerDelete = Customers.findCustomer(scan.nextInt());
							scan.nextLine();
							Customers.deleteCustomer(customerDelete);
							if(customerDelete==null)
							{
								Customers.noCustomer();
							}
							else
							{
								LOGGER.info("Deleted successfully");
							}
						}
						else if(openCus.equals("5"))
						{
							break;
						}
						else
						{
							LOGGER.info("Please enter valid input");

						}
						
					}
					
				}
				else if(open.equals("2"))
				{
//////////////////////////////////////////					/////////////////////
					while(true)
					{
						LOGGER.info("---------------Products---------------");
						LOGGER.info("0- display Products");
						LOGGER.info("1- Add Product");
						LOGGER.info("2- Find Products");
						LOGGER.info("3- Update Product Information");
						LOGGER.info("4- Delelte product");
						LOGGER.info("5- Back");

						
						String openPro=scan.nextLine();
						if(openPro.equals("0"))
						{
							Products.displayProducts(Products.getProducts());
						}
						else if(openPro.equals("1"))
						{
							LOGGER.info("Please Enter product name");
							String name=scan.nextLine();
							LOGGER.info("Please Enter product catogery");
							String catogery;
							while(true)
							{
								LOGGER.info("The categories: ");
								LOGGER.info("1- carpets");
								LOGGER.info("2- covers");
								catogery=scan.nextLine();
								if(catogery.equals("1"))
								{
									catogery="carpets";
									break;
								}
								else if(catogery.equals("2"))
								{
									catogery="covers";
									break;
								}
								else
								{
									LOGGER.warning("Pleast enter valid input");
								}
								
							}	
							LOGGER.info("Please Enter product width");
							int width=scan.nextInt();
							LOGGER.info("Please Enter product height");
							int height=scan.nextInt();
							LOGGER.info("Please Enter product description");
							scan.nextLine();
							String description=scan.nextLine();
							LOGGER.info("Please Enter product idCustomer");
							int idCustomer=scan.nextInt();
							scan.nextLine();
							if(Customers.findCustomer(idCustomer)==null)
							{
								Customers.noCustomer();
								continue;
							}
							int idWorker=Workers.getAvailableWorkerId();
							String status;
							
							if(idWorker==-1)
							{
								status="waiting";
								LOGGER.info("The product is in waiting status");
							}
							else
							{
								status="in treatment";
								LOGGER.info("The product is in treatment status");
								Workers.getWorkers().get(idWorker).setAvailable(false);
							}
							Product product=new Product(productId++,name,catogery,width,height,description,idCustomer,idWorker,status);
							Products.addProduct(product);
							if(AppCalculations.calculatePriceForAllProducts(idCustomer)>400)
							{
								LOGGER.info("Congratulations you have a discount because you use the service with an amount of money > 400 ");
								LOGGER.info("The old price is: " + AppCalculations.calculatePrice(height, width, catogery));
								LOGGER.info("The new price is: " + AppCalculations.calculatePriceWithDiscount(height, width, catogery));
							}
							else
							{
								LOGGER.info("The price is: " + AppCalculations.calculatePrice(height,width,catogery));

							}
							
						}
						else if(openPro.equals("2"))
						{
							while(true)
							{
								LOGGER.info("---------------Find Products---------------");
								LOGGER.info("1- Find Product By ID");
								LOGGER.info("2- Find Products By Name");
								LOGGER.info("3- Back");

								String openProFind=scan.nextLine();
								if(openProFind.equals("1"))
								{
									LOGGER.info("The ID of the product you want: ");
									Products.displayProduct(Products.findProduct(scan.nextInt()));
									scan.nextLine();
									
								}
								else if(openProFind.equals("2"))
								{
									LOGGER.info("The name of the product you want: ");

									Products.displayProducts(Products.findProductsByName(scan.nextLine()));
								}
								else if(openProFind.equals("3"))
								{
									break;
								}
								else 
								{
									LOGGER.warning("Please enter valid input");


								}

								
							}
						}
						else if(openPro.equals("3"))
						{
							while(true)
							{
								LOGGER.info("The ID of the product for updating: ");

								int productIdUpdated=scan.nextInt();
								Product productUpdate = Products.findProduct(productIdUpdated);
								if(productUpdate==null)
								{
									Products.noProduct();
									scan.nextLine();
									break;
								}
								Products.displayProduct(productUpdate);
								LOGGER.info("---------------Update Product---------------");
								LOGGER.info("1- Change Name");
								LOGGER.info("2- Change Status");
								LOGGER.info("3- Back");

								scan.nextLine();
								String openProFind=scan.nextLine();
								if(openProFind.equals("1"))
								{
									LOGGER.info("The name of the Product you want to update: ");

									productUpdate.setName(scan.nextLine());
									Products.displayProduct(productUpdate);
									
								}
								else if(openProFind.equals("2"))
								{
									String statusNumber;
									while(true)
									{
										LOGGER.info("The new status: ");
										LOGGER.info("1- waiting");
										LOGGER.info("2- in treatment: ");
										LOGGER.info("3- complete: ");
										LOGGER.info("4- back: ");

										statusNumber=scan.nextLine();
										String prevStatus=productUpdate.getStatus();
										if(statusNumber.equals("1"))
										{
											statusNumber="waiting";
											break;
										}
										else if(statusNumber.equals("2"))
										{
											statusNumber="in treatment";
											int idWorkerUpdated=Workers.getAvailableWorkerId();
											if(idWorkerUpdated==-1)
											{
												LOGGER.warning("No available worker");
												continue;
											}
											Products.getProducts().get(productIdUpdated).setIdWorker(idWorkerUpdated);
											Workers.getWorkers().get(idWorkerUpdated).setAvailable(false);
											break;
										}
										else if(statusNumber.equals("3"))
										{
											if(prevStatus.equals("waiting"))
											{
												LOGGER.info("This product does not cleaned yet");
												continue;
											}
											statusNumber="complete";
											Workers.getWorkers().get(Products.getProducts().get(productIdUpdated).getIdWorker()).setAvailable(true);;
											break;
										}
										else if(statusNumber.equals("4"))
										{
											break;
										}
										else
										{
											LOGGER.info("Pleast enter valid input");

										}
										
									}
									
									productUpdate.setStatus(statusNumber);
									Products.displayProduct(productUpdate);
								}
								else if(openProFind.equals("3"))
								{
									break;
								}
								else 
								{
									LOGGER.warning("Please enter valid input");


								}
								break;

								
							}
							
						}
						else if(openPro.equals("4"))
						{
							LOGGER.info("The ID of the product for deleting: ");

							Product productDelete = Products.findProduct(scan.nextInt());
							scan.nextLine();
							Products.deleteProduct(productDelete);
							if(productDelete==null)
							{
								Products.noProduct();
							}
							else
							{
								LOGGER.info("Deleted successfully");

							}
						}
						else if(openPro.equals("5"))
						{
							break;
						}
						else
						{
							LOGGER.warning("Please enter valid input");

						}
					}

////////////////////////////////////////////////////////////////////////////////////
				}
				else if(open.equals("3"))
				{
					myAppInfo.logout();
					break;					
				}
				else 
				{
					LOGGER.info("Please enter valid input");

				}
				

				}
				catch (Exception e)
				{
					LOGGER.info("Please enter valid input");

					scan.nextLine();
				}
			}
			
			
			
			
		}
		
		

	}

}
