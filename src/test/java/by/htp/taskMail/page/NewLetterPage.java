package by.htp.taskMail.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.taskMail.model.Letter;

public class NewLetterPage extends AbstractPage {

	public static final String INPUT_WHOM = "//textarea[@data-original-name='To']";
	public static final String INPUT_TOPIC = "//input[@class='b-input']";
	public static final String INPUT_MESSAGE = "//div[@class='compose__editor__container']/table//td[@class='cell shell__text_cell w100']//iframe";
																																					
	public static final String BUTTON_SEND = "//div[@data-name='send']";
	public static final String LINK_USER = "message-sent__title";
	public static final String LINK_SEND = "Ваше письмо отправлено. Перейти во Входящие";

	@FindBy(xpath = INPUT_WHOM)
	private WebElement inputWhom;

	@FindBy(xpath = INPUT_TOPIC)
	private WebElement inputTopic;

	@FindBy(xpath = INPUT_MESSAGE)
	private WebElement inputMessage;

	@FindBy(xpath = BUTTON_SEND)
	private WebElement buttonSubmit;

	@FindBy(className = LINK_USER)
	private WebElement linkLoggedInUser;

	public NewLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void sendLetter(Letter letter) {
		String email = letter.getEmail();
		String topic = letter.getTopic();
		String message = letter.getMessage();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(inputWhom));
		
		inputWhom.sendKeys(email);
		inputTopic.sendKeys(topic);
		inputMessage.sendKeys(message);
		buttonSubmit.click();

	}

	public boolean isSend() {
		String result = linkLoggedInUser.getText();
		return LINK_SEND.equals(result);
	}

}
