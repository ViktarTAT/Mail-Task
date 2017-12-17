package by.htp.taskMail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage extends AbstractPage {

    public static final String BASE_URL_1 = "https://e.mail.ru/compose/";

    public static final String INPUT_WHOM = "//span[text()='Кому']/following::textarea[2]";
    public static final String INPUT_TOPIC = "//input[@class='b-input']"; // "//span[text()='Тема']/following::textarea[1]";
    public static final String INPUT_MESSAGE ="//div[@class='compose__editor__container']/table//td[@class='cell shell__text_cell w100']//iframe"; //"//div[@class='compose__editor__frame']";// *[@id='tinymce']";
    public static final String BUTTON_SEND = "//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']";
    public static final String LINK_USER = "//i[@id='PH_user-email']";

    @FindBy(xpath = INPUT_WHOM)
    private WebElement inputWhom;

    @FindBy(xpath = INPUT_TOPIC)
    private WebElement inputTopic;

    @FindBy(xpath = INPUT_MESSAGE)
    private WebElement inputMessage;

    @FindBy(xpath = BUTTON_SEND)
    private WebElement buttonSubmit;

    @FindBy(xpath = LINK_USER)
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

    public void sendLetter(String email, String topic, String message) {

	inputWhom.sendKeys(email);
	inputTopic.sendKeys(topic);

	// try {
	// Thread.sleep(10000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }

	inputMessage.sendKeys(message);
	buttonSubmit.click();
    }

}
