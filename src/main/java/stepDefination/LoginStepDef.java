package stepDefination;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddNewBusinessPage;
import pageObject.AddNewMerchantPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.BaseClass;

public class LoginStepDef extends BaseClass {

	WebDriver driver;
	BaseClass bs;

	@Given("^User launch browser$")
	public void launch_browser() {
		this.bs = new LoginStepDef();
		driver = bs.initialization();
		this.lp = new LoginPage(driver);
		this.hp = new HomePage(driver);
		this.mp = new AddNewMerchantPage(driver);
		this.bp = new AddNewBusinessPage(driver);
	}

	@And("^User opens URL \\\"(.*)\\\"$")
	public void open_url(String url) {
		driver.get(url);
		driver.manage().deleteAllCookies();
	}

	@When("^User add Email \\\"(.*)\\\" and password \\\"(.*)\\\"$")
	public void add_email_and_password(String email, String pass) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.addEmailId(email);
		lp.addPassword(pass);
	}

	@When("User add Email as {string} and Password as {string}")
	public void user_add_email_as_and_password_as(String email, String pass) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.addEmailId(email);
		lp.addPassword(pass);
	}

//	@When("^User add Email and password$")
//	public void add_email_and_password_using_Dataprovider(DataTable table) {
//		List<String> L1 = table.asList();
//		lp.addEmailId(L1.get(0));
//		lp.addPassword(L1.get(1));
//	}

	@And("^Login Page tile captured$")
	public void title_capture() {
		lp.gettitleOfTheLoginPage();
	}

	@And("^Click on the Login button$")
	public void click_login_button() throws InterruptedException {
		lp.clickLoginButton();
		Thread.sleep(3000);
	}

	@Then("^Merchant Page title captured$")
	public void Merchant_page_title() {
		if (driver.getPageSource().contains("Email or Password is incorrect")) {
			System.out.println("Incorrect Email or Password");
			driver.close();
		} else {
			hp.gettitleOfMerchantPage();
		}

	}

	@And("^Click on the logout$")
	public void logout() {
		hp.logout();
	}

	@And("^Close browser$")
	public void close_browser() {
		driver.quit();
	}

	@And("^Click on Add New Merchant Btn$")
	public void click_on_add_new_merchant_button() throws InterruptedException {
		mp.addNewMerchantBtn();
		Thread.sleep(3000);
	}

	@Then("^Add New Merchant Page title captured$")
	public void merchantPageTitleCapture() {
		mp.getTitleOfAddMerchantPage();
		Assert.assertEquals("", mp.getTitleOfAddMerchantPage());
	}

	String MerchantName = randomString() + "SS" + " Merchant";

	@Then("^Enter Merchant Information$")
	public void enter_merchant_information() throws InterruptedException {
		String Name = randomString() + " Trading";
		String email = randomString() + "@mailinator.com";
		mp.enterFranchiseName(Name);
		mp.enterMerchantName(MerchantName);
		mp.enterDBAName(Name);
		mp.emailID(email);
		String number = generateMobileNumber();
		mp.mobileNumber(number);
		mp.phoneNumber(number);
		mp.faxNumber(number);
		mp.password(number);
		Thread.sleep(3000);
		String address = randomString() + ", " + " Hills";
		mp.address(address);
		mp.city("Los Angeles");
		mp.country("India");
		mp.state("Uttar Pradesh");
		mp.billingZip("201309");
		Thread.sleep(3000);
	}

	@When("^Click on save button$")
	public void click_on_save_button() {
		mp.SaveBtn();
	}

	@Then("^Verify Merchant Added$")
	public void verify_merchant_added() throws InterruptedException {
		Thread.sleep(3000);
		mp.confirmMerchant(MerchantName);
		mp.searchMerchant("Miguel");
	}

	@And("^Click on Business Module$")
	public void click_on_Business_module() throws InterruptedException {
		Thread.sleep(3000);
		bp.clickBusinessModule();
		Thread.sleep(3000);
	}

	@Then("Business Page Title Capture")
	public void business_page_title_capture() {
		bp.getTitleOfTheBusinessPage();
	}

	@When("Click on Add New Business Btn")
	public void click_on_add_new_business_btn() {
		bp.clickAddNewBusinessBtn();
	}

	@Then("Add New Business Page Title Capture")
	public void add_new_business_page_title_capture() {
		bp.getTitleOfAddBusinessPage();
	}

	String businessName = randomString() + " Salon";

	@Then("Enter Business Information")
	public void enter_business_information() throws InterruptedException, AWTException {
		bp.selectMerchant(MerchantName);
		bp.enterBusinessName(businessName);
		String businessEmail = randomString() + "@mailinator.com";
		bp.emailIDBusiness(businessEmail);
		String businessNumber = generateMobileNumber();
		bp.mobileNumberBusiness(businessNumber);
		String businessAddress = randomString() + ", " + "Town Hills";
		bp.addressBusiness(businessAddress);
		bp.cityBusiness("Noida");
		bp.countryBusiness("India");
		bp.stateBusiness("Uttar Pradesh");
		bp.billingZipBusiness("201309");
		bp.uploadBusinessPhoto();
		bp.enterDualPricing("4.5", "4.5");
		bp.nmiPayment("s8eWT97xpb37S6qTpYDCC98qZ56K23a4");
	}

	@Then("Click on Business Save button")
	public void click_on_business_save_button() throws InterruptedException {
		bp.SaveBtnBusiness();
	}

	@Then("Verify Business Added")
	public void verify_business_added() throws InterruptedException {
		Thread.sleep(3000);
		bp.confirmBusiness(businessName);
		bp.searchBusiness("Look's Salon");
	}
}
