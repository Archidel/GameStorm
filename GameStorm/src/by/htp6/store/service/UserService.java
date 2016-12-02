package by.htp6.store.service;

import by.htp6.store.bean.User;
import by.htp6.store.service.exception.ServiceException;

public interface UserService {
	User SingInUser(User user) throws ServiceException;
	User SingUpUser(User user, String confPassword) throws ServiceException;
	User EditProfile(User user, String newPassword, String ConfNewPassword) throws ServiceException;
}
