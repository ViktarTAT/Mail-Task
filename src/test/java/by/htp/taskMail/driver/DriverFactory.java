package by.htp.taskMail.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	public static WebDriver getInstanc(String nameDriverString){
		DriverCreator creator = null;
		
		NameDriver nameDriver = NameDriver.valueOf(nameDriverString.toUpperCase());
		
		switch(nameDriver){
		case CHROME:
			creator = new ChromeCreator();
			break;
		case MOZILLA:
			creator = new MozilaFirefoxCreator();
			break;
		}
		
		return creator.createDriver();
	}	
}

enum NameDriver {
	CHROME,
	MOZILLA
}
