package org.vedha.constants;

import org.vedha.corecomponents.CommonUtils;

public class Constants {
	public static final String TestData_Path = System.getProperty("user.dir")
			+ "/src/main/resources/TestData.properties";

	public static final String LoggersPath = "./src/main/resources/log4j.properties";

	public static final String TestReportsPath = System.getProperty("user.dir") + "/VedhaTestReports/VedhaReports"
			+ CommonUtils.getCurrentDate() + ".html";

	public static final String Loggers = System.getProperty("user.dir") + "./src/main/resources/log4j.properties";
	
	
	public static final int SHORT_WAIT = 3000;
	public static final int MEDIUM_WAIT = 6000;
	public static final int LONG_WAIT = 10000;
	
	public static String Naukari_Url = "https://www.naukri.com/"; 

}
