package by.htp6.store.service.impl;

import java.util.ArrayList;

import by.htp6.store.bean.Game;
import by.htp6.store.bean.User;
import by.htp6.store.dao.AdministrationDAO;
import by.htp6.store.dao.DAOFactory;
import by.htp6.store.dao.exception.DAOException;
import by.htp6.store.service.AdministrationService;
import by.htp6.store.service.exception.ServiceException;

public class AdministrationServiceImpl implements AdministrationService {

	@Override
	public ArrayList<User> ShowUserList() throws ServiceException {
		
		ArrayList<User> list = null;
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		
		try {
			list = administrationDAO.ShowUserList();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	@Override
	public ArrayList<Game> ShowGameList() throws ServiceException {
		ArrayList<Game> list = null;
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		
		try {
			list = administrationDAO.ShowGameList();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	@Override
	public void AddNewGame(Game game) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		
		try {
			administrationDAO.AddNewGame(game);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void EditGame(Game game) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		try {
			administrationDAO.EditGame(game);
		} catch (DAOException e) {
			e.printStackTrace();
		};
	}

	@Override
	public void RemoveGame(int idGame) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		
		try {
			administrationDAO.RemoveGame(idGame);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void UpDownAccessLevel(int idUser) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		
		try {
			administrationDAO.UpDownAccessLevel(idUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void AddToBalckList(int idUser) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		
		try {
			administrationDAO.AddToBalckList(idUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Game getGameById(int idGame) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();
		Game game = null;
		
		try {
			game = administrationDAO.getGameById(idGame);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return game;
	}

}
