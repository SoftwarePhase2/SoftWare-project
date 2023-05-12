package cleaning.services;

import java.util.Scanner;

import cleaning.services.staticdataBase.Customers;
import cleaning.services.staticdataBase.Products;
import cleaning.services.staticdataBase.Workers;
import java.util.logging.*;
import model.Customer;
import model.Product;

public class MainApp {
	   private static final Logger LOGGER = Logger.getLogger(MainApp.class.getName());

	
	public static void main(String[] args) {
	      LOGGER.setLevel(Level.INFO);

//	      ConsoleHandler consoleHandler = new ConsoleHandler();
//	      consoleHandler.setLevel(Level.ALL);
//	      LOGGER.addHandler(consoleHandler);
		
		MyAppInfo myAppInfo=new MyAppInfo();
		Scanner scan=new Scanner(System.in);
		int customerId=3;
		int productId=3;
		
		while(true)
		{
		    LOGGER.info("Enter username: ");
			String username=scan.nextLine().trim();
			if(username.equals("exit"))break;
			System.out.print("Enter password: ");
			myAppInfo.loggInCheck(username,scan.nextLine());
			if(!myAppInfo.isLoggedIn())
			{
				myAppInfo.refuseLoggIn();
				continue;
			}
			System.out.println("Hello Admin");
			while(true)
			{
				try {

				System.out.println();
				System.out.println();
				System.out.println("---------------Menu---------------");
				System.out.println("1- Customers");
				System.out.println("2- Products");
				
				System.out.println("3- sign out");
				String open=scan.nextLine();
				if(open.equals("1"))
				{
/////////////////////////////////////////////////////////////////////////////////////////////////////////					
					while(true)
					{
						System.out.println();
						System.out.println();
						System.out.println("---------------Customers---------------");
						System.out.println("0- display Customers");
						System.out.println("1- Add Customer");
						System.out.println("2- Find Customers");						
						System.out.println("3- Update Customer Information");
						System.out.println("4- Delete Customer");
						System.out.println("5- Back");
						
						String openCus=scan.nextLine();
						if(openCus.equals("0"))
						{
							Customers.displayCustomers(Customers.getCutomers());
						}
						else if(openCus.equals("1"))
						{
							System.out.println("Please Enter customer name");
							String name=scan.nextLine();
							System.out.println("Please Enter customer phone");
							int phone=scan.nextInt();
							System.out.println("Please Enter customer address");
							scan.nextLine();
							Customer customer=new Customer(customerId++, phone, name, scan.nextLine());
							Customers.addCustomer(customer);
							System.out.println("The customer is added successfully");

						}
						else if(openCus.equals("2"))
						{
							while(true)
							{
								System.out.println();
								System.out.println();
								System.out.println("---------------Find Customers---------------");
								System.out.println("1- Find Customer By ID");
								System.out.println("2- Find Customers By Name");
								System.out.println("3- Back");
								
								String openCusFind=scan.nextLine();
								if(openCusFind.equals("1"))
								{
									System.out.print("The ID of the customer you want: ");
									Customers.displayCustomer(Customers.findCustomer(scan.nextInt()));
									scan.nextLine();
									
								}
								else if(openCusFind.equals("2"))
								{
									System.out.print("The name of the customers you want: ");
									Customers.displayCustomers(Customers.findCustomerByName(scan.nextLine()));
								}
								else if(openCusFind.equals("3"))
								{
									break;
								}
								else 
								{
									System.out.println("Please enter valid input");

								}

								
							}
						}
						else if(openCus.equals("3"))
						{
							System.out.print("The ID of the customer for updating: ");
							Customer customerUpdate = Customers.findCustomer(scan.nextInt());
							scan.nextLine();
							Customers.displayCustomer(customerUpdate);
							while(true)
							{
								if(customerUpdate==null)
								{
									break;
								}
								System.out.println();
								System.out.println();
								System.out.println("---------------Update Customer---------------");
								System.out.println("1- Change Name");
								System.out.println("2- Change Phone");
								System.out.println("3- Change Address");
								System.out.println("4- Back");
								String openCusFind=scan.nextLine();
								if(openCusFind.equals("1"))
								{
									System.out.print("The new name of the customer you want to update: ");
									customerUpdate.setName(scan.nextLine());
									Customers.displayCustomer(customerUpdate);
									
								}
								else if(openCusFind.equals("2"))
								{
									System.out.print("The new phone number of the customer you want to update: ");
									customerUpdate.setPhone(scan.nextInt());
									scan.nextLine();
									Customers.displayCustomer(customerUpdate);
								}
								else if(openCusFind.equals("3"))
								{
									System.out.print("The new address of the customer you want to update: ");
									customerUpdate.setAddress(scan.nextLine());
									Customers.displayCustomer(customerUpdate);
								}
								else if(openCusFind.equals("4"))
								{
									break;
								}
								else 
								{
									System.out.println("Please enter valid input");

								}
								
							}
							
						}
						else if(openCus.equals("4"))
						{
							System.out.print("The ID of the customer for deleting: ");
							Customer customerDelete = Customers.findCustomer(scan.nextInt());
							scan.nextLine();
							Customers.deleteCustomer(customerDelete);
							if(customerDelete==null)
							{
								Customers.noCustomer();
							}
							else
							{
								System.out.println("Deleted successfully");
							}
						}
						else if(openCus.equals("5"))
						{
							break;
						}
						else
						{
							System.out.println("Please enter valid input");
						}
						
					}
					
				}
				else if(open.equals("2"))
				{
//////////////////////////////////////////					/////////////////////
					while(true)
					{
						System.out.println();
						System.out.println();
						System.out.println("---------------Products---------------");
						System.out.println("0- display Products");
						System.out.println("1- Add Product");
						System.out.println("2- Find Products");						
						System.out.println("3- Update Product Information");
						System.out.println("4- Delelte product");
						System.out.println("5- Back");
						
						String openPro=scan.nextLine();
						if(openPro.equals("0"))
						{
							Products.displayProducts(Products.getProducts());
						}
						else if(openPro.equals("1"))
						{
							System.out.println("Please Enter product name");
							String name=scan.nextLine();
							System.out.println("Please Enter product catogery");
							String catogery;
							while(true)
							{
								System.out.println("The categories: ");
								System.out.println("1- carpets");
								System.out.println("2- covers");
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
									System.out.println("Pleast enter valid input");
								}
								
							}	
							System.out.println("Please Enter product width");
							int width=scan.nextInt();
							System.out.println("Please Enter product height");
							int height=scan.nextInt();
							System.out.println("Please Enter product description");
							scan.nextLine();
							String description=scan.nextLine();
							System.out.println("Please Enter product idCustomer");
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
								System.out.println("The product is in waiting status");
							}
							else
							{
								status="in treatment";
								System.out.println("The product is in treatment status");
								Workers.getWorkers().get(idWorker).setAvailable(false);
							}
							Product product=new Product(productId++,name,catogery,width,height,description,idCustomer,idWorker,status);
							Products.addProduct(product);
							if(AppCalculations.calculatePriceForAllProducts(idCustomer)>400)
							{
								System.out.print("Congratulations you have a discount because you use the service with an amount of money > 400 ");
								System.out.print("The old price is: ");
								System.out.println(AppCalculations.calculatePrice(height, width, catogery));
								System.out.print("The new price is: ");
								System.out.print(AppCalculations.calculatePriceWithDiscount(height, width, catogery));
							}
							else
							{
								System.out.print("The price is: ");
								System.out.print(AppCalculations.calculatePrice(height,width,catogery));							
								
							}
							
						}
						else if(openPro.equals("2"))
						{
							while(true)
							{
								System.out.println();
								System.out.println();
								System.out.println("---------------Find Products---------------");
								System.out.println("1- Find Product By ID");
								System.out.println("2- Find Products By Name");
								System.out.println("3- Back");
								String openProFind=scan.nextLine();
								if(openProFind.equals("1"))
								{
									System.out.print("The ID of the product you want: ");
									Products.displayProduct(Products.findProduct(scan.nextInt()));
									scan.nextLine();
									
								}
								else if(openProFind.equals("2"))
								{
									System.out.print("The name of the product you want: ");
									Products.displayProducts(Products.findProductsByName(scan.nextLine()));
								}
								else if(openProFind.equals("3"))
								{
									break;
								}
								else 
								{
									System.out.println("Please enter valid input");

								}

								
							}
						}
						else if(openPro.equals("3"))
						{
							while(true)
							{
								System.out.print("The ID of the product for updating: ");
								int productIdUpdated=scan.nextInt();
								Product productUpdate = Products.findProduct(productIdUpdated);
								if(productUpdate==null)
								{
									Products.noProduct();
									scan.nextLine();
									break;
								}
								Products.displayProduct(productUpdate);
								System.out.println();
								System.out.println();
								System.out.println("---------------Update Product---------------");
								System.out.println("1- Change Name");
								System.out.println("2- Change Status");
								System.out.println("3- Back");
								scan.nextLine();
								String openProFind=scan.nextLine();
								if(openProFind.equals("1"))
								{
									System.out.print("The name of the Product you want to update: ");
									productUpdate.setName(scan.nextLine());
									Products.displayProduct(productUpdate);
									
								}
								else if(openProFind.equals("2"))
								{
									String statusNumber;
									while(true)
									{
										System.out.println("The new status: ");
										System.out.println("1- waiting");
										System.out.println("2- in treatment: ");
										System.out.println("3- complete: ");
										System.out.println("4- back: ");
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
												System.out.println("No available worker");
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
												System.out.println("This product does not cleaned yet");
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
											System.out.println("Pleast enter valid input");
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
									System.out.println("Please enter valid input");

								}
								break;

								
							}
							
						}
						else if(openPro.equals("4"))
						{
							System.out.print("The ID of the product for deleting: ");
							Product productDelete = Products.findProduct(scan.nextInt());
							scan.nextLine();
							Products.deleteProduct(productDelete);
							if(productDelete==null)
							{
								Products.noProduct();
							}
							else
							{
								System.out.println("Deleted successfully");
							}
						}
						else if(openPro.equals("5"))
						{
							break;
						}
						else
						{
							System.out.println("Please enter valid input");
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
					System.out.println("Please enter valid input");
				}
				

				}
				catch (Exception e)
				{
					System.out.println("Please enter valid input");
					scan.nextLine();
				}
			}
			
			
			
			
		}
		
		

	}

}
