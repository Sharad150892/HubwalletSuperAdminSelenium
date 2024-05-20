package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewBusinessPage;
import pageObject.AddNewMerchantPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public AddNewMerchantPage mp;
	public AddNewBusinessPage bp;
	
	
	public WebDriver initialization() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().getPageLoadTimeout();
		return driver;
	}
	
	//created for generating random string for Unique email
	public static String randomString() {
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		
		return (generateString1);
	}
	
	public static String generateMobileNumber() {
		
		String generateNumber = RandomStringUtils.randomNumeric(10, 10);
		
		return (generateNumber);
	}
	
}
