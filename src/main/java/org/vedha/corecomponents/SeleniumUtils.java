package org.vedha.corecomponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.vedha.baseclass.BaseTest;
import org.vedha.corecomponents.IDriverFactory.BrowserType;
import org.vedha.corecomponents.IDriverFactory.LocatorType;

public class SeleniumUtils extends BaseTest{
	public static Actions actions;
	public static Select select;
	public static Alert alert;

	
	protected IDriverFactory driverFactory = new DriverFactory();
	
	public SeleniumUtils(BrowserType browser, String Url, int Wait) {
		
		driver = driverFactory.CreateWebDriver(browser);
		driver.navigate().to(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		logger.info("Browser is launched");
	}
	
	public void Click(String element, LocatorType locatorType) {
		FindElement(element, locatorType).click();
	}
	
	public void ClickElement(String element, LocatorType locatorType, String value) {
		FindElement(element, locatorType).click();
		FindElement(element, locatorType).sendKeys(value);
	}
	public void CloseWindow() {
		driver.close();
	}

	public String GetText(String element, LocatorType locatorType) {
		return FindElement(element, locatorType).getText();
	}
	public void Sleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	public void Refresh(){
		driver.navigate().refresh();
	}
	
	public void EnterText(String element, LocatorType locatorType, String value) {
		ClearText(element, locatorType);
		FindElement(element, locatorType).sendKeys(value);
	}
	
	public void ClearText(String element, LocatorType locatorType) {
		FindElement(element, locatorType).clear();
	}
	
	public void CloseAllWindows() {
		driver.quit();
		}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
	{
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ScreenShots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination; 
	}


//To Dismiss Alert Pop-Up.
	public static void dismissAlertPopup() throws InterruptedException 
	{
		try 
		{
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.dismiss(); 
			System.out.println("Alert Dismissed Successfully");
		} 
		catch(Exception e) 
		{ 
			System.out.println("Something Went Wrong ==>> Please Check ::: " + e.getMessage());
		}
	}
	//To Perform Drag and Drop action using Actions Class - 2.
		public static void dragAndDrop_2(WebDriver driver, WebElement sourceElement, WebElement destinationElement) 
		{
			actions = new Actions(driver);
			actions.clickAndHold(sourceElement).pause(Duration.ofSeconds(2)).moveToElement(destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
		}

		//To Perform Right Click action using Actions Class.
		public static void rightClick(WebDriver driver, WebElement element) 
		{
			actions = new Actions(driver);
			actions.contextClick(element).build().perform();
		}

		//To perform Double Click action using Actions Class.
		public static void doubleClick(WebDriver driver, WebElement element) 
		{
			actions = new Actions(driver);
			actions.doubleClick(element).build().perform();
		}

		//To Click on Element using Actions Class.
		public void clickOnElementUsingActions(WebElement element) 
		{
			actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		}
			
		//To Mouse Hover and Click or Select an Element using Actions Class.
		public static void moveToElement(WebDriver driver, WebElement element) 
		{
			actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		}

		//To Perform Drag and Drop action using Actions Class - 1.
		public static void dragAndDrop_1(WebDriver driver, WebElement sourceElement, WebElement destinationElement) 
		{
			actions = new Actions(driver);
			actions.dragAndDrop(sourceElement, destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
		}
	
	//To Select Radio Button.
		public void selectRadioButton(List<WebElement> element, String value)
		{
			for(WebElement elements : element)
			{
				if(elements.getText().equalsIgnoreCase(value))
				{
					elements.click();
					break;
				}
			}
		}
		
		//To Accept Alert Pop-Up.
		public static void acceptAlertPopup() throws InterruptedException 
		{
			try 
			{
				alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				Thread.sleep(2000);
				alert.accept();
				System.out.println("Alert Accepted Successfully");
			} 
			catch(Exception e) 
			{
				System.out.println("Something Went Wrong ==>> Please Check ::: " +e.getMessage());
			}
		}


		//To Handle Multiple Windows or Switch Between Multiple Windows.
		public void switchWindow(WebDriver driver, String firstWindow, String secondWindow) 
		{
			Set<String> windowHandles = driver.getWindowHandles();
			for(String windows : windowHandles) 
			{
				if(!windows.equals(firstWindow) && !windows.equals(secondWindow)) 
				{
					driver.switchTo().window(windows);
				}
			}
		}

		//Element is displayed or not
		public Boolean IsElementDisplayed(String element, LocatorType locatorType)
        {
            try
            {
                WebElement ele = this.FindElement(element, locatorType);
                if (ele.isDisplayed())
                {
                    return true;

                }
                else
                {
                    return false;
                }
            }
            catch (Exception e)
            {
                return false;
            }
        }

		
		//Get text of a web element if element is displayed
		public String GetTextIfElementDisplayed(String element, LocatorType locatorType) {
			 if (IsElementDisplayed(element, locatorType))
	            {

	               String text = GetText(element, locatorType);
	               System.out.println(text);
	            }
			return null;
			 
		}
		
		//Click on the element if element is displayed
		 public void ClickElementIfDisplayed(String element, LocatorType locatorType)
	        {
	            if (IsElementDisplayed(element, locatorType))
	            {

	                Click(element, locatorType);
	            }

	        }
		
		//To Check Element is Displayed or No.
		public static void isElementDisplayed(WebElement element) 
		{
			boolean elementDisplayed = element.isDisplayed();
			if(elementDisplayed) 
			{
				System.out.println("Element is Displayed");
			} 
			else 
			{
				System.out.println("Element is not Displayed");
			}
		}

		//To Check Element is Enabled or No.
		public static void isElementEnabled(WebElement element) 
		{
			boolean elementEnabled = element.isEnabled();
			if(elementEnabled) 
			{
				System.out.println("Element is Enabled");
			} 
			else 
			{
				System.out.println("Element is not Enabled");
			}
		}
		

		public WebElement FindElement(String element, LocatorType elementType) {
			WebElement findElement = null;
			try {
				if(elementType == LocatorType.id) {
					findElement = driver.findElement(By.id(element));	
				}
				else if(elementType == LocatorType.name) {
					findElement = driver.findElement(By.name(element));
				}
				else if(elementType == LocatorType.xpath) {
					findElement = driver.findElement(By.xpath(element));
				}
				else if(elementType == LocatorType.linktext) {
					findElement = driver.findElement(By.linkText(element));
				}
				else if(elementType == LocatorType.classname) {
					findElement = driver.findElement(By.className(element));
				}
				else if(elementType == LocatorType.tagname) {
					findElement = driver.findElement(By.tagName(element));
				}
				else if(elementType == LocatorType.cssselector) {
					findElement = driver.findElement(By.cssSelector(element));
				}
				else if(elementType == LocatorType.partiallinktext) {
					findElement = driver.findElement(By.partialLinkText(element));
				}
				return findElement;
				
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
				
			}
			
		}
		
		public List<WebElement> FindElements(String element, LocatorType elementType){
			List<WebElement> findElements = null;
			try {
				if(elementType == LocatorType.id) {
					findElements = driver.findElements(By.id(element));
				}
				else if(elementType == LocatorType.name){
					findElements = driver.findElements(By.name(element));
				}
				else if(elementType == LocatorType.xpath) {
					findElements = driver.findElements(By.xpath(element));
				}
				else if(elementType == LocatorType.cssselector) {
					findElements = driver.findElements(By.cssSelector(element));
				}
				else if(elementType == LocatorType.tagname) {
					findElements = driver.findElements(By.tagName(element));
				}
				else if(elementType == LocatorType.classname) {
					findElements = driver.findElements(By.className(element));
				}
				else if(elementType == LocatorType.linktext) {
					findElements = driver.findElements(By.linkText(element));
				}
				else if(elementType == LocatorType.partiallinktext) {
					findElements = driver.findElements(By.partialLinkText(element));
				}
				return findElements;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}

}
