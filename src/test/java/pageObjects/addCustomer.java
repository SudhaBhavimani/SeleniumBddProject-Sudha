package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addCustomer {
public WebDriver ldriver;
	
	public addCustomer(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
  By cMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
  By customer = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
  By cRole = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-focused k-state-border-down']//div[@role='listbox']");
  By addBtn = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
  By email = By.xpath("//input[@id='Email']");
  By password = By.xpath("//input[@id='Password']");
  By fName = By.xpath("//input[@id='FirstName']");
  By lName = By.xpath("//input[@id='LastName']");
  By Mgender = By.xpath("//input[@id='Gender_Male']");
  By Fgender = By.xpath("//input[@id='Gender_Female']");
  By dob = By.xpath("//input[@id='DateOfBirth']");
  By txtcompany = By.xpath("//input[@id='Company']");
  By tax = By.xpath("//input[@id='IsTaxExempt']");
  By clickNews = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]");
  By txtnews = By.xpath("//li[normalize-space()='Test store 2']");
  By roleRegistred = By.xpath("//li[normalize-space()='Registered']");
  By vendorDropdown = By.xpath("//select[@id='VendorId']");
  By active = By.xpath("//input[@id='Active']");
  By comment = By.xpath("//textarea[@id='AdminComment']");
  By saveBtn = By.xpath("//button[@name='save']");
  
  public String getDashboardTitle()
  {
	  return ldriver.getTitle();
  }
  
  public void clickOnCustomerMenu() 
  {
	  ldriver.findElement(cMenu).click();
  }
  
  public void clickOnCustomer() throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(customer).click();
  }
  
  public void clickOnAddNew()
  {
	  ldriver.findElement(addBtn).click();
  }
  
  public void enterEmail(String txtEmail) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(email).sendKeys(txtEmail);
  }
  
  public void enterPasw(String psw) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(password).sendKeys(psw);
  }
  
  public void enterFname(String txtfname) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(fName).sendKeys(txtfname);  
  }
  public void enterLname(String txtlname) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(lName).sendKeys(txtlname);  
  }

  public void selectRole() throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(cRole).click();
	  ldriver.findElement(roleRegistred).click();
  }
  
  public void selectGender() throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(Fgender).click();
  }
  
  public void selectDOB(String dateofbirth) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(dob).sendKeys(dateofbirth);
  }
  
  public void selectCompany(String company) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(txtcompany).clear();
	  ldriver.findElement(txtcompany).sendKeys(company);
  }
  public void selectTax()
  {
	  ldriver.findElement(tax).click();
  }
  
  public void enterNews() throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(clickNews).click();
	  ldriver.findElement(clickNews).sendKeys("test");
	  //ldriver.findElement(txtnews).click();;
	  Thread.sleep(3000);
  }
  
  public void selectCustomerRole(String role) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(cRole).click();
	  ldriver.findElement(roleRegistred).sendKeys(role);
  }
  
  public void selectVendor() throws InterruptedException
  {
	  Thread.sleep(3000);
	  WebElement vendorSel = ldriver.findElement(vendorDropdown);
	  Select selObj = new Select(vendorSel);
	  selObj.selectByIndex(1);
	  
  }
  
  public void selectActive() throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(active).click();
  }
  
  public void enterComment(String cmt) throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(comment).sendKeys(cmt);
  }
  
  public void clickOnSave() throws InterruptedException
  {
	  Thread.sleep(3000);
	  ldriver.findElement(saveBtn).click();
  }
}

