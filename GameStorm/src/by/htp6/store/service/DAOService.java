package by.htp6.store.service;

import by.htp6.store.service.exception.ServiceException;

public interface DAOService {
	void InitializationDAO() throws ServiceException;
	void DestroyDAO() throws ServiceException;
}
