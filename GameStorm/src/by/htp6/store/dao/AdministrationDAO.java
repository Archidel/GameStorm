package by.htp6.store.dao;

import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.bean.User;
import by.htp6.store.dao.exception.DAOException;

public interface AdministrationDAO {
	ArrayList<User> ShowUserList() throws DAOException;
	ArrayList<Game> ShowGameList() throws DAOException;
	void AddNewGame(Game game) throws DAOException;
	void EditGame(Game  game) throws DAOException;
	void RemoveGame(int idGame) throws DAOException;
	void UpDownAccessLevel(int idUser) throws  DAOException;
	void AddToBalckList(int idUser) throws DAOException;
	Game getGameById(int idGame) throws DAOException;
}
