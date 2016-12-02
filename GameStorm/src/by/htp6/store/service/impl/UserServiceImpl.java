package by.htp6.store.service.impl;

import by.htp6.store.bean.User;
import by.htp6.store.dao.DAOFactory;
import by.htp6.store.dao.UserDAO;
import by.htp6.store.dao.exception.DAOException;
import by.htp6.store.service.UserService;
import by.htp6.store.service.exception.ServiceException;
import by.htp6.store.service.validation.ValidationData;

public class UserServiceImpl implements UserService {

	@Override
	public User SingInUser(User user) throws ServiceException {
		if(user.getLogin() != null && user.getPassword() != null){
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			
			try {			
				user = userDAO.SingInUser(user);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}else{
			throw new ServiceException("Incorrect username or password");
		}
		return user;
	}

	@Override
	public User SingUpUser(User user, String confPassword) throws ServiceException {
		if(!ValidationData.validationRegisterData(user.getLogin(), user.getName(), user.getSurname(), user.getYearsOld(), user.getEmail(), user.getPassword(), confPassword)){
			user = null;
			throw new ServiceException("Incorrect data");
		}else{
			
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			
			try {
				user = userDAO.SingUpUser(user, confPassword);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}
		return user;
	}

	@Override
	public User EditProfile(User user, String newPassword, String ConfNewPassword) throws ServiceException {
		if((newPassword == null) || (newPassword.equals(""))){
			newPassword = user.getPassword();
		}
		if((ConfNewPassword == null) || (ConfNewPassword.equals(""))){
			ConfNewPassword = user.getPassword();
		}
		
		if(ValidationData.passwordValid(newPassword, ConfNewPassword)){
			user.setPassword(newPassword);
			
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			
			try {
				userDAO.EditProfile(user);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
			
		}else{
			user = null;
		}
		return null;
	}

}
