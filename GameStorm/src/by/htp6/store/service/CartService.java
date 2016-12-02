package by.htp6.store.service;

import by.htp6.store.bean.Game;
import by.htp6.store.service.exception.ServiceException;

public interface CartService {
	void AddToCart(Game game) throws ServiceException;
	void RemoveFromCart(Game game) throws ServiceException;
}
