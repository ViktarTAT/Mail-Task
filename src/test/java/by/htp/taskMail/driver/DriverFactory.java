package by.htp.taskMail.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver getInstanc(String nameDriverString) {
	DriverCreator creator = null;

	NameDriver nameDriver = NameDriver.valueOf(nameDriverString.toUpperCase());

	switch (nameDriver) {
	case CHROME:
	    creator = new ChromeCreator();
	    break;
	case MOZILLA:
	    creator = new MozilaFirefoxCreator();
	    break;
	default:
	    creator = new MozilaFirefoxCreator();
	}

	WebDriver driver = creator.createDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	return driver;
    }
}

enum NameDriver {
    CHROME, MOZILLA
}
