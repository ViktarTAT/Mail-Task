package by.htp.taskMail.utils;

import java.util.ResourceBundle;

public enum ResourceManager {
	INSTANCE;
	private ResourceBundle resourceBundle;
	private static final String FILE_PATH = "";

	private ResourceManager() {
		resourceBundle = ResourceBundle.getBundle(FILE_PATH);
	}

	public String getString(String key) {
		return resourceBundle.getString(key);
	}
}