package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
private WebDriver driver;
	
	// Object Repository
private By spendAndSaveLink=By.xpath("//li[@class='Flex-sc-1kj10zc-0 dPEQCs']/a");
//spend & save
//
//	//li[@class='Flex-sc-1kj10zc-0 dPEQCs']/a
//	

public HomePage(WebDriver driver) {
	this.driver=driver;
}

public String getTitle() {
	return driver.getTitle();
}

public SpendAndSaveLinkPage spendAndSaveLink() {
	
	driver.findElement(By.xpath("//*[contains(text(),'Spend & Save')]")).click();
//	List<WebElement> spendAndSaveLinkWEL = driver.findElements(spendAndSaveLink);
//	
//	for (WebElement wE : spendAndSaveLinkWEL) {
//		System.out.println("wE.getText() ="+wE.getText());
//		if (wE.getText().equals("SPEND & SAVE")) {
//			System.out.println("wE.isDisplayed() "+wE.isDisplayed());
//			wE.click();
//		}
//		
//	}
//	
	return new SpendAndSaveLinkPage(driver);
	
}

}
