package by.htp.taskMail.model;

import by.htp.taskMail.utils.ResourceManager;

public class UserFactory {

	private String login;
	private String password;

	public UserFactory() {
		initDataFactory();
	}

	public User getUser() {
		return new User(login, password);
	}
	
	private void initDataFactory() {
		ResourceManager manager = ResourceManager.INSTANCE;
		login = manager.getString("user.email");
		password = manager.getString("user.password");
	}
}
