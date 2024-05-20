package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;

	@FindBy(css = "input[type='text']")
	private WebElement email;
	
	@FindBy(css = "input[type='password']")
	private WebElement password;
	
	@FindBy(css = "input[type='submit']")
	private WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addEmailId(String EmailID) {
//		email.clear();
		email.sendKeys(EmailID);
	}

	public void addPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginbutton.click();
	}

	public String gettitleOfTheLoginPage() {
		String loginPageTitle = ldriver.getTitle();
		if(loginPageTitle.isBlank()) {
			System.out.println("Login Page Title is Blank");
		}
		else {
			System.out.println(loginPageTitle);
		}
		return loginPageTitle;
	}

}
