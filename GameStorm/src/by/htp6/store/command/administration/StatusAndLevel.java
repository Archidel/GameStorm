package by.htp6.store.command.administration;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.User;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.AdministrationService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class StatusAndLevel implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String idUserForAddToBlackList = request.getParameter(NameParameter.CMD_ADD_TO_BLACK_LIST);
		String idUserForUpDownAccessLevel = request.getParameter(NameParameter.CMD_UP_DOWN_ACCESS_LEVEL);
		String page = null;
		int idUser;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();
		
		if(idUserForAddToBlackList !=null){
			idUser = Integer.parseInt(idUserForAddToBlackList);
			try {
				administrationService.AddToBalckList(idUser);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		
		if (idUserForUpDownAccessLevel !=null){
			idUser = Integer.parseInt(idUserForUpDownAccessLevel);
			try {
				administrationService.UpDownAccessLevel(idUser);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		page = updateUserList(request, response);
		return page;
	}

	private String updateUserList(HttpServletRequest request, HttpServletResponse response){
	
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();
		
		ArrayList<User> list = null;
		String page = null;
		try {
			list = administrationService.ShowUserList();
			page = NamePage.LIST_USER_PAGE;
		} catch (ServiceException e) {
			e.printStackTrace();
			page = NamePage.ERROR_PAGE;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user_list", list);
	
		return page;
	}
	
}