package by.htp.taskMail;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.taskMail.model.Letter;
import by.htp.taskMail.model.LetterFactory;
import by.htp.taskMail.model.User;
import by.htp.taskMail.model.UserFactory;
import by.htp.taskMail.steps.Steps;

public class MailRuTest {

	private Steps steps;
	private User user;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		user = UserFactory.getUser();
	}
	
	@Test(description = "Login to mail.ru", priority = 1, enabled = false)
	public void oneCanLoginMailRu() {
		
//		String login = user.getLogin();
//		String password = user.getPassword();
		steps.loginMailRu(user);
		Assert.assertTrue(steps.isLoggedIn(user.getLogin()));
	}

	@Test(description = "Send Letter mail.ru", priority = 2, enabled = true)
	public void oneCanSendLetter() {
		steps.loginMailRu(user);
		Letter letter = LetterFactory.getFullLetter();
		Assert.assertTrue(steps.sendLetter(letter));
	}
}
