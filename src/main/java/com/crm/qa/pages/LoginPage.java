
//Waleed


package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Chromaticity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	
	//Page Factory - OR:
	
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;

		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		
		//Initializing the Page Objects:
		public LoginPage() {
			
			PageFactory.initElements(driver, this);
		}
		
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		
		public HomePage login(String un,String pw) {
		    	
			//WebDriverWait wait = new WebDriverWait(driver, 100);
			//WebElement element = wait.until(ExpectedConditions.visibilityOf(loginBtn));
			username.sendKeys(un);
			
			password.sendKeys(pw);
			
			
			
			//Actions actions = new Actions(driver);

			//actions.moveToElement(loginBtn).click();
			
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", loginBtn);
			
				//loginBtn.click();
			
			
			
			return new HomePage();

		}
}
