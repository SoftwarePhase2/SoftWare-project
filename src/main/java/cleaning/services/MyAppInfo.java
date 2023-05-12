package cleaning.services;

import cleaning.services.staticdatabase.AdminDB;
import model.AdminInfo;

public class MyAppInfo {
	private boolean isLoggedIn;
	
	public MyAppInfo() {
		this.isLoggedIn = false;
	}
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void logout() {
		isLoggedIn=false;
	}
	public void refuseLoggIn() {
		System.out.println("The username or the password is not correct");

	}
	public void login() {
		isLoggedIn=true;
	}
	public void loggInCheck(String username, String password) {
		for(AdminInfo admin:AdminDB.getAdmins())
		{
			if (username.equals(admin.getUsername()) && password.equals(admin.getPassword()))
			{
				login();
			}
		}
	}


	

	

	
	
	

}
