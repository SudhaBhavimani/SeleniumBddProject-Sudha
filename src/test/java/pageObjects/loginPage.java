package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
public WebDriver ldriver;
	
	public loginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath= "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement txtBtn;
	

	@FindBy(id= "Password")
	@CacheLookup
	WebElement txtPsw;
	

	@FindBy(id= "Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	@CacheLookup
	WebElement logOut;
	
	public void setUserMail(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setUserPsw(String psw) {
		txtPsw.clear();
		txtPsw.sendKeys(psw);
	}
	
	public void clickLogin() {
		txtBtn.click();
	}
	
	public void clickLogout() {
		logOut.click();
	}
	

}
