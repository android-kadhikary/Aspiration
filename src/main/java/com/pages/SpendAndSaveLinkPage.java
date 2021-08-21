package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpendAndSaveLinkPage {

	private WebDriver driver;
	private HomePage homePage;
	private By buttonGetAspiration=By.xpath("//button[(text()='Get Aspiration')]");
	private By buttonGetAspirationPlus=By.xpath("//button[(text()='Get Aspiration Plus')]");
	private By emailTextField = By.xpath("//input[@name='email']");
	private By monthlyField = By.xpath("//p[text()=' paid monthly']/b");
	private By yearlyField = By.xpath("//p[text()=' paid once yearly']/b");
	List<String> redioButtonTextList = new ArrayList();
	
	public SpendAndSaveLinkPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getTitle() {
		
		return driver.getTitle(); 
		
	}
	
	public String verifyGetAspirationButtonText() {
		return driver.findElement(buttonGetAspiration).getText();
		
	}
	
	public String verifyGetAspirationPlusButtonText() {
		
		return driver.findElement(buttonGetAspirationPlus).getText();
	}
	
	//get aspiration

	//<button class="btn btn-v3 btn--blue ng-binding" ng-click="getAspirationOriginal()" ng-disabled="aspirationOriginal.disabled">Get Aspiration</button>
//button[(text()='Get Aspiration')]
	// aspiration plus
	//<button class="btn btn-v3 btn--blue ng-binding" ng-click="getAspirationPlus()" ng-disabled="aspirationPlus.disabled">Get Aspiration Plus</button>
////button[(text()='Get Aspiration Plus')]
	
	public void click_get_aspiration_link() {
		driver.findElement(buttonGetAspiration).click();
		
	
	}
	
	public String validate_emailField() {
	
	//	System.out.println("driver.findElement(emailTextField).getAttribute(\"placeholder\") "+driver.findElement(emailTextField).getAttribute("placeholder"));
		return driver.findElement(emailTextField).getAttribute("placeholder");
	}
	
	public void click_get_aspiration_plus_link() {
		 driver.findElement(buttonGetAspirationPlus).click();
		
	
	}
	
	public List<String> getRediobuttonList() {
		
		List<WebElement> redioButtonList = driver.findElements(By.xpath("//div[@class='options']/div/h3"));
	
		for(WebElement w: redioButtonList) {
		
		String redioButtonText = w.getText();
		redioButtonTextList.add(redioButtonText);
		
	}
	
		return redioButtonTextList;
		
		
		
	}
	
	public String monthly_radio_option() {
		return driver.findElement(monthlyField).getText();
		
	}
	
public String yearly_radio_option() {
	System.out.println(driver.findElement(yearlyField).getText());
	return driver.findElement(yearlyField).getText();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
