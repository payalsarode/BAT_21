package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	
	WebDriver ldriver;
	public VendorPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(xpath = "//p[text()=' Vendors']")
	WebElement linkvendors;
	
	@FindBy(xpath = "//input[@id='SearchName']")
	WebElement searchVendorName;
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement searchVendorEmail;
	
	@FindBy(xpath = "//button[@id='search-vendors']")
	WebElement btnSearch;
	
	
	//user Defined method
	
	public String getPageTitle() {
		return ldriver.getTitle();

	}
	
	public void clickOnvendors() {
		linkvendors.click();
	}
	
	public void SearchEmail(String vemail) {
		searchVendorEmail.sendKeys(vemail);
	}
	
	
	public void SearchName(String vname) {
		searchVendorName.sendKeys(vname);
	}
	
	
	public void ClickOnSearchbutton() {
		btnSearch.click();
	}
	
	
}
