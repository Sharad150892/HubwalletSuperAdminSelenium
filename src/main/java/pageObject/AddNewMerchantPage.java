package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewMerchantPage {
	
	WebDriver nmdriver;
	
	@FindBy(xpath = "//button[normalize-space()='Add New Merchant']")
	private WebElement addNewMerchant;
	
	@FindBy(css = "#franchise_name")
	private WebElement franchiseName;
	
	@FindBy(css = "#merchant_name")
	private WebElement merchantName;
	
	@FindBy(css = "#dba_name")
	private WebElement dbaName;
	
	@FindBy(css = "#email")
	private WebElement email;
	
	@FindBy(css = "#phone")
	private WebElement phone;
	
	@FindBy(css = "#mobile")
	private WebElement mobile;
	
	@FindBy(css = "#fax")
	private WebElement fax;
	
	@FindBy(css = "#password")
	private WebElement password;
	
	@FindBy(css = ".jsx-32e39240c51e9f75.far.fa-eye")
	private WebElement eye;
	
	@FindBy(css = "#address")
	private WebElement address;
	
	@FindBy(css = "#billing_city")
	private WebElement city;
	
	@FindBy(css = "#country")
	private WebElement country;
	
	@FindBy(css = "#billing_state")
	private WebElement state;
	
	@FindBy(css = "#billing_zip")
	private WebElement zip;
	
	@FindBy(css = ".jsx-32e39240c51e9f75.btn.btn-primary")
	private WebElement save;
	
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement verifyName;
	
	@FindBy(css = ".jsx-4846d976ff1038da.form-control.form-control-lg")
	private WebElement search;

	public AddNewMerchantPage(WebDriver driver) {
		this.nmdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//action methods
	
	public String getTitleOfAddMerchantPage() {
		String addMerchantPageTitle = nmdriver.getTitle();
		if(addMerchantPageTitle.isBlank()) {
			System.out.println("Add Merchant Page Title is Blank");
		}
		else {
			System.out.println(addMerchantPageTitle);
		}
		return addMerchantPageTitle;
	}
	
	public String getPageTitle() {
		return nmdriver.getTitle();
	}
	
	public void addNewMerchantBtn() {
		addNewMerchant.click();
	}
	
	public void enterFranchiseName(String frnName) {
		franchiseName.sendKeys(frnName);
	}
	
	public void enterMerchantName(String merName) {
		merchantName.sendKeys(merName);
	}
	
	public void enterDBAName(String dba) {
		dbaName.sendKeys(dba);
	}
	
	public void emailID(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void phoneNumber(String phn) {
		phone.sendKeys(phn);
	}
	
	public void mobileNumber(String mob) {
		mobile.sendKeys(mob);
	}
	
	public void faxNumber(String fx) {
		fax.sendKeys(fx);
	}
	
	public void password(String pwd) throws InterruptedException {
		password.sendKeys(pwd);
		Thread.sleep(3000);
		eye.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) nmdriver;
		js.executeScript("window.scrollBy(0,1500)");
	}
	
	public void address(String add) {
		address.sendKeys(add);
	}
	
	public void city(String cty) {
		city.sendKeys(cty);
	}
	
	public void country(String ctyName) {
		country.click();
		Select selCountry = new Select(country);
		selCountry.selectByVisibleText(ctyName);
	}
	
	public void state(String stateName) {
		state.click();
		Select selState = new Select(state);
		selState.selectByVisibleText(stateName);
	}
	
	public void billingZip(String billingZip) {
		zip.sendKeys(billingZip);
	}
	
	public void SaveBtn() {
		save.click();
	}
	
	public void confirmMerchant(String merName) {
		if(verifyName.getText().equalsIgnoreCase(merName)) {
			System.out.println("Merchant Added Successfully");
		}
	}
	
	public void searchMerchant(String merName) throws InterruptedException {
		search.sendKeys(merName);
		Thread.sleep(5000);
		search.clear();
	}

}
