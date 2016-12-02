package by.htp6.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp6.store.bean.User;
import by.htp6.store.dao.SQLCommand;
import by.htp6.store.dao.UserDAO;
import by.htp6.store.dao.connection.ConnectionPool;
import by.htp6.store.dao.exception.DAOException;

public class UserDAOImpl implements UserDAO {

	@Override
	public User SingInUser(User user) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
				
		try {
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_USERS);
			
			while(rs.next()){
				if(rs.getString(7).equalsIgnoreCase(user.getLogin()) && rs.getString(8).equalsIgnoreCase(user.getPassword())){
					user = new User();		
					user.setId(rs.getInt(1));
					user.setAccessLevel(rs.getInt(2));
					user.setName(rs.getString(3));
					user.setSurname(rs.getString(4));
					user.setYearsOld(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setLogin(rs.getString(7));
					user.setPassword(rs.getString(8));
					user.setStatus(rs.getBoolean(9));
				}				
			}
			pool.free(con);	//Освобождение очереди
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return user;
	}

	@Override
	public User SingUpUser(User user, String confPassword) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection con = null;
		
		try {
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_USERS);
			
			preparedStatement = con.prepareStatement(SQLCommand.INSERT_SINGUP_USER);
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getYearsOld());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getLogin());
			preparedStatement.setString(6, user.getPassword());
			
			preparedStatement.executeUpdate();
			
			while(rs.next()){
				if(rs.getString(7).equalsIgnoreCase(user.getLogin())){
					user.setId(rs.getInt(1));
					user.setAccessLevel(rs.getInt(2));
					user.setStatus(rs.getBoolean(9));
				}	
			}
			
			pool.free(con);	//Освобождение очереди
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;
	}

	@Override
	public User EditProfile(User user) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection con = null;
		
		try {
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_USERS);
			
			preparedStatement = con.prepareStatement(SQLCommand.UPDATE_USER_EDIT_PROFILE);
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getYearsOld());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setInt(6, user.getId());
			
			while(rs.next()){
				if(rs.getString(7).equalsIgnoreCase(user.getLogin())){
					preparedStatement.executeUpdate();
				}	
			}	
			pool.free(con);	//Освобождение очереди
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return user;
	}

}
