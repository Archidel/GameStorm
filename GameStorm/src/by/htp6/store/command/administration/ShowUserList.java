package by.htp6.store.command.administration;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.User;
import by.htp6.store.command.Command;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.AdministrationService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class ShowUserList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		ArrayList<User> list = null;
		String page = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();
		
		try {
			list = administrationService.ShowUserList();
			HttpSession session = request.getSession();
			session.setAttribute("user_list", list);
			page = NamePage.LIST_USER_PAGE;
		} catch (ServiceException e) {
			e.printStackTrace();
			page = NamePage.ERROR_PAGE;
		}
		return page;
	}

}
