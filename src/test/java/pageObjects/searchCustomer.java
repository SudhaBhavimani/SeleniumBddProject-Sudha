package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.helperClass;

public class searchCustomer {
	public WebDriver ldriver;
	helperClass help;
	
	public searchCustomer(WebDriver rdriver)
	{
		ldriver =rdriver;
		help = new helperClass(ldriver);
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath= "//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(xpath= "//button[@id='search-customers']")
	@CacheLookup
	WebElement searchBtn;
	
	@FindBy(xpath= "//table[@id='customers-grid']//tbody//tr")
	@CacheLookup
	List<WebElement> row;
	
	@FindBy(xpath= "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(xpath= "//table[@id='customers-grid']//tbody//tr//td")
	@CacheLookup
	List<WebElement> col;
	
	public void setEmail(String email)
	{
		help.WaitForElement(txtemail, 30);
		txtemail.clear();
		txtemail.sendKeys(email);
		
	}
	
	public void clickOnSearch()
	{
		searchBtn.click();
	}
	
	public int rowNo()
	{
		return(row.size());
	}
	
	public int colNo()
	{
		return(col.size());
	}
	
	public boolean searchEmail(String email)
	{
	boolean flag=false;
	
	for(int i=1;i<=rowNo();i++)
	{
		String emailid=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]")).getText();
		System.out.println(emailid);
		
		if(emailid.equals(email)) {
			flag=true;
		}
	}
	return flag;
	}
}
