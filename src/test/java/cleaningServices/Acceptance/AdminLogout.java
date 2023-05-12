package cleaningServices.Acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cleaning.services.MyAppInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdminLogout {
	MyAppInfo myAppInfo =new MyAppInfo();
	@Given("that the administrator is logged in")
	public void thatTheAdministratorIsLoggedIn() {
		myAppInfo.login();
		assertTrue(myAppInfo.isLoggedIn());
	
	}

	@Then("the administrator will log out")
	public void theAdministratorWillLogOut() {
		myAppInfo.logout();
		assertFalse(myAppInfo.isLoggedIn());
	}

}
