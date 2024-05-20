package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver hdriver;
	
	@FindBy(css = ".jsx-38a3c3f70a62959c.fa-solid.fa-right-from-bracket")
	private WebElement logoutBtn;

	public HomePage(WebDriver driver) {
		this.hdriver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logout() {
		logoutBtn.click();
		Alert alert = hdriver.switchTo().alert();
		String alertText = alert.getText(); // Get text of alert
		System.out.println(alertText);
		alert.accept(); // Accept the alert
	}

	public void gettitleOfMerchantPage() {
		String merchantPageTitle = hdriver.getTitle();
		if(merchantPageTitle.isBlank()) {
			System.out.println("Merchant Page Title is Blank");
		}
		else {
			System.out.println(merchantPageTitle);
		}
	}
}
