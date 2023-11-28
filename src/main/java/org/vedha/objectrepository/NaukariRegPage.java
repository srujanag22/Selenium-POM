package org.vedha.objectrepository;

import org.vedha.baseclass.BaseTest;

public class NaukariRegPage extends BaseTest{
	
	private static String regButton = "register_Layer";
	
	private static String fullName = "name";
	private static String mailId = "email";
	private static String password = "password";
	private static String number = "mobile";
	private static String workStatus = "//div[@data-val='exp']";
	private static String expYr = "expYear";
	private static String exYear = "(//div[@class='transcluded'])/span[text()='" + property.getProperty("yr") + "']";
	private static String expMn = "expMonth";
	private static String exMonth = "(//div[@class='transcluded'])/span[text()='" + property.getProperty("mn").trim() + "']";
	private static String uploadCV = "uploadCV";
	private static String regNow = "//button[text()='Register Now']";
	
	//empTab
	
	private static String designation = "designation_0";
	private static String company = "company_0";
	private static String lacs = "(//div[@class='transcluded'])/span[text()='" + property.getProperty("lacs")+ "']";
	private static String thous = "(//div[@class='transcluded'])/span[text()='" + property.getProperty("thous") + "']";
	private static String year = "(//div[@class='transcluded'])/span[text()='" + property.getProperty("year")+ "']";
	private static String month = "(//div[@class='transcluded'])/span[text()='" + property.getProperty("month")+ "']";
	private static String city = "(//div[@class='slideDown topCities'])/li[text()='"+ property.getProperty("city")+ "']";
	
	
	public static String getRegButton() {
		return regButton;
	}
	public static String getWorkStatus() {
		return workStatus;
	}

	public static String getFullName() 
	{ return fullName; 
	}
	 
	public static String getMailId() {
		return mailId;
	}
	public static String getPassword() {
		return password;
	}
	public static String getNumber() {
		return number;
	}
	public static String getExpYr() {
		return expYr;
	}
	public static String getExYear() {
		return exYear;
	}
	public static String getExpMn() {
		return expMn;
	}
	public static String getExMonth() {
		return exMonth;
	}
	public static String getUploadCV() {
		return uploadCV;
	}
	public static String getRegNow() {
		return regNow;
	}
	public static String getDesignation() {
		return designation;
	}
	public static String getCompany() {
		return company;
	}
	public static String getLacs() {
		return lacs;
	}
	public static String getThous() {
		return thous;
	}
	public static String getYear() {
		return year;
	}
	public static String getMonth() {
		return month;
	}
	public static String getCity() {
		return city;
	}
	

}
