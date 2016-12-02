package by.htp6.store.dao;

import by.htp6.store.bean.User;
import by.htp6.store.dao.exception.DAOException;

public interface UserDAO {
	User SingInUser(User user) throws DAOException;
	User SingUpUser(User user, String confPassword) throws DAOException;
	User EditProfile(User user) throws DAOException;
}
