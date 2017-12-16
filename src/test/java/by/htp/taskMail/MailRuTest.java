package by.htp.taskMail;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.taskMail.steps.Steps;

public class MailRuTest {

    public static final String LOGIN = "kolya.boroda.tat5@mail.ru";
    public static final String PASSWORD = "tatTAT5";
    
    public static final String EMAIL_RECIPIENT = "kolya.snezhok@mail.ru";
    public static final String TOPIC = "TAT5";
    public static final String MESSAGE = "QQQQQQQQQQQQQQQQQQ";
    
    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
	steps = new Steps();
	steps.initBrowser();
    }

    @Test(description = "Login to Github", enabled = false)
    public void oneCanLoginMailRu() {
	steps.loginMailRu(LOGIN, PASSWORD);
	Assert.assertTrue(steps.isLoggedIn(LOGIN));
    }

    @Test(description = "Send Letter mail.ru", enabled = true)
    public void oneCanSendLetter() {
	steps.loginMailRu(LOGIN, PASSWORD);
	steps.sendLetter(EMAIL_RECIPIENT, TOPIC, MESSAGE);
    }
}
