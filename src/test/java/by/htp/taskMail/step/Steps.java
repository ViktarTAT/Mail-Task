package by.htp.taskMail.step;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.taskMail.driver.DriverFactory;
import by.htp.taskMail.model.Letter;
import by.htp.taskMail.model.User;
import by.htp.taskMail.page.LoginPage;
import by.htp.taskMail.page.NewLetterPage;

public class Steps {

    private static final Logger LOG = Logger.getLogger(Steps.class);
    private WebDriver driver;

    public void initBrowser(String browser) {
	LOG.info("start: 'initBrowser'");
	driver = DriverFactory.getInstanc(browser);
	driver.manage().window().maximize();
	LOG.info("finish: 'initBrowser'");
    }

    public void closeBrowser() {
	LOG.info("start: 'closeBrowser'");
	driver.close();
	driver = null;
	LOG.info("finish: 'closeBrowser'");
    }

    public void loginMailRu(User user) {
	LOG.info("start: 'loginMailRu'");
	LoginPage loginPage = new LoginPage(driver);
	LOG.info("open: 'loginPage'");
	loginPage.openPage();
	LOG.warn("enter: " + user.toString());
	loginPage.login(user);
	LOG.info("finish: 'loginMailRu'");
    }

    public boolean isLoggedIn(String username) {
	LOG.debug("start: 'isLoggedIn'");
	LoginPage loginPage = new LoginPage(driver);
	String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
	boolean result = actualUsername.equals(username);
	LOG.warn("finish: 'isLoggedIn' result = " + result);
	return result;
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
