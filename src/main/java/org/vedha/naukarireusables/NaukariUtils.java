package org.vedha.naukarireusables;

import org.vedha.corecomponents.SeleniumUtils;
import org.vedha.baseclass.BaseTest;
import org.vedha.corecomponents.IDriverFactory.LocatorType;
import org.vedha.objectrepository.NaukariLoginPage;
import org.vedha.objectrepository.NaukariLogoutPage;
import org.vedha.objectrepository.NaukariRegPage;

public class NaukariUtils extends BaseTest {
	public void NaukariLogin(SeleniumUtils seleniumUtils) {
		try {
		seleniumUtils.Click(NaukariLoginPage.getLogin(), LocatorType.id);
		seleniumUtils.EnterText(NaukariLoginPage.getUsername(), LocatorType.xpath, property.getProperty("mail"));
		seleniumUtils.EnterText(NaukariLoginPage.getPassword(), LocatorType.xpath, property.getProperty("pwd"));
		seleniumUtils.Click(NaukariLoginPage.getSubmit(), LocatorType.xpath);
		seleniumUtils.Sleep();
		String actualTitle = driver.getTitle();
		logger.info(actualTitle);
		String expectedTitle = "Home | Mynaukri";
		if(actualTitle.equalsIgnoreCase(expectedTitle) ) {
			logger.info("succeccfully redirected to Home Page");
			logger.info("Login success");
		}
		
		} catch (Exception e) {
			logger.info("Login failed");
			logger.info(e);
		}
		
	}
	
	public void NaukariLogoutFunc(SeleniumUtils seleniumUtils) throws InterruptedException
    {
        //As logout link is hidden on the page, so using actions
        //Actions action = new Actions(instance());
        seleniumUtils.Sleep();
        seleniumUtils.Click(NaukariLogoutPage.getMyNaukari(), LocatorType.xpath);
        seleniumUtils.Click(NaukariLogoutPage.getLogout(), LocatorType.xpath);
        logger.info("logout success");
        
    }
	
	public void RegFunc(SeleniumUtils seleniumUtils) {
		//CloseChildWindows(seleniumUtils);
		//Popup(seleniumUtils);
		seleniumUtils.Click(NaukariRegPage.getRegButton(), LocatorType.id);
		seleniumUtils.EnterText(NaukariRegPage.getFullName(), LocatorType.id, property.getProperty("name") );
		seleniumUtils.EnterText(NaukariRegPage.getMailId(), LocatorType.id, property.getProperty("email"));
		seleniumUtils.EnterText(NaukariRegPage.getPassword(), LocatorType.id, property.getProperty("pswd"));
		seleniumUtils.EnterText(NaukariRegPage.getNumber(), LocatorType.id, property.getProperty("num"));
		seleniumUtils.Click(NaukariRegPage.getWorkStatus(), LocatorType.id);
		seleniumUtils.Click(NaukariRegPage.getExpYr(), LocatorType.name);
		seleniumUtils.Click(NaukariRegPage.getExYear(), LocatorType.xpath);
		seleniumUtils.Click(NaukariRegPage.getExpMn(), LocatorType.name);
		seleniumUtils.Click(NaukariRegPage.getExMonth(), LocatorType.xpath);
	    seleniumUtils.EnterText(NaukariRegPage.getUploadCV(), LocatorType.name, "E:\\munny\\res.pdf");
	    seleniumUtils.Click(NaukariRegPage.getRegNow(), LocatorType.xpath);
	}
	
	public void EmpTab(SeleniumUtils seleniumUtils) {
		seleniumUtils.EnterText(NaukariRegPage.getDesignation(), LocatorType.id,property.getProperty("desig"));
		seleniumUtils.EnterText(NaukariRegPage.getCompany(),LocatorType.id, property.getProperty("company"));
		seleniumUtils.Click(NaukariRegPage.getLacs(), LocatorType.xpath);
		seleniumUtils.Click(NaukariRegPage.getThous(), LocatorType.xpath);
		seleniumUtils.Click(NaukariRegPage.getYear(), LocatorType.xpath);
		seleniumUtils.Click(NaukariRegPage.getMonth(), LocatorType.xpath);
		seleniumUtils.Click(NaukariRegPage.getCity(), LocatorType.xpath);
		
	}

	
	public void CloseChildWindows(SeleniumUtils seleniumUtils)
    {
         
        String parentWindowHandle = instance().getWindowHandle();
        System.out.println("Parent Window :" + parentWindowHandle);

        int child = instance().getWindowHandles().size();
        System.out.println("Child window count" + child);
        
        for(String element : instance().getWindowHandles())
        {
            if (!element.equals(parentWindowHandle))
            {
                //Console.WriteLine(element);
                System.out.println(instance().switchTo().window(element).getTitle());
                instance().switchTo().window(element).close();
            }

        }
        instance().switchTo().window(parentWindowHandle);
    }
   

	 public void Popup(SeleniumUtils seleniumUtils)
	    {
	        seleniumUtils.Click("block", LocatorType.id);
	        
	    }

}
