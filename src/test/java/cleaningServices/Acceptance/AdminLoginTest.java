package cleaningServices.Acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cleaningServices.MyAppInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdminLoginTest {

	MyAppInfo myAppInfo;
	String password,username;
	public AdminLoginTest()
	{
		myAppInfo = new MyAppInfo();
	}
	
@Given("that the administrator is not logged in")
public void thatTheAdministratorIsNotLoggedIn() {
   assertFalse(myAppInfo.isLoggedIn());
}

@Given("the username is {string}")
public void theUsernameIs(String username) {
	this.username=username;
    
}

@Given("the password is {string}")
public void thePasswordIs(String password) {
	this.password=password;
    
}

@Then("the administrator login succeeds")
public void theAdministratorLoginSucceeds() {
	myAppInfo.loggInCheck(username,password);
	assertTrue(myAppInfo.isLoggedIn());
}

@Then("the administrator will not login")
public void theAdministratorWillNotLogin() {
	myAppInfo.loggInCheck(username,password);
	assertFalse(myAppInfo.isLoggedIn());

}

@Then("show the reason why he can't logged in")
public void showTheReasonWhyHeCanTLoggedIn() {
	myAppInfo.refuseLoggIn();
	
}

}
