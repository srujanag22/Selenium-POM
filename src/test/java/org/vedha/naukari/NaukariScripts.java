package org.vedha.naukari;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.vedha.baseclass.BaseTest;
import org.vedha.constants.Constants;
import org.vedha.corecomponents.SeleniumUtils;
import org.vedha.corecomponents.IDriverFactory.BrowserType;
import org.vedha.naukarireusables.NaukariUtils;

@Listeners(org.vedha.listeners.ExtentReportListeners.class)
public class NaukariScripts extends BaseTest{
		
		SeleniumUtils seleniumUtils;
		NaukariUtils naukariUtils;
		
		public NaukariScripts() {
			naukariUtils = new NaukariUtils();
		}
		
		@BeforeMethod
		public void Initialization() {
			seleniumUtils = new SeleniumUtils(BrowserType.chrome, Constants.Naukari_Url, Constants.LONG_WAIT);
		}
		
		@Test(priority=1, enabled=true, description="Verifying Naukari Login & Logout functionality")
		public void VerifyLoginPage() throws InterruptedException, IOException {
			String nameofCurrMethod = new Exception()
	                .getStackTrace()[0]
	                .getMethodName(); 
			try {
				logger.info("Verify Login");
			    SeleniumUtils.getScreenshot(driver, "Success_Tc"+ nameofCurrMethod);
			    naukariUtils.NaukariLogin(seleniumUtils);
			    seleniumUtils.Sleep();
			    naukariUtils.NaukariLogoutFunc(seleniumUtils);
			}
			catch(Exception e) {
				logger.info("testcase failed");
				SeleniumUtils.getScreenshot(driver, "Failed_Tc"+ nameofCurrMethod);
				e.printStackTrace();
	        }
		}
		
		@Test(priority=2, enabled=true, description="Verifying Naukari Registration functionality")
		public void VerifyRegPage() {
			try {
				logger.info("reg started");
				naukariUtils.RegFunc(seleniumUtils);
				logger.info("reg success");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@AfterMethod
		public void Dispose() {
			//seleniumUtils.CloseAllWindows();
			
		}

}
