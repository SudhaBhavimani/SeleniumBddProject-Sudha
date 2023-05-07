package stepDefinations;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.addCustomer;
import pageObjects.loginPage;
import pageObjects.searchCustomer;

public class BaseClass {
	public WebDriver driver ;
	public loginPage lp;
	public addCustomer addObj;
	public searchCustomer search;
	public static Logger logger;
	public Properties config;
	
	
	public static String randstring() 
	{
		String genStr = RandomStringUtils.randomAlphabetic(5);
		return genStr;
		
	}
	

}
