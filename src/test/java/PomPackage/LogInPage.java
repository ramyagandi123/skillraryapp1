package PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
//Declaration
	@FindBy (xpath="//a[text()='LOGIN']")
	private WebElement pageHeader;
	@FindBy(id ="email")
	private WebElement emailTF;
	@FindBy(id ="pass")
	private WebElement passwordTF;
	
	@FindBy(name ="login")
	private WebElement loginButton;
	
	//Initialization
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getpageHeader() {
		return pageHeader.getText();	
	}
	public void setEmail(String email) {
		emailTF.sendKeys(email);
	}
	public void setPassword(String password) {
		passwordTF.sendKeys(password);
	}
	public void ClickLogin() {
		loginButton.submit();
	}
}
