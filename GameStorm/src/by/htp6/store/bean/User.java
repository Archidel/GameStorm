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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accessLevel;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((yearsOld == null) ? 0 : yearsOld.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accessLevel != other.accessLevel)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (yearsOld == null) {
			if (other.yearsOld != null)
				return false;
		} else if (!yearsOld.equals(other.yearsOld))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", accessLevel=" + accessLevel + ", name=" + name + ", surname=" + surname
				+ ", yearsOld=" + yearsOld + ", email=" + email + ", password=" + password + ", login=" + login
				+ ", status=" + status + "]";
	}
}
