package by.htp6.store.service;

import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.bean.User;
import by.htp6.store.service.exception.ServiceException;

public interface AdministrationService {
	ArrayList<User> ShowUserList() throws ServiceException;
	ArrayList<Game> ShowGameList() throws ServiceException;
	void AddNewGame(Game game) throws ServiceException;
	void EditGame(Game game) throws ServiceException;
	void RemoveGame(int idGame) throws ServiceException;
	void UpDownAccessLevel(int idUser) throws  ServiceException;
	void AddToBalckList(int idUser) throws ServiceException;
	Game getGameById(int idGame) throws ServiceException;
	
}
