package cleaning.services;

import java.util.logging.Logger;

import cleaning.services.staticdatabase.AdminDB;
import model.AdminInfo;

public class MyAppInfo {
	private static final Logger LOGGER = Logger.getLogger(MyAppInfo.class.getName());
	private boolean isLoggedIn;
	
	public MyAppInfo() {
		this.isLoggedIn = false;
		AppLogger.setLevel(LOGGER);
	}
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void logout() {
		isLoggedIn=false;
	}
	public void refuseLoggIn() {
		LOGGER.info("The username or the password is not correct");
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
