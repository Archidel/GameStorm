package by.htp6.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.bean.User;
import by.htp6.store.dao.AdministrationDAO;
import by.htp6.store.dao.SQLCommand;
import by.htp6.store.dao.connection.ConnectionPool;
import by.htp6.store.dao.exception.DAOException;

public class AdministrationDAOImpl implements AdministrationDAO {

	@Override
	public ArrayList<User> ShowUserList() throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		ArrayList<User> list = new ArrayList<User>();
		Connection con = null;
		
		try {	
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_USERS);
			
			while(rs.next()){
				User user = new User();		
				user.setId(rs.getInt(1));
				user.setAccessLevel(rs.getInt(2));
				user.setName(rs.getString(3));
				user.setSurname(rs.getString(4));
				user.setYearsOld(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setLogin(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setStatus(rs.getBoolean(9));	
				
				list.add(user);
			}
			pool.free(con);	//Освобождение очереди
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public ArrayList<Game> ShowGameList() throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		ArrayList<Game> list = new ArrayList<Game>();
		Connection con = null;
		Game game = null;
		
		try {	
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				game = new Game();
				game.setId(rs.getInt(1));
				game.setName(rs.getString(2));
				game.setPrice(rs.getInt(3));
				game.setDeveloper(rs.getString(4));
				game.setDataRelease(rs.getString(5));
				game.setPartOfseries(rs.getString(6));
				game.setGanre(rs.getString(7));
				game.setImage(rs.getString(8));
				game.setSite(rs.getString(9));
				game.setStatus(rs.getBoolean(10));
				game.setDeveloper(rs.getString(11));
				game.setGameplay(rs.getString(12));
				
				list.add(game);
			}
			pool.free(con);	//Освобождение очереди
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public void AddNewGame(Game game) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try {	
			con = pool.take();
			preparedStatement = con.prepareStatement(SQLCommand.INSERT_INTO_GAME);
			
			preparedStatement.setString(1, game.getName());
			preparedStatement.setInt(2, game.getPrice());
			preparedStatement.setString(3, game.getDeveloper());
			preparedStatement.setString(4, game.getDataRelease());
			preparedStatement.setString(5, game.getPartOfseries());
			preparedStatement.setString(6, game.getGanre());
			preparedStatement.setString(7, game.getImage());
			preparedStatement.setString(8, game.getSite());
			preparedStatement.setString(9, game.getDescription());
			preparedStatement.setString(10, game.getGameplay());
			
			preparedStatement.executeUpdate();
			
			pool.free(con);	//Освобождение очереди
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}	
	}

	@Override
	public void EditGame(Game game) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
	
		try {
			con = pool.take();
			Statement state = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(SQLCommand.UPDATE_GAME_EDIT);
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				if(rs.getInt(1) == game.getId()){	//находи айдишник ю-зверя
					preparedStatement.setString(1, game.getName());
					preparedStatement.setInt(2, game.getPrice());
					preparedStatement.setString(3, game.getDeveloper());
					preparedStatement.setString(4, game.getDataRelease());
					preparedStatement.setString(5, game.getPartOfseries());
					preparedStatement.setString(6, game.getGanre());
					preparedStatement.setString(7, game.getImage());
					preparedStatement.setString(8, game.getSite());
					preparedStatement.setString(9, game.getDescription());
					preparedStatement.setString(10, game.getGameplay());
					preparedStatement.setInt(11, game.getId());

					preparedStatement.executeUpdate();
					break;
				}
			}
			pool.free(con);	//Освобождение очереди	
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void RemoveGame(int idGame) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
	
		try {
			con = pool.take();
			Statement state = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(SQLCommand.UPDATE_GAME_SET_STATUS);
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				if(rs.getInt(1) == idGame){	//находи айдишник ю-зверя
					if(rs.getInt(10) == 0){
						preparedStatement.setInt(1, 1);
						preparedStatement.setInt(2, idGame);
					}else{
						preparedStatement.setInt(1, 0);
						preparedStatement.setInt(2, idGame);
					}
				}
			}
			
			preparedStatement.executeUpdate();
			pool.free(con);	//Освобождение очереди
			
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void UpDownAccessLevel(int idUser) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
	
		try {
			con = pool.take();
			Statement state = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(SQLCommand.UPDATE_USER_SET_ACCESS_LEVEL);
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_USERS);
			
			while(rs.next()){
				if(rs.getInt(1) == idUser){	//находи айдишник ю-зверя
					if(rs.getInt(2) == 0){
						preparedStatement.setInt(1, 1);
						preparedStatement.setInt(2, idUser);
					}else{
						preparedStatement.setInt(1, 0);
						preparedStatement.setInt(2, idUser);
					}
				}
			}
			
		preparedStatement.executeUpdate();	
		pool.free(con);	//Освобождение очереди
			
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void AddToBalckList(int idUser) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
		
		try {
			con = pool.take();
			Statement state = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(SQLCommand.UPDATE_USER_SET_STATUS);
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_USERS);
			
			while(rs.next()){
				if(rs.getInt(1) == idUser){	//находи айдишник ю-зверя
					if(rs.getInt(9) == 0){
						preparedStatement.setInt(1, 1);
						preparedStatement.setInt(2, idUser);
					}else{
						preparedStatement.setInt(1, 0);
						preparedStatement.setInt(2, idUser);
					}
				}
			}
			
		preparedStatement.executeUpdate();
		pool.free(con);	//Освобождение очереди
			
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Game getGameById(int idGame) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
		Game game = null;
		try {
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				if(rs.getInt(1) == idGame){	//находи айдишник ю-зверя
					game = new Game();
					game.setId(rs.getInt(1));
					game.setName(rs.getString(2));
					game.setPrice(rs.getInt(3));
					game.setDeveloper(rs.getString(4));
					game.setDataRelease(rs.getString(5));
					game.setPartOfseries(rs.getString(6));
					game.setGanre(rs.getString(7));
					game.setImage(rs.getString(8));
					game.setSite(rs.getString(9));
					game.setStatus(rs.getBoolean(10));
					game.setDescription(rs.getString(11));
					game.setGameplay(rs.getString(12));
					
					break;
				}
			}
			pool.free(con);	//Освобождение очереди	
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return game;
	}

}
