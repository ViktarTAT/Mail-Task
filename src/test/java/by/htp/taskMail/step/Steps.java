package by.htp.taskMail.step;

import org.openqa.selenium.WebDriver;

import by.htp.taskMail.driver.DriverFactory;
import by.htp.taskMail.model.Letter;
import by.htp.taskMail.model.User;
import by.htp.taskMail.page.LoginPage;
import by.htp.taskMail.page.NewLetterPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser(String browser) {
		driver = DriverFactory.getInstanc(browser);
		driver.manage().window().maximize();
	}

	public void closeDriver() {
		driver.close();
		driver = null;
	}

	public void loginMailRu(User user) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(user);
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		return actualUsername.equals(username);
	}

	public void openSendLetter() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickButtonNewLetter();
	}

	public boolean sendLetter(Letter letter) {
		NewLetterPage newLetterPage = new NewLetterPage(driver);
		newLetterPage.sendLetter(letter);
		return newLetterPage.isSend();
	}

}
