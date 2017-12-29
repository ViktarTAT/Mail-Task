package by.htp.taskMail.steps;

import org.openqa.selenium.WebDriver;

import by.htp.taskMail.driver.ChromeCreator;
import by.htp.taskMail.driver.DriverCreator;
import by.htp.taskMail.driver.DriverFactory;
import by.htp.taskMail.driver.MozilaFirefoxCreator;
import by.htp.taskMail.pages.LoginPage;
import by.htp.taskMail.pages.NewLetterPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverFactory.getInstanc("chome");
	}

	public void closeDriver() {
		driver.close();
		driver = null;
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

	public boolean sendLetter(String email, String topic, String message) {
		NewLetterPage newLetterPage = new NewLetterPage(driver);
		newLetterPage.openPage();
		newLetterPage.sendLetter(email, topic, message);
		return newLetterPage.isSend();
	}

}
