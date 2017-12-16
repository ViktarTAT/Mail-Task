package by.htp.taskMail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage extends AbstractPage {

    public static final String BASE_URL = "https://e.mail.ru/compose/";

    public static final String INPUT_WHOM = "//span[text()='Кому']/following::textarea[2]";
    public static final String INPUT_TOPIC = "//input[@class='b-input']"; // "//span[text()='Тема']/following::textarea[1]";
    public static final String INPUT_MESSAGE = "//*[@id='tinymce']/br";
    public static final String BUTTON_SEND = "b-toolbar__btn__text";
    public static final String LINK_USER = "//i[@id='PH_user-email']";

    @FindBy(xpath = INPUT_WHOM)
    private WebElement inputWhom;

    @FindBy(xpath = INPUT_TOPIC)
    private WebElement inputTopic;

    @FindBy(xpath = INPUT_MESSAGE)
    private WebElement inputMessage;

    @FindBy(className = BUTTON_SEND)
    private WebElement buttonSubmit;

    @FindBy(xpath = LINK_USER)
    private WebElement linkLoggedInUser;

    public NewLetterPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
	driver.get(BASE_URL);
    }

    public void sendLetter(String email, String topic, String message) {
	inputWhom.sendKeys(email);
	inputTopic.sendKeys(topic);
	inputMessage.sendKeys(message);
	buttonSubmit.click();
    }

}
