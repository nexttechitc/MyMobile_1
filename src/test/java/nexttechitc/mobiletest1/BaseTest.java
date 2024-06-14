package nexttechitc.mobiletest1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {
	static AppiumDriverLocalService service;
	public AndroidDriver driver;
	@BeforeClass
	public void configureAppium() throws Exception {
		
		//AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\nextt\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		//.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(10000)).build();
//service.start();

AppiumServiceBuilder builder = new AppiumServiceBuilder();

builder.withAppiumJS(new File ("C:\\Users\\nextt\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
.usingDriverExecutable(new File ("C:\\Program Files\\nodejs\\node.exe"))
.usingPort(4723)
.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
.withLogFile(new File("Appiumlog.txt"))
.withIPAddress("127.0.0.1");
//.withArgument(GeneralServerFlag)
service= AppiumDriverLocalService.buildService(builder);
service.start();

      
UiAutomator2Options options = new UiAutomator2Options();
options.setDeviceName("pixe_5");
options.setApp(System.getProperty("user.dir")+ "\\src\\test\\java\\resources\\ApiDemos-debug.apk");
driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
		
	}

}
