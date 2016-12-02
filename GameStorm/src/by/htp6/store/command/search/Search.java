package by.htp6.store.command.search;

import java.util.ArrayList;

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

public class Search implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String name = request.getParameter(NameParameter.PRM_SEARCH_NAME);
		String genre = request.getParameter(NameParameter.PRM_SEARCH_GENRE);
		String gameplay = request.getParameter(NameParameter.PRM_SEARCH_GAMEPLAY);
		
		ArrayList<Game> list = null;
		String page = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SearchService searchService = serviceFactory.getSearchService();
		
		if(name != null){
			try {
				list = searchService.SearchName(name);
				page = NamePage.SEARCH_RESULT_PAGE;
			} catch (ServiceException e) {
				page = NamePage.ERROR_PAGE;
				e.printStackTrace();
			}
		}
		
		if(genre != null){
			try {
				list = searchService.SearchGenre(genre);
				page = NamePage.SEARCH_RESULT_PAGE;
			} catch (ServiceException e) {
				e.printStackTrace();
				page = NamePage.ERROR_PAGE;
			}
		}
		
		if(gameplay != null){
			try {
				list = searchService.SearchGameplay(gameplay);
				page = NamePage.SEARCH_RESULT_PAGE;
			} catch (ServiceException e) {
				e.printStackTrace();
				page = NamePage.ERROR_PAGE;
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("game_result", list);	
		
		return page;
	}

}
