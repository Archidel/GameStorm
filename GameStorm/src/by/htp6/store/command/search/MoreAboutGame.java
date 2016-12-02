package by.htp6.store.command.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.Game;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.SearchService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class MoreAboutGame implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String idGameStr = request.getParameter(NameParameter.PRM_GAME_ID);
		String page = null;
		
		if(idGameStr != null){
			int idGame = Integer.parseInt(idGameStr);
			Game game = null;
			
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			SearchService searchService = serviceFactory.getSearchService();
			
			try {
				game = searchService.GetGameById(idGame);
				page = NamePage.GAME_PAGE;
				
			} catch (ServiceException e) {
				e.printStackTrace();
				page = NamePage.ERROR_PAGE;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("item", game);
			
		}
		return page;
	}
}