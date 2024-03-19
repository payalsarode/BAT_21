package stepdefinations;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import pageObject.VendorPage;
import utilities.ReadConfig;

public class StepDefination extends Base {
	
	//Hooks concepts in BDD cuccumber
	//@Before will execute before every scenario
	
	@Before
	public void setUP() throws Exception {
		System.out.println("Set up method execution");
		
		readconfig =new ReadConfig(); //Creating object of Readconfig
		
		String browser=readconfig.getBrowser(); //chrome
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
		
	}

	@Given("user launch Chrome Browser")
	public void user_launch_chrome_browser() {

	//	driver = new ChromeDriver();

		admin = new AdminPage(driver); // Create Object of AdminPage Java Class

	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		driver.get(url);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		admin.setUserName(email);
		admin.setPassword(password);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		admin.clickLogin();
	}

	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) {
            Assert.assertEquals(driver.getTitle(), title);
	}
	
	//Add new Customer
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws Exception {
	    addCust =new AddNewCustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	    Thread.sleep(2000);
	}

	@When("User click on Customers menu")
	public void user_click_on_customers_menu() throws Exception {
	   addCust.ClickOnCustomer();
	   Thread.sleep(2000);
	}

	@When("User click on Customers menu item")
	public void user_click_on_customers_menu_item() throws Exception {
	   addCust.ClickOnCustomerMenuItem();
	   Thread.sleep(2000);
	
	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() throws Exception {
	    addCust.ClickOnAddnew();
	    Thread.sleep(2000);
	}

	@Then("User can view new customer page")
	public void user_can_view_new_customer_page() throws Exception {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	    Thread.sleep(2000);
	}

	@When("User enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String newPass, String fname, String lname, String gender, String comName, String adminComment) {
	    addCust.SetEmail(newEmail);
	    addCust.SetPassword(newPass);
	    addCust.SetFirstname(fname);
	    addCust.SetLastName(lname);
	    addCust.SetGender(gender);
	    addCust.SetCompanyname(comName);
	    addCust.SetAdminComment(adminComment);
	}


	@When("user click on save button")
	public void user_click_on_save_button() {
	     addCust.ClickOnSave();
	}

	@Then("user can view confirmation page {string}")
	public void user_can_view_confirmation_page(String string) throws Exception {
	    Assert.assertTrue(driver.findElement(By.tagName("Body")).getText().contains("The new customer has been added successfully."));
	    Thread.sleep(2000);
	}
	
	//vendors

	@When("User click on vendor item")
	public void user_click_on_vendor_item() throws Exception {
	   vendor = new VendorPage(driver);
	   vendor.clickOnvendors();
	   Thread.sleep(2000);
	}

	@Then("User can view vendor page")
	public void user_can_view_vendor_page() throws Exception {
		Assert.assertEquals("Vendors / nopCommerce administration", vendor.getPageTitle());
		Thread.sleep(2000);
	}

	@When("User enter Vendor name as {string} and password as {string}")
	public void user_enter_vendor_name_as_and_password_as(String Vendorname, String Vendoremail) throws Exception {
	   vendor.SearchEmail(Vendoremail);
	   vendor.SearchName(Vendorname);
		Thread.sleep(2000);
	}

	@When("User click on Search button")
	public void user_click_on_search_button() throws Exception {
	 vendor.ClickOnSearchbutton();
		Thread.sleep(2000);
	}


	@Then("Close browser")
	public void close_browser() {
        driver.close();
	}
	
	
	//@After will execute after each scenario
	@After
	public void tearDown(Scenario sc) throws Exception {
		System.out.println("Tear down method execute after each scenario");
		
		//Capture screenshot of failed scenario
		
		if (sc.isFailed()==true) {
			
			String filepath= "C:\\Users\\PAYAL\\eclipse-workspace\\04Dec2023CucumberMavenproject\\Screenshot\\failedScreenshot.png";
			
			//convert WebDriver object into Takescreenshot 
			
			TakesScreenshot scrshot = (TakesScreenshot)driver;
			
			//call getscreenshotAs()
			File srcfile=scrshot.getScreenshotAs(OutputType.FILE);
			
			File destfile = new File(filepath);
			
			FileUtils.copyFile(srcfile, destfile);
			
		 Thread.sleep(2000);
			
			
			
		}
	}
	
	

}
