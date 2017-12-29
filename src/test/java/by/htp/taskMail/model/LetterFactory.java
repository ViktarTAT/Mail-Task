package by.htp.taskMail.model;

public class LetterFactory {
	
	public static final String EMAIL_RECIPIENT = "viktar.balabushko.tat5@mail.ru"; //tathtp@mail.ru
    public static final String TOPIC = "JAVA TAT5";
    public static final String MESSAGE = "Светлана, здравствуйте. Это ссылка на мой GitHub: "
    	+ "\n" + "https://github.com/ViktarTAT";

	public static Letter getFullLetter() {
		return new Letter(EMAIL_RECIPIENT, TOPIC, MESSAGE);
	}
	
	public static Letter getLetterWhithoutTopic() {
		Letter letter= new Letter();
		letter.setEmail(EMAIL_RECIPIENT);
		letter.setMessage(MESSAGE);
		return new Letter();
	}
}
