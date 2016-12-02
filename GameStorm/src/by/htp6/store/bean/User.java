package by.htp6.store.bean;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -5749180805311502818L;
	private int id;
	private int accessLevel;
	private String name;
	private String surname;
	private String yearsOld;
	private String email;
	private String password;
	private String login;
	private boolean status;
	
	public int getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getYearsOld() {
		return yearsOld;
	}
	
	public void setYearsOld(String yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
