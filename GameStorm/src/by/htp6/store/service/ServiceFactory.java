package by.htp6.store.service;

import by.htp6.store.service.impl.AdministrationServiceImpl;
import by.htp6.store.service.impl.CartServiceImpl;
import by.htp6.store.service.impl.DAOServiceImpl;
import by.htp6.store.service.impl.OrderServiceImpl;
import by.htp6.store.service.impl.SearchServiceImpl;
import by.htp6.store.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static ServiceFactory instance = null;
	private final AdministrationService administrationService = new AdministrationServiceImpl();
	private final CartService cartService = new CartServiceImpl();
	private final DAOService daoService = new DAOServiceImpl();
	private final SearchService searchService = new SearchServiceImpl();
	private final UserService userService = new UserServiceImpl();
	private final OrderService orderService = new OrderServiceImpl();
	
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		if(instance == null){
			instance = new ServiceFactory();
		}
		return instance;
	}

	public AdministrationService getAdministrationService() {
		return administrationService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public DAOService getDaoService() {
		return daoService;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public UserService getUserService() {
		return userService;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	
}
