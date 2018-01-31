package by.htp.taskMail.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitCreator implements DriverCreator {

    @Override
    public WebDriver createDriver() {
	WebDriver driver = new HtmlUnitDriver();
	return driver;
    }
    
}
