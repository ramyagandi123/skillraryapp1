package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all reusable methods to perform web driver actions
 * @author Dell
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	private WebElement element;
		/**
		 * This method is used to launch user desired browser
		 * 
		 */
		public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("WebDriver.chrome.driver","./src/main/resources/chromedriver.exe");
			 driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser info");
			}
		driver.manage().window().maximize();
	    return driver ;	
	}
		/**
		 * This method is used to navigate to the applications
		 * @param url
		 */
		public void navigateToApp(String url) {
			driver.get(url);
		}
		/**
		 * This method is an implicitly wait statement
		 * @param time
		 */
		public void waitTillElementFound(long time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			
		}
		/**
		 * This method is used to wait until element is visible
		 * 
		 */
		public WebElement explicitWait(long time, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			return wait.until(ExpectedConditions.visibilityOf(element));
		
		}
		/**
		 * This method is used until the element is enabled
		 * @param title
		 * @param time
		 * @return
		 */
		public Boolean explicitWait(String title,long time) {
			WebDriverWait wait = new WebDriverWait(driver,time);
			return wait.until(ExpectedConditions.titleContains(title));
		}
		/**
		 * This method is used to mousehover on the element
		 * @param element
		 */
		public void mouseHoverToElement(WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}
		/**
		 * This method is used to double click on the element
		 * @param element
		 */
		public void doubleClickOnElement(WebElement element) {
			Actions actions = new Actions(driver);
			actions.doubleClick(element).perform();
		}
		/**
		 * This method is used to right click on the element
		 * @param element
		 */
		public void rightClick(WebElement element) {
			Actions actions = new Actions(driver);
			actions.contextClick(element).perform();
		}
		/**
		 * This method is used to drag and drop on element
		 * @param element
		 * @param target
		 */
		public void dragAndDropElement(WebElement element,WebElement target) {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(element, target).perform();
		}	
		public void handleDropdown(WebElement element,int index) {
			Select select=new Select(element);
			select.selectByIndex(index);
		}
		/**
		 * This method is used to select an element from drop down based on value
		 * @param element
		 * @param value
		 */
		public void handleDropdown(WebElement element,String index) {
			Select select= new Select(element);
			select.selectByValue(index);
		}

		
		/**
		 * This method is used to select an element  form drop down based on text
          *@parameter text
          *@parameter element
		 */
public void handleDropdown(String text,WebElement element) {
	Select select= new Select(element);
	select.selectByVisibleText(text);
	}
/**
 * This method is used to switch to frame based on index
 * @param index
 */
    public  void switchToFrame(int index) {
    	driver.switchTo().frame(index);
    }
    /**
     * This method is used to switch to frame based  on id or name attribute
     * @param idOrName
     */
    public  void switchToFrame(String idOrName) {
    	driver.switchTo().frame(idOrName);
    }
    /**
     * This method is used to switch to frame based  on frameElement reference
     * @param frameElement
     */
    public  void switchToFrame(WebElement frameElement) {
    	driver.switchTo().frame(frameElement);
}
    /**
     * This method is used to switch to switch back from the frame
     */
    public  void switchBackFromFrame() {
    	driver.switchTo().defaultContent();
    }
    /**
     * This method is used to capture window screen shot 
     * @param driver
     * @param className
     * @param jutil
     */
    public void takeScreenshot(WebDriver driver,String className,JavaUtility jutil) {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src =ts.getScreenshotAs(OutputType.FILE);
    	File dest = new File("./Screenshot/"+className+"_"+jutil.geytCurrentTime()+".png");
    	try {
    		FileUtils.copyFile(src, dest);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    /**
     * This method is used to scroll till element
     * @param element
     */
    public void scrollTitllElement(WebElement element) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("argument[0].scrollIntiView(true)",element);	
    }
    /**
     * This method is used to handle alert
     * @param status
     */
    public void handleAlert(String status) {
    	Alert alert= driver.switchTo().alert();
    	if(status.equalsIgnoreCase("ok"))
    		alert.accept();
    	else
    		alert.dismiss();
   }   
    /**
     * This method is user to switch to child browser
     */
    public void swithToChildBrowser() {
    	Set<String>set=driver.getWindowHandles();
    	for(String windowID:set) {
    		driver.switchTo().window(windowID);	
    	}
    }
    /**
     * This method return parent browser address
     * @return
     */
    public String getParentWindowID() {
    	return driver.getWindowHandle();
    }
    /**
     * This method is used to switch to specified window
     * @param windowID
     */
    public void switchToWindow(String windowID) {
    driver.switchTo().window(windowID);	
    }
    /**
     * This method is used to close current window
     */
    public void closeCurrentwindow() {
    	driver.close();
    }
    /**
     * This method is used to close all the windows
     */
    public void closeAllWindow() {
    	driver.quit();
    }
    }



		