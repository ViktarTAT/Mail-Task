package by.htp.taskMail;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.htp.taskMail.model.Letter;
import by.htp.taskMail.model.LetterFactory;
import by.htp.taskMail.model.User;
import by.htp.taskMail.model.UserFactory;
import by.htp.taskMail.step.Steps;

public class MailRuTest {

    private Steps steps;
    private User user;

    @BeforeMethod(description = "Init browser")
    @Parameters("browser")
    public void setUp(String browser) {
	steps = new Steps();
	steps.initBrowser(browser);
	UserFactory userFactory = new UserFactory();
	user = userFactory.getUser();
    }

    @Test(description = "Login to mail.ru", priority = 1, enabled = true)
    public void oneCanLoginMailRu() {
	steps.loginMailRu(user);
	String login = user.getLogin();
	assertTrue(steps.isLoggedIn(login));
    }

    @Test(description = "Send Letter mail.ru", priority = 2, enabled = true)
    public void oneCanSendLetter() {
	steps.loginMailRu(user);
	steps.openSendLetter();
	LetterFactory letterFactory = new LetterFactory();
	Letter letter = letterFactory.getFullLetter();
	assertTrue(steps.sendLetter(letter));
    }

    @AfterMethod
    public void setDown() {
	steps.closeDriver();
    }

}
