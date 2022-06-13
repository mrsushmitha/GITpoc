package sampleTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class GoogleSearchTest {
	RemoteWebDriver driver;

	DesiredCapabilities caps;

	@BeforeClass
	public void beforeClass() throws Exception {
		caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");

		driver = new RemoteWebDriver(new URL("http://192.168.1.157:4444"), caps);

	}

	@Test
	public void f() throws InterruptedException {

	

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("google");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
