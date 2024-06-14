package nexttechitc.mobiletest1;




import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;



public class testone extends BaseTest {

	@Test
	public void jahan() throws Exception {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle =driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Taha Wifi");
		//driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		Thread.sleep(2000);	
	

}
	
	
}
