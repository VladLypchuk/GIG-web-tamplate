package suite;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CBT_Selenium_Test_Body {
    private RemoteWebDriver driver;
    private CBT_Selenium_API api;
    private String score;

    @BeforeTest
    public void setUp() throws Exception {
        String username = "max.stepanenko%40a3ventures.co";
        String authkey = "u84e143c026fbf01";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("name", "Demo_Filters_Fail");
        caps.setCapability("build", "1.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "73x64");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("screenResolution", "1366x768");
//        caps.setCapability("record_video", "true");
        caps.setCapability("snapshots", "true");
        
        // caps.setCapability("record_network", "true");

        api = new CBT_Selenium_API(username, authkey);

        String hubAddress = String.format("http://%s:%s@hub.crossbrowsertesting.com:80/wd/hub", username, authkey);
        URL url = new URL(hubAddress);
        driver = new RemoteWebDriver(url, caps);
// record a video using the API instead of the capabilities above.
//      api.record_video(driver.getSessionId().toString());
    }

    @Test
    public void testToDo() throws InterruptedException {
    	driver.get("https://uat.carsubscription.calstate.aaa.com/");
		driver.manage().window().maximize();
         
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Enter']")).isEnabled());
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("cars95828!");
		driver.findElement(By.xpath("//button[@class='csa-button primary']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Zip Code']")).sendKeys("95678");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
								
// unic email time based that would be sent to actual email
		Date date = new Date();
		SimpleDateFormat formatting = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
				
		String email = formatting.format(date) + "@capibara.33mail.com";		
		
		WebElement field = driver.findElement(By.xpath("//input[@id='username']"));
		field.sendKeys(email);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		
//Setting up SBT to Pass or Fail		
		WebElement title = driver.findElement(By.xpath("//p[@class='error-message']"));
		String str = title.getText();
		System.out.println(str);
		String str1 = "There was an error looking up your email address";
		if (str.equals(str1))
		{
			score = "Pass";
		}
		else {
			score = "Fail";
		}
// Setting up TestNG to Pass or Fail		
		Assert.assertEquals(str, "There was an error looking up your email address");	
		
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();		
        
		System.out.println(score);
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (driver != null) {
            // Set the score depending on the tests.
            api.setScore(score, driver.getSessionId().toString());
            driver.quit();
            System.out.println(score);
        }        
    }
}