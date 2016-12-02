package by.htp6.store.dao;

import by.htp6.store.bean.Game;
import by.htp6.store.dao.exception.DAOException;

public interface CartDAO {
	void AddToCart(Game game) throws DAOException;
	void RemoveFromCart(Game game) throws DAOException;
}
