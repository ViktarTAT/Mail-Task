package by.htp.taskMail.model;

public class UserFactory {

	public static final String LOGIN = "kolya.boroda.tat5@mail.ru";
    public static final String PASSWORD = "tatTAT5";
    
    public static User getUser(){
    	return new User(LOGIN, PASSWORD);
    }
}
