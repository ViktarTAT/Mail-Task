package by.htp.taskMail.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.taskMail.model.User;
import by.htp.taskMail.step.Steps;

public class LoginPage extends AbstractPage {

    public static final String BASE_URL = "https://mail.ru";

    public static final String INPUT_LOGIN = "mailbox:login";
    public static final String INPUT_PASSWORD = "mailbox:password";
    public static final String BUTTON_SUBMIT = "//label[@id='mailbox:submit']/input";
    public static final String LINK_USER = "//i[@id='PH_user-email']";
    public static final String BUTTON_NEW_LETTER = "//a[@class='b-toolbar__btn js-shortcut']";

    @FindBy(id = INPUT_LOGIN)
    private WebElement inputLogin;

    @FindBy(id = INPUT_PASSWORD)
    private WebElement inputPassword;

    @FindBy(xpath = BUTTON_SUBMIT)
    private WebElement buttonSubmit;

    @FindBy(xpath = LINK_USER)
    private WebElement linkLoggedInUser;

    @FindBy(xpath = BUTTON_NEW_LETTER)
    private WebElement buttonNewLetter;

    public LoginPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
	driver.get(BASE_URL);
    }

    public void login(User user) {
	String login = user.getLogin();
	String password = user.getPassword();
	inputLogin.sendKeys(login);
	inputPassword.sendKeys(password);
	buttonSubmit.click();
    }

    public void clickButtonNewLetter() {
	buttonNewLetter.click();
    }

    public String getLoggedInUserName() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(linkLoggedInUser));
	return linkLoggedInUser.getText();
    }
}
