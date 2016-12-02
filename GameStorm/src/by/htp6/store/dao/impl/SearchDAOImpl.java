package by.htp6.store.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.dao.SQLCommand;
import by.htp6.store.dao.SearchDAO;
import by.htp6.store.dao.connection.ConnectionPool;
import by.htp6.store.dao.exception.DAOException;

public class SearchDAOImpl implements SearchDAO {

	@Override
	public ArrayList<Game> SearchName(String name) throws DAOException {
		
		ConnectionPool pool = ConnectionPool.getInstance();
		ArrayList<Game> list = new ArrayList<Game>();
		Connection con = null;
		Game game = null;
		
		try {	
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				String [] words = rs.getString(2).split(" ");
				//Добавить разбиение и на : , .
				
				for(int i = 0; i < words.length; i++){
					if(name.equalsIgnoreCase(words[i])){
						if(rs.getBoolean(10) == true){
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
							
							list.add(game);
							break;
						}
					}
				}
			}
			pool.free(con);
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}		
		return list;
	}

	@Override
	public ArrayList<Game> SearchGenre(String genre) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		ArrayList<Game> list = new ArrayList<Game>();
		Connection con = null;
		Game game = null;
		
		try {	
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				if(rs.getString(7) != null){
					char [] array = rs.getString(7).toCharArray();
					for(int i = 0; i < array.length; i++){
						if(array[i] == ','){
							String [] words = rs.getString(7).split(",");
							for(int j = 0; j < words.length; j++){
								if(genre.equalsIgnoreCase(words[j].trim())){
									if(rs.getBoolean(10) == true){
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
										
										list.add(game);
										break;
									}
								}
							}
						}else{
							if(genre.equalsIgnoreCase(rs.getString(7).trim())){
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
								
								list.add(game);
								break;
							}
						}
					}
				}
			}
			pool.free(con);
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}		
		return list;
	}

	@Override
	public ArrayList<Game> RandomGame() throws DAOException {

		ConnectionPool pool = ConnectionPool.getInstance();
		ArrayList<Game> list = new ArrayList<Game>();
		Connection con = null;
		Game game = null;
		
		try {	
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				if(list.size() >= 12){
					break;
				}
				
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
	public Game GetGameById(int idGame) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
		Game game = null;
		
		try {	
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);
			
			while(rs.next()){
				if(rs.getInt(1) == idGame){
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

	@Override
	public ArrayList<Game> SearchGameplay(String gameplay) throws DAOException {
		ConnectionPool pool = ConnectionPool.getInstance();
		ArrayList<Game> list = new ArrayList<Game>();
		Connection con = null;
		Game game = null;
		
		try {	
			con = pool.take();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(SQLCommand.SELECT_FROM_GAMES);

			while(rs.next()){
				if(rs.getString(12) != null){
					char [] array = rs.getString(12).toCharArray();
					for(int i = 0; i < array.length; i++){
						if(array[i] == ','){
							String [] words = rs.getString(12).split(",");
							for(int j = 0; j < words.length; j++){
								if(gameplay.equalsIgnoreCase(words[j].trim())){
									if(rs.getBoolean(10) == true){
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
										
										list.add(game);
										break;
									}
								}
							}
						}else{
							if(gameplay.equalsIgnoreCase(rs.getString(12).trim())){
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
								
								list.add(game);
								break;
							}
						}
					}
				}
			}
			pool.free(con);
		} catch (InterruptedException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}		
		return list;
	}
	
}