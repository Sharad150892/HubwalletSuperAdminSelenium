package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddEmployee {
	
	WebDriver aedriver;
	
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement selectBusiness;
	
	@FindBy(css = ".jsx-f961ba8c4ccbf8a2.btn.btn-lg.btn-default.add-merchant.ml-5")
	private WebElement addEmployeeBtn;
	
	@FindBy(css = "#email")
	private WebElement email;
	
	@FindBy(css = "#firstname")
	private WebElement firstName;
	
	@FindBy(css = "#lastname")
	private WebElement lastName;
	
	@FindBy(css = "#phone")
	private WebElement phone;
	
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
	
	@FindBy(css = "#payment_nmi_key")
	private WebElement nmiPaymentKey;
	
	@FindBy(css = ".jsx-f1078d7a4d006a14.btn.btn-primary")
	private WebElement save;
	
	public AddEmployee(WebDriver driver) {
		this.aedriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectBusiness() {
		selectBusiness.click();
	}
	
	public void clickAddEmployee() {
		addEmployeeBtn.click();
	}
	
	public void addEmployeeEmail(String emailID) {
		email.sendKeys(emailID);
	}
	
	public void enterEmployeeFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterEmployeeLastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enterEmployeePhone(String num) {
		phone.sendKeys(num);
	}
	
	public void enterEmployeeAddress(String add) {
		address.sendKeys(add);
	}
	
	public void enterEmployeeCity(String cty) {
		city.sendKeys(cty);
	}
	
	public void selectEmployeeCountry(String ctyName) throws InterruptedException {
		country.click();
		Select selCountry = new Select(country);
		selCountry.selectByVisibleText(ctyName);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) aedriver;
		js.executeScript("window.scrollBy(0,3000)");
	}
	
	public void selectEmployeeState(String stateName) throws InterruptedException {
		state.click();
		Select selState = new Select(state);
		selState.selectByVisibleText(stateName);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) aedriver;
		js.executeScript("window.scrollBy(0,3000)");
	}
	
	public void enterEmployeeZip(String Zip) {
		zip.sendKeys(Zip);
	} 
	
	public void SaveBtnEmployee() throws InterruptedException {
		save.click();
		Thread.sleep(3000);
	}

}
