package by.htp6.store.dao.impl;

import java.io.IOException;
import java.sql.SQLException;

import by.htp6.store.dao.DAOInitialization;
import by.htp6.store.dao.connection.ConnectionPool;
import by.htp6.store.dao.exception.DAOException;

public class DAOInitializationImpl implements DAOInitialization {

	@Override
	public void InitializationDAO() throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		try {
			pool.init();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

	@Override
	public void DestroyDAO() throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		try {
			pool.close();
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

}
