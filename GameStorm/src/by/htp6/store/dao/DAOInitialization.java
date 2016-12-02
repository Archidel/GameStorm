package by.htp6.store.dao;

import by.htp6.store.dao.exception.DAOException;

public interface DAOInitialization {
	void InitializationDAO() throws DAOException;
	void DestroyDAO() throws DAOException;
}
