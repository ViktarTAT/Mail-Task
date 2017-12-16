package by.htp.taskMail.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public final static String DRIVER = "webdriver.gecko.driver";
    public final static String DRIVER_PATH = "C:/driver/geckodriver.exe";

    private static WebDriver driver;

    public static WebDriver getDriver() {
	if (null == driver) {
	    System.setProperty(DRIVER, DRIVER_PATH);
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	return driver;
    }

    public static void closeDriver() {
	driver.close();
	driver = null;
    }
}
