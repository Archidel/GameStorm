package by.htp6.store.command.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.store.command.Command;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.service.DAOService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class InitializationDAO implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		DAOService daoService = serviceFactory.getDaoService();
		try {
			daoService.InitializationDAO();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
}
