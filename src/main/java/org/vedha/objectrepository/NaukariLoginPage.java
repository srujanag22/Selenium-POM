package org.vedha.objectrepository;

public class NaukariLoginPage {
	private static String login = "login_Layer";
	private static String username = "//input[@placeholder ='Enter your active Email ID / Username']";
	private static String password = "//input[@type='password']";
	private static String submit = "//button[@type='submit']";
	
	public static String getLogin() {
		return login;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public static String getSubmit() {
		return submit;
	}

}
