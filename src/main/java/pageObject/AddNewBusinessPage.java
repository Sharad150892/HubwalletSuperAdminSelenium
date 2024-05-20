package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewBusinessPage {
	
	WebDriver nbdriver;
	
	@FindBy(xpath = "//p[normalize-space()='Business']")
	private WebElement businessModule;
	
	@FindBy(css = ".jsx-ea59492a0610e221.btn.btn-lg.btn-default.add-merchant")
	private WebElement addNewBusinessBtn;
	
	@FindBy(css = "#merchant_id")
	private WebElement selectMerchant;
	
	@FindBy(css = "#store_name")
	private WebElement businessName;
	
	@FindBy(css = "#email")
	private WebElement email;
	
	@FindBy(css = "#phone")
	private WebElement mobile;
	
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
	
	@FindBy(css = "#formfile")
	private WebElement photo;
	
	@FindBy(css = "#cash_discount_percent2")
	private WebElement cashDiscount;
	
	@FindBy(css = "#cash_discount_percent")
	private WebElement serviceCharge;
	
	@FindBy(css = "#payment_nmi_key")
	private WebElement nmiPaymentKey;
	
	@FindBy(css = ".jsx-f1078d7a4d006a14.btn.btn-primary")
	private WebElement save;
	
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement verifyName;
	
	@FindBy(css = ".jsx-4846d976ff1038da.form-control.form-control-lg")
	private WebElement search;
	
	
	public AddNewBusinessPage(WebDriver driver) {
		this.nbdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//action methods
	
	public String getTitleOfTheBusinessPage() {
		String businessPageTitle = nbdriver.getTitle();
		if(businessPageTitle.isBlank()) {
			System.out.println("Business Page Title is Blank");
		}
		else {
			System.out.println(businessPageTitle);
		}
		return businessPageTitle;
	}
	
	public String getTitleOfAddBusinessPage() {
		String addBusinessPageTitle = nbdriver.getTitle();
		if(addBusinessPageTitle.isBlank()) {
			System.out.println("Add Business Page Title is Blank");
		}
		else {
			System.out.println(addBusinessPageTitle);
		}
		return addBusinessPageTitle;
	}
	
	public void clickBusinessModule() {
		businessModule.click();
	}
	
	public void clickAddNewBusinessBtn() {
		addNewBusinessBtn.click();
	}
	
	public void selectMerchant(String MerName) {
		selectMerchant.click();
		Select selMerchant = new Select(selectMerchant);
		selMerchant.selectByVisibleText(MerName);
	}
	
	public void enterBusinessName(String busiName) {
		businessName.sendKeys(busiName);
	}
	
	public void emailIDBusiness(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void mobileNumberBusiness(String mob) {
		mobile.sendKeys(mob);
	}
	
	public void addressBusiness(String add) {
		address.sendKeys(add);
	}
	
	public void cityBusiness(String cty) {
		city.sendKeys(cty);
	}
	
	public void countryBusiness(String ctyName) {
		country.click();
		Select selCountry = new Select(country);
		selCountry.selectByVisibleText(ctyName);
	}
	
	public void stateBusiness(String stateName) throws InterruptedException {
		state.click();
		Select selState = new Select(state);
		selState.selectByVisibleText(stateName);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) nbdriver;
		js.executeScript("window.scrollBy(0,3000)");
	}
	
	public void billingZipBusiness(String billingZip) {
		zip.sendKeys(billingZip);
	}
	
	public void uploadBusinessPhoto() throws AWTException {
		JavascriptExecutor js = (JavascriptExecutor) nbdriver;
		js.executeScript("arguments[0].click",photo);
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\Admin\\eclipse-workspace\\SuperAdmin\\Image\\aaSalon.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void enterDualPricing(String cashDis, String serCharge) throws InterruptedException {
		cashDiscount.sendKeys(cashDis);
		serviceCharge.sendKeys(serCharge);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) nbdriver;
		js.executeScript("window.scrollBy(0,2000)");
	}
	
	public void nmiPayment(String paymentKey) {
		nmiPaymentKey.sendKeys(paymentKey);
	}
	public void SaveBtnBusiness() throws InterruptedException {
		save.click();
		Thread.sleep(3000);
	}
	
	public void confirmBusiness(String bussName) {
		if(verifyName.getText().equalsIgnoreCase(bussName)) {
			System.out.println("Business Added Successfully");
		}
	}

	public void searchBusiness(String bussName) throws InterruptedException {
		search.sendKeys(bussName);
		Thread.sleep(5000);
		search.clear();
	}
	
}
