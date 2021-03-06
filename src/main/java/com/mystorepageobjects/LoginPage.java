package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass 
{

	
	@FindBy(id = "email")
	WebElement username;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement signInBtn;

	@FindBy(id = "email_create")
	WebElement emailForNewAccount;

	@FindBy(xpath = "//i[@class='icon-user left']")
	WebElement createNewAccountBtn;

	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String uname, String pass) throws Exception
	{
		Action.type(username, uname);
		Action.type(password, pass);
		Thread.sleep(2000);
		Action.click(driver, signInBtn,"//a[contains(text(),'Sign in')]");		
		return new HomePage();
	}

	public AddressPage login1(String uname, String pass) throws Exception 
	{
		Action.type(username, uname);
		Action.type(password, pass);
		Thread.sleep(2000);
		Action.click(driver, signInBtn,"//button[@id='SubmitLogin']");
		//Thread.sleep(5000);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newMail) 
	{
		Action.type(emailForNewAccount, newMail);
		Action.click(driver, createNewAccountBtn,"//i[@class='icon-user left']");
		return new AccountCreationPage();
	}
}
