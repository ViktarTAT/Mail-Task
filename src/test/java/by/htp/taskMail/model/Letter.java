package by.htp.taskMail.model;

public class Letter {
	private String email;
	private String topic;
	private String message;

	public Letter() {

	}

	public Letter(String email, String topic, String message) {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
