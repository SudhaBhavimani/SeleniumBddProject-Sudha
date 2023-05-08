package stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.addCustomer;
import pageObjects.loginPage;
import pageObjects.searchCustomer;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 

public class Steps extends BaseClass {
	
 
 

@Given("User launch chrome browser")
public void user_launch_chrome_browser() throws IOException {
	config=new Properties();
	FileInputStream configPropFile = new FileInputStream("config.properties");
	config.load(configPropFile);
	logger=Logger.getLogger("Myproj8");

	PropertyConfigurator.configure("log4j.properties");
	
	System.setProperty("webdriver.chrome.driver",config.getProperty("chromePath"));
	
	 	
	driver = new ChromeDriver();
	
	
	logger.info("*****launching Chrome browser********");
	
	
	lp= new loginPage(driver);
	
}

@When("User open URL {string}")
public void user_open_url(String url) {

driver.get(url);
logger.info("*****launching url*****");
driver.manage().window().maximize();
     
}

@When("User enter email as {string} and password as {string}")
public void user_enter_email_as_and_password_as(String email, String psw) {
	logger.info("*****Providing user credentials *****");
	lp.setUserMail(email);
	lp.setUserPsw(psw);
     
}

@When("Click on login")
public void click_on_login() {
	
	lp.clickLogin();
	
     
}

@Then("Page Title should be {string}")
public void page_title_should_be(String title) {
	if(driver.getPageSource().contains("Login was unsuccessful.")) {
		driver.close();
		logger.info("*****Expected result : Login fail : provided invalid credentals *****");
		Assert.assertTrue(false);
	}
	else 
	{
		logger.info("*****Expected result : Login pass : provided valid credentals *****");
		Assert.assertEquals(title, driver.getTitle());
	}
	
    
      
}

@When("User click on log out link")
public void user_click_on_log_out_link() throws InterruptedException {
	
	logger.info("*****Logout*****");
	
	lp.clickLogout();
    Thread.sleep(3000);
}

 

@Then("Close browser")
public void close_browser() {
	driver.quit();
    
}
//-------------------------add customer steps -------------//



@Then("User can view dashboard")
public void user_can_view_dashboard() throws InterruptedException {
	
	logger.info("*****User successfully logged in and can vew dashboard*****");
	
	 addObj = new addCustomer(driver);
	 Assert.assertEquals("Dashboard / nopCommerce administration", addObj.getDashboardTitle());
	 Thread.sleep(3000);
	 
	 
}

@Then("Click on customer menu")
public void click_on_customer_menu() throws InterruptedException {
	
	logger.info("*****clicking on customer menu*****");
	
	addObj.clickOnCustomerMenu();
	addObj.clickOnCustomer();
     Thread.sleep(3000);
}

@Then("Click on New")
public void click_on_New() {
	
	logger.info("*****click on add custome*****");
	
	addObj.clickOnAddNew();
    
}

@Then("User can view and add new custmore page")
public void user_can_view_and_add_new_custmore_page() {
Assert.assertEquals("Add a new customer / nopCommerce administration", addObj.getDashboardTitle());
	
     
}

@Then("User enter customer info")
public void user_enter_customer_info() throws InterruptedException {
	
	logger.info("*****Enter custome inforamtion*****");
	
	String email = randstring()+"@gmail.com";
	addObj.enterEmail(email);
	addObj.enterPasw("test123");
	addObj.enterFname(config.getProperty("fname"));
	addObj.enterLname(config.getProperty("lname"));
	addObj.selectGender();
	addObj.selectDOB(config.getProperty("dob"));
	addObj.selectCompany(config.getProperty("company"));
	addObj.selectTax();
	//addObj.enterNews();
	//addObj.selectRole();
	//addObj.selectVendor();
	//addObj.selectActive();
	//addObj.enterComment("added comment");

}

@Then("Click on Save")
public void click_on_Save() throws InterruptedException {
	
	logger.info("*****click on save button*****");
	
	Thread.sleep(3000);
    addObj.clickOnSave();
}

@Then("User can view conformation message {string}")
public void user_can_view_conformation_message(String msg) {
	
	logger.info("*****New user successfully added*****");
     
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
}

 //---------Search customer ---//
@Then("Enter customer email")
public void enter_customer_email() throws InterruptedException {
	
	logger.info("*****enter email id for search*****");
	
    search = new searchCustomer(driver);
    search.setEmail("victoria_victoria@nopCommerce.com");
    Thread.sleep(2000);
}

@Then("Cleck on search")
public void cleck_on_search() throws InterruptedException {
     search.clickOnSearch();
     Thread.sleep(2000);
}

@Then("User should be abel to find user in search table")
public void user_should_be_abel_to_find_user_in_search_table() throws InterruptedException {
     boolean status = search.searchEmail("victoria_victoria@nopCommerce.com");
     if(status = true)
     {
     Assert.assertEquals(true, status);
     logger.info("*****user found*****");
     Thread.sleep(2000);
     }else 
     {
    	 status = false;
    	 logger.info("*****user not found*****");
     }
}



}

