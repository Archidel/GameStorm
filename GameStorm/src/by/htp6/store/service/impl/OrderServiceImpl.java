package by.htp6.store.service.impl;

import by.htp6.store.bean.Cart;
import by.htp6.store.service.OrderService;
import by.htp6.store.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {

	@Override
	public void makeOrder(Cart cart) throws ServiceException {
		System.out.println("Заказ выполнен");
		
	}

}
