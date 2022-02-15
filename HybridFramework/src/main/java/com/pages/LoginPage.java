package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //Its Page Object Model
WebDriver driver;


@FindBy(id="email")
private WebElement uname;

@FindBy(id="password")
private WebElement pass;

@FindBy(xpath="//button")
private WebElement loginBtn;



public LoginPage(WebDriver driver){
	this.driver=driver;  //driver its from base class
	PageFactory.initElements(driver ,this);
}

public void loginToApplication(String username ,String password){
	uname.sendKeys(username);
	pass.sendKeys(password);
	loginBtn.click();
}
}
