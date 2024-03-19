package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

//	@FindBy(xpath = "//input[@id ='Email']")
//	WebElement txtEmail;

	By lnkCusttomer_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkcustomers_menu_item = By.xpath("//p[text()=' Customers']");
	By btnAddNew = By.xpath("//a[@class='btn btn-primary']");
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By rdmaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdfemaleGender = By.xpath("//input[@id='Gender_Female']");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");

	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement dropdownVendorMgr;

	// User Defined methods

	public String getPageTitle() {
		return ldriver.getTitle();

	}

	public void ClickOnCustomer() {
          ldriver.findElement(lnkCusttomer_menu).click();
	}

	public void ClickOnCustomerMenuItem() {
            ldriver.findElement(lnkcustomers_menu_item).click();
	}

	public void ClickOnAddnew() {
            ldriver.findElement(btnAddNew).click();
	}

	public void SetEmail(String Email) {
                ldriver.findElement(txtEmail).sendKeys(Email);
	}

	public void SetPassword(String password) {
             ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void SetFirstname(String fname) {
            ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void SetLastName(String lname) {
           ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	
	public void SetGender(String gender) {
	
		if(gender.equals("male")) {
			ldriver.findElement(rdmaleGender).click();	
		}else {
			ldriver.findElement(rdfemaleGender).click();
		}
	}
	
	public void EnterDob() {

	}
	
	public void entermanagerofVendor() {

	}
	
	
	public void SetCompanyname(String comName) {
     ldriver.findElement(txtCompanyName).sendKeys(comName);
	}
	
	public void SetAdminComment(String adminComment) {
          ldriver.findElement(txtAdminComment).sendKeys(adminComment);
	}
	
	public void ClickOnSave() {
            ldriver.findElement(btnSave).click();
	}
	
	
	
}
