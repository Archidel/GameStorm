package by.htp6.store.service.impl;

import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.dao.DAOFactory;
import by.htp6.store.dao.SearchDAO;
import by.htp6.store.dao.exception.DAOException;
import by.htp6.store.service.SearchService;
import by.htp6.store.service.exception.ServiceException;

public class SearchServiceImpl implements SearchService {

	@Override
	public ArrayList<Game> SearchName(String name) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		SearchDAO searchDAO = daoFactory.getSearchDAO();
		ArrayList<Game> list = null;
		
		try {
			list = searchDAO.SearchName(name.trim());
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;	
	}

	@Override
	public ArrayList<Game> SearchGenre(String genre) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		SearchDAO searchDAO = daoFactory.getSearchDAO();
		ArrayList<Game> list = null;
		
		try {
			list = searchDAO.SearchGenre(genre);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	@Override
	public ArrayList<Game> RandomGame() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		SearchDAO searchDAO = daoFactory.getSearchDAO();
		ArrayList<Game> list = null;
		
		try {
			list = searchDAO.RandomGame();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	@Override
	public Game GetGameById(int idGame) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		SearchDAO searchDAO = daoFactory.getSearchDAO();
		Game game = null;
		
		try {
			game = searchDAO.GetGameById(idGame);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return game;
	}

	@Override
	public ArrayList<Game> SearchGameplay(String gameplay) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		SearchDAO searchDAO = daoFactory.getSearchDAO();
		ArrayList<Game> list = null;
		
		try {
			list = searchDAO.SearchGameplay(gameplay);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}

}
