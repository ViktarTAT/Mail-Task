package by.htp.taskMail.steps;

import org.openqa.selenium.WebDriver;

import by.htp.taskMail.driver.Driver;
import by.htp.taskMail.pages.LoginPage;

public class Steps {

    private WebDriver driver;

    public void initBrowser() {
	driver = Driver.getDriver();
    }

    public void closeDriver() {
	Driver.closeDriver();
    }

    public void loginMailRu(String username, String password) {
	LoginPage loginPage = new LoginPage(driver);
	loginPage.openPage();
	loginPage.login(username, password);
    }
    
    public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		return actualUsername.equals(username);
	}

}
