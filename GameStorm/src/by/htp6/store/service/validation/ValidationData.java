package by.htp6.store.service.validation;

import java.util.regex.Pattern;

public class ValidationData {
	
	public static  boolean validationSingInData(String login, String password){
		if((login != null) && (password) != null){
			if(loginValid(login) && passwordValid(password)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static boolean validationRegisterData(String login, String name, String surname, String yealOld, String email, String password, String re_enter_password){
		if(loginValid(login) && passwordValid(password, re_enter_password) && emailValid(email) && NameAndSurnameValid(name, surname)){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean loginValid(String login){
		boolean isVaild = Pattern.matches(ValidationExpression.LOGIN_REGULAR, login);
		return isVaild;
	}
	
	private static boolean passwordValid(String password){
		boolean isVaild = Pattern.matches(ValidationExpression.PASSWORD_REGULAR, password);
		return isVaild;
	}
	
	public static boolean passwordValid(String password, String re_enter_password){
		if(password.equals(re_enter_password)){
			boolean isVaild = Pattern.matches(ValidationExpression.PASSWORD_REGULAR, password);
			return isVaild;
		}else{
			return false;
		}
	}

	private static boolean emailValid(String email){
		if(email != null){
			boolean isValid = Pattern.matches(ValidationExpression.EMAIL_REGULAR, email);
			return isValid;
		}else{
			return false;
		}
	}

/*	private boolean yearOldValid(String yearlOld){	// дописать
		return false;
	}*/
	
	private static boolean NameAndSurnameValid(String name, String surname){
		if((name != null) && (surname != null)){
			boolean bName = Pattern.matches(ValidationExpression.NAME_REGULAR, name);
			boolean bSurname = Pattern.matches(ValidationExpression.NAME_REGULAR, surname);
			if(bName && bSurname){
				return true;
			}else{
				return false;
			}	
		}else{
			return false;
		}
	
	}
}
