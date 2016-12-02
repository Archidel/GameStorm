package by.htp6.store.dao;

import by.htp6.store.dao.impl.AdministrationDAOImpl;
import by.htp6.store.dao.impl.CartDAOImpl;
import by.htp6.store.dao.impl.DAOInitializationImpl;
import by.htp6.store.dao.impl.SearchDAOImpl;
import by.htp6.store.dao.impl.UserDAOImpl;

public class DAOFactory {
	private static DAOFactory instance = null;
	private final AdministrationDAO administrationDAO = new AdministrationDAOImpl();
	private final CartDAO cartDAO = new CartDAOImpl();
	private final DAOInitialization daoInitialization = new DAOInitializationImpl();
	private final SearchDAO searchDAO = new SearchDAOImpl();
	private final UserDAO userDAO = new UserDAOImpl();
	
	private DAOFactory() {}

	public static DAOFactory getInstance() {
		if(instance == null){
			instance = new DAOFactory();
		}
		return instance;
	}

	public AdministrationDAO getAdministrationDAO() {
		return administrationDAO;
	}

	public CartDAO getCartDAO() {
		return cartDAO;
	}

	public DAOInitialization getDaoInitialization() {
		return daoInitialization;
	}

	public SearchDAO getSearchDAO() {
		return searchDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
}
