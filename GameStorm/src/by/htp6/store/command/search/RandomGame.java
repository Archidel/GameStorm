
package by.htp6.store.command.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.Game;
import by.htp6.store.command.Command;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.SearchService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class RandomGame implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String page = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SearchService searchService = serviceFactory.getSearchService();
		
		ArrayList<Game> list = null;
		try {
			list = searchService.RandomGame();
			page = NamePage.INDEX_PAGE;
		} catch (ServiceException e) {
			e.printStackTrace();
			page = NamePage.ERROR_PAGE;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("random_list", list);
		
		return page;
	}

}
