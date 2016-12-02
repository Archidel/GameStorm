package by.htp6.store.service;

import by.htp6.store.bean.Cart;
import by.htp6.store.service.exception.ServiceException;

public interface OrderService {
	void makeOrder(Cart cart) throws ServiceException;
}
