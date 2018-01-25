package by.htp.taskMail.driver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


public class ChromeCreator implements DriverCreator {
	
	public final static String DRIVER_PATH = "C:/driver/chromedriver.exe"; //src/test/resources

	@Override
	public WebDriver createDriver() {
		WebDriver driver;
		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(DRIVER_PATH)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver(service);
        driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
        return driver;
	}
}
