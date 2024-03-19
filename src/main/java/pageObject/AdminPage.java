package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver ldriver;
	
	public AdminPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	

	// Java Project > WebElement txtEmail=driver.findElement(By.xpath("//input[@id ='Email']"));

	// Maven project
	@FindBy(xpath = "//input[@id ='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id ='Password']")
	WebElement txtpassword;

	@FindBy(xpath = "//button[text() ='Log in']")
	WebElement btnLogin;

	// user defined method to perform operation of above web Element

	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

}
