package myHooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import utilities.BaseClass;

public class LoginHooks extends BaseClass{
	WebDriver driver;
	
	@Before
	public void start() {

		System.out.println("Process Started");

	}

	@After
	public void end() {

		System.out.println("Process End");
		driver.quit();
	}
	
	

}
