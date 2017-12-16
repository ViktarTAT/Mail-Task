package by.htp.taskMail;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.taskMail.steps.Steps;

public class MailRuTest {

    public static final String LOGIN = "kolay.boroda.tat5@mail.ru";
    public static final String PASSWORD = "tatTAT5";
    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
	steps = new Steps();
	steps.initBrowser();
    }
    
    @Test
	public void oneCanCreateProject()
	{
		steps.loginMailRu(LOGIN, PASSWORD);
		
		// do not use lots of asserts
	}

}
