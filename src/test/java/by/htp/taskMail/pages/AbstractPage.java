package by.htp.taskMail.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
	protected WebDriver driver;

	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
