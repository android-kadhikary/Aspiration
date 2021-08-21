package stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.SpendAndSaveLinkPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpendAndSaveTest {

	private HomePageTest homePageTest = new HomePageTest();
	private SpendAndSaveLinkPage spendAndSavePage = new SpendAndSaveLinkPage(DriverFactory.getDriver());
	
	
	@Given("user is on Spend & Save link")
	public void user_is_on_spend_save_link() {
		homePageTest.user_is_on_home_page();
		homePageTest.click_on_spend_save_link();
		String expectedTitle= "Cash Management Services - Investing & Retirement Planning | Aspiration";
		String actualTitle=spendAndSavePage.getTitle();
		Assert.assertTrue(expectedTitle.equals(actualTitle));

	}
@Then("Verify card {string}")
public void verify_card(String string, io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	System.out.println("Verify card {string}");
	List <String> productsNameLinks = dataTable.asList();
	for(int productsName=0;productsName<productsNameLinks.size();productsName++) {
		String productName =productsNameLinks.get(productsName);
		System.out.println(productName);
		if (productName.equals("Aspiration")) {
			System.out.println(	spendAndSavePage.verifyGetAspirationButtonText());
			//spendAndSavePage.verifyGetAspirationButtonText();
			Assert.assertTrue(	spendAndSavePage.verifyGetAspirationButtonText().equalsIgnoreCase("GET ASPIRATION"));
		}
		if (productName.equals("Aspiration Plus")) {
			System.out.println(	spendAndSavePage.verifyGetAspirationPlusButtonText());
			//spendAndSavePage.verifyGetAspirationButtonText();
			Assert.assertTrue(	spendAndSavePage.verifyGetAspirationPlusButtonText().equalsIgnoreCase("GET ASPIRATION PLUS"));
		}
		//Aspiration
		//Aspiration Plus
	}
	
}



@When("click Get Aspiration")
public void click_get_aspiration() {
	spendAndSavePage.click_get_aspiration_link();
	System.out.println("click Get Aspiration");

}

@Then("input field for an email address")
public void input_field_for_an_email_address() {
	
	String emailField = spendAndSavePage.validate_emailField();
	Assert.assertTrue(emailField.equals("Email"));
    
}


@When("click Get Aspiration Plus")
public void click_get_aspiration_plus() {
	spendAndSavePage.click_get_aspiration_plus_link();
    
}

@Then("monthly and yearly plans appears")
public void monthly_and_yearly_plans_appears() {
	List<String>redioButtonList= new ArrayList();
	redioButtonList=	spendAndSavePage.getRediobuttonList();
	//System.out.println("redioButtonList.get(0); "+redioButtonList.get(0));
	//System.out.println("redioButtonList.get(1); "+redioButtonList.get(1));
	
	Assert.assertTrue(redioButtonList.get(0).contains("Yearly"));
	Assert.assertTrue(redioButtonList.get(1).equals("Monthly"));
    
}

@Then("verify that yearly radio option is {string} paid once yearly")
public void verify_that_yearly_radio_option_is_$_paid_once_yearly(String s1) {
  String yearly = spendAndSavePage.yearly_radio_option();
System.out.println(" yearly ="+yearly);
System.out.println(" s1 ="+s1);
	Assert.assertTrue(yearly.equals(s1));
}

@Then("verify that monthly radio option is {string} paid monthly")
public void verify_that_monthly_radio_option_is_$_paid_monthly(String s2) {
	String monthly = spendAndSavePage.monthly_radio_option();
	
//	System.out.println(" yearly ="+monthly);
	Assert.assertTrue(monthly.equals(s2));
}


}
