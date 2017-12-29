package by.htp.taskMail.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	public static WebDriver getInstanc(String nameDriver){
		DriverCreator creator = null;
		
		switch(nameDriver){
		case "chrome":
			creator = new ChromeCreator();
			break;
		case "mozile":
			creator = new MozilaFirefoxCreator();
			break;
		default:
			creator = new MozilaFirefoxCreator();
		}
		
		return creator.createDriver();
	}	
}
