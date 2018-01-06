package by.htp.taskMail.model;

import by.htp.taskMail.utils.ResourceManager;

public class LetterFactory {

	private String emailRecipient;
	private String topic;
	private String message;

	public LetterFactory() {
		initDataFactory();
	}

	public Letter getFullLetter() {
		return new Letter(emailRecipient, topic, message);
	}

	public Letter getLetterWhithoutTopic() {
		Letter letter = new Letter();
		letter.setEmail(emailRecipient);
		letter.setMessage(message);
		return letter;
	}

	private void initDataFactory() {
		ResourceManager manager = ResourceManager.INSTANCE;
		emailRecipient = manager.getString("letter.email");
		topic = manager.getString("letter.topic");
		message = manager.getString("letter.message");
	}
}
