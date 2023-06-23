package com.bs.qa.test;

import com.bs.qa.base.TestBase;
import com.bs.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;

	
	public LoginPageTest(){
		super();
	}

	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional String browser){
		String url = "https://www.flipkart.com/";
		initialization(browser, url);
		loginPage = new LoginPage();	
	}
	
	//@Test
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM App for every business customer relationship management cloud");
	}

	@Test
	public void m1(){

	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	

}
