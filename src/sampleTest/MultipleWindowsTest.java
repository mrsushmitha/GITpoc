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

public class MultipleWindowsTest {
	RemoteWebDriver driver;
	 
	 DesiredCapabilities caps;
	  @BeforeClass
	  public void beforeClass() throws Exception {
		caps=new DesiredCapabilities();
		caps.setBrowserName("safari");
		  
		  driver=new RemoteWebDriver(new URL("http://192.168.1.157:4444" ),caps);
				  
	  }
  @Test
  public void f() throws InterruptedException {
	  
	  
	 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click')]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		String parentH = i.next();
		String childH = i.next();
		driver.switchTo().window(childH);
		String childText = driver.findElement(By.cssSelector("div.example")).getText();
		System.out.println(childText);
		driver.switchTo().window(parentH);
		String parentText = driver.findElement(By.cssSelector("div.example h3")).getText();
		System.out.println(parentText);
		Thread.sleep(3000);

		
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();

  }

}
