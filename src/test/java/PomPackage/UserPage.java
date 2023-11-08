package PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
//Declaration
	@FindBy(xpath="//h1[normalize-space(text())='Users']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[text()=' New']")
	private WebElement plusNewabautton;
	
	
	@FindBy(xpath="//table/tbody/tr[last()]/td[3]")
	private WebElement usersListLastpage;
	
	@FindBy(xpath="")
	private WebElement lastUser;
	
	//initialization
	public  UserPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
		
	}
    public void clickUserLinkLastPage() {
    	usersListLastpage.click();
    	
    }
    public String getLastUserName() {
    	return lastUser.getText();
    }
    
	
}
