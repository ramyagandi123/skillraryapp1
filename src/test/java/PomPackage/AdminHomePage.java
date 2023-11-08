package PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
//Declaration
	@FindBy(xpath="//span[text()='SkillRary Admin']")
	private WebElement adminIcon;
	
	@FindBy(xpath="//span[text()='Users']")
	private WebElement userTab;
	
	@FindBy(xpath="//span[text()='Courses']")
	private WebElement courseListLink;

	
	@FindBy(xpath="")
	private WebElement categoryLink;
	
	@FindBy(xpath="")
	private WebElement signOutLink;

//initialization
public void AdminHomepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Utilization
    public String getAdminIcon() {
	return adminIcon.getText();
}
    public void clickUserTab() {
	userTab.click();
}
    public void clickCourseListLink() {
    	courseListLink.click();
    }
    public void clickCategoryLink() {
    	categoryLink.click();
    }
    public void signOutofApp() {
    	adminIcon.click();
    	signOutLink.click();
    }
    }

