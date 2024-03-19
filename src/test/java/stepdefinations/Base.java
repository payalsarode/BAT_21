package stepdefinations;

import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import pageObject.VendorPage;
import utilities.ReadConfig;

public class Base {
	
	  WebDriver driver;
	  
	  AdminPage admin;
	  
	  public ReadConfig readconfig;
	  
	  public AddNewCustomerPage addCust;
	  
	  public VendorPage vendor;
	  

}
