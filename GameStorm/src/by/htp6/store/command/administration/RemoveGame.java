package by.htp6.store.command.administration;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.Game;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.AdministrationService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class RemoveGame implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String idGameStr = request.getParameter(NameParameter.PRM_GAME_ID);
		int idGame = Integer.parseInt(idGameStr);
		String page = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();
		
		try {
			administrationService.RemoveGame(idGame);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		page = updateUserList(response, request);		
		return page;
	}

	private String updateUserList(HttpServletResponse response, HttpServletRequest request){

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();
		ArrayList<Game> list = null;
		String page = null;
		
		try {
			list = administrationService.ShowGameList();
			page = NamePage.LIST_GAME_PAGE;
		} catch (ServiceException e) {
			e.printStackTrace();
			page = NamePage.ERROR_PAGE;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("game_list", list);
		
		return page;
	}
	
}