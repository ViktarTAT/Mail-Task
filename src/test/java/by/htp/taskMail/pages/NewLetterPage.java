package by.htp.taskMail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.taskMail.model.Letter;

public class NewLetterPage extends AbstractPage {

	public static final String BASE_URL_1 = "https://e.mail.ru/compose/";

	public static final String INPUT_WHOM = "//span[text()='Кому']/following::textarea[2]";
	public static final String INPUT_TOPIC = "//input[@class='b-input']"; // "//span[text()='Тема']/following::textarea[1]";
	public static final String INPUT_MESSAGE = "//div[@class='compose__editor__container']/table//td[@class='cell shell__text_cell w100']//iframe"; // "//div[@class='compose__editor__frame']";//
																																					// *[@id='tinymce']";
	public static final String BUTTON_SEND = "//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']";
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

	@Override
	public void openPage() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get(BASE_URL_1);

		System.out.println("open page");
	}

	public void sendLetter(Letter letter) {
		String email = letter.getEmail();
		String topic = letter.getTopic();
		String message = letter.getMessage();

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
