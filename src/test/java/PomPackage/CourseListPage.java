package PomPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseListPage {
//Declaration
	@FindBy(xpath="//h1[normalize-space(text())='Course List']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[text()=' New']")
	private WebElement newButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	private List<WebElement>CourseList;
	
	@FindBy(xpath="//h4[text()=' Success!']")
	private WebElement successMessage;
	
	private String deletepath="//td[text()=%s]/fillowing-sibling::td/button[text()='Delete']";
	
	@FindBy(xpath="//button[@name='delete']")
	private WebElement deleteButton;
	
	//Initialization
	private CourseListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
		
	}
	public void ClickNewButton() {
		newButton.click();
	}
	public List<WebElement>getCourse(){
		return CourseList;
	}
	public String getSuccessMessage() {
		return successMessage.getText();
	}
	public void ClickDeleteButton(String courseName,WebDriver dreiver) {
		String requiredpath=String.format(deletepath, courseName);
		dreiver.findElement(By.xpath(requiredpath)).click();
	}
	public void clickDelete() {
		deleteButton.click();
	}
}
