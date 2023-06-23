package com.bs.qa.pages;

import com.bs.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	
}
