package by.htp6.store.service;

import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.service.exception.ServiceException;

public interface SearchService {
	ArrayList<Game> SearchName(String name) throws ServiceException;
	ArrayList<Game> SearchGenre(String genre) throws ServiceException;
	ArrayList<Game> SearchGameplay(String gameplay) throws ServiceException;
	ArrayList<Game> RandomGame() throws ServiceException;
	Game GetGameById(int idGame) throws ServiceException;
}
