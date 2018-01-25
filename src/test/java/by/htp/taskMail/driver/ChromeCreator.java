package by.htp.taskMail.driver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeCreator implements DriverCreator {

    public final static String DRIVER_PATH = "src/test/resources"; // C:/driver/chromedriver.exe

    @Override
    public WebDriver createDriver() {
	WebDriver driver;
	ChromeDriverService service = new ChromeDriverService.Builder()
		.usingDriverExecutable(new File(DRIVER_PATH))
		.build();
	try {
	    service.start();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	driver = new ChromeDriver(service);
	return driver;
    }
}
