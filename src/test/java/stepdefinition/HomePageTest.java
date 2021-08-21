package stepdefinition;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.SpendAndSaveLinkPage;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest {

	/*
	 * 	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	String title;
	@Given("user is on login page")
	public void user_is_on_login_page() {
DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	 */
private HomePage homePage = new HomePage(DriverFactory.getDriver());
//public DriverFactory driverFactory = new DriverFactory();


//@Given("user is on home page")
//public void user_is_on_home_page() {
// 
//}

//@When("click on Spend & Save link")
//public void click_on_spend_save_link() {
//
//}

@Then("verify page title")
public void verify_page_title() {

}


@Given("user is on home page")
public void user_is_on_home_page() {
	String url = "https://www.aspiration.com/";
	
	//System.out.println("url is "+url);
	DriverFactory.getDriver().get(url);
	String expectedTitle="Aspiration | Green Financial Services";
	String actualTitle=homePage.getTitle();
//	System.out.println("HomePageTest:user_is_on_home_page::expectedTitle is "+expectedTitle);
//	System.out.println("HomePageTest:user_is_on_home_page::actualTitle is "+actualTitle);
	Assert.assertTrue(expectedTitle.equals(actualTitle));
}

@When("click on Spend & Save link")
public void click_on_spend_save_link() {
	homePage.spendAndSaveLink();
//	System.out.println("click on Spend & Save link ****************");
	
}

}
