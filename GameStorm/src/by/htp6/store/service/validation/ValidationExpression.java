package by.htp6.store.service.validation;

public class ValidationExpression {
	public static final String LOGIN_REGULAR = "[a-zA-Z0-9]{4,16}+$";
	public static final String PASSWORD_REGULAR = "[a-zA-Z0-9]{8,32}+$";
	public static final String EMAIL_REGULAR = "([a-zA-Z0-9].+)\\@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
	public static final String NAME_REGULAR = "[a-zA-Z]{3,32}+$";
}
