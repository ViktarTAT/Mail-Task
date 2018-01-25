package by.htp.taskMail.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozilaFirefoxCreator implements DriverCreator {

    public final static String DRIVER = "webdriver.gecko.driver";
    public final static String DRIVER_PATH = "C:/driver/geckodriver.exe";

    @Override
    public WebDriver createDriver() {

	System.setProperty(DRIVER, DRIVER_PATH);
	WebDriver driver = new FirefoxDriver();
	return driver;
    }
}
