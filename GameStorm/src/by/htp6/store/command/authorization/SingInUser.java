package by.htp6.store.command.authorization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.User;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.UserService;
import by.htp6.store.service.exception.ServiceException;

public class SingInUser implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		User user = null;
		String page = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		
		String login = request.getParameter(NameParameter.PRM_USER_LOGIN);
		String password = request.getParameter(NameParameter.PRM_USER_PASSWORD);
		
		try {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);			
			user = userService.SingInUser(user);
					
			if(user.getId() != 0){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("logged", true);	
				page = NamePage.INDEX_PAGE;
			}else{
				page = NamePage.ERROR_PAGE;
			}
		} catch (ServiceException e) {
			page = NamePage.ERROR_PAGE;
			e.printStackTrace();
		}
		
		return page;
	}

}