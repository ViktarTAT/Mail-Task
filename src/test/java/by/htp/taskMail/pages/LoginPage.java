package by.htp.taskMail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    public static final String BASE_URL = "mail.ru";

    public static final String INPUT_LOGIN = "mailbox:login";
    public static final String INPUT_PASSWORD = "mailbox:password";
    public static final String BUTTON_SUBMIT = "//label[@id='mailbox:submit']/input";

    @FindBy(id = INPUT_LOGIN)
    private WebElement inputLogin;

    @FindBy(id = INPUT_PASSWORD)
    private WebElement inputPassword;

    @FindBy(xpath = BUTTON_SUBMIT)
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
	driver.get(BASE_URL);
    }

    public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
    }
    
    public String getLoggedInUserName() {
		return linkLoggedInUser.getAttribute("content");
	}

}
