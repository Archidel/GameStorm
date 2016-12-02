package by.htp6.store.dao;

import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.dao.exception.DAOException;

public interface SearchDAO {
	ArrayList<Game> SearchName(String Name) throws DAOException;
	ArrayList<Game> SearchGenre(String ganre) throws DAOException;
	ArrayList<Game> SearchGameplay(String gameplay) throws DAOException;
	ArrayList<Game> RandomGame() throws DAOException;
	Game GetGameById(int idGame) throws DAOException;
}
