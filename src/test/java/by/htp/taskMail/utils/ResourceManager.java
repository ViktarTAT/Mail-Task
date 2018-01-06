package by.htp.taskMail.utils;

import java.util.ResourceBundle;

public enum ResourceManager {
	INSTANCE;
	private ResourceBundle resourceBundle;
	private static final String RESOURCE_NAME = "testData";
	
	private ResourceManager() {
		resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
	}

	public String getString(String key) {
		return resourceBundle.getString(key);
	}
}
