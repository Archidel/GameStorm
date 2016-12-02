package by.htp6.store.service.impl;

import by.htp6.store.dao.DAOFactory;
import by.htp6.store.dao.DAOInitialization;
import by.htp6.store.dao.exception.DAOException;
import by.htp6.store.service.DAOService;
import by.htp6.store.service.exception.ServiceException;

public class DAOServiceImpl implements DAOService {

	@Override
	public void InitializationDAO() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAOInitialization daoInitialization = daoFactory.getDaoInitialization();
		
		try {
			daoInitialization.InitializationDAO();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void DestroyDAO() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAOInitialization daoInitialization = daoFactory.getDaoInitialization();
		
		try {
			daoInitialization.DestroyDAO();
		} catch (DAOException e) {
			e.printStackTrace();
		}	
	}

}
