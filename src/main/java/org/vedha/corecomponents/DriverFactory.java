package org.vedha.corecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory implements IDriverFactory{
	public WebDriver CreateWebDriver(BrowserType browser) {
		try {
			
			WebDriver driver = null;
			switch(browser) {
			case chrome :
				driver = new ChromeDriver();
				break;
			case IE:
				break;
			case firefox:
				break;
			default:
				break;
			
			}
			return driver;
			
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		 
		
	}

}
