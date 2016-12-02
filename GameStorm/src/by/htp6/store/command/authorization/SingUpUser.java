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

public class SingUpUser implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String confPassword = request.getParameter(NameParameter.PRM_USER_RE_PASSWORD);
		User user = packingUser(request, response);
		String page = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		
		try {
			user = userService.SingUpUser(user, confPassword);
			
			if(user != null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("logged", true);
				page = NamePage.INDEX_PAGE;		
			}else{
				page  = NamePage.ERROR_PAGE;
			}
		} catch (ServiceException e) {
			page = NamePage.ERROR_PAGE;
			e.printStackTrace();
		}
		return page;
	}

	private User packingUser(HttpServletRequest request, HttpServletResponse response){
		String login = request.getParameter(NameParameter.PRM_USER_LOGIN);
		String name = request.getParameter(NameParameter.PRM_USER_NAME);
		String surname = request.getParameter(NameParameter.PRM_USER_SURNAME);
		String yearsOld = request.getParameter(NameParameter.PRM_USER_YEARS_OLD);
		String email = request.getParameter(NameParameter.PRM_USER_EMAIL);
		String password = request.getParameter(NameParameter.PRM_USER_PASSWORD);
		
		User user = new User();
		user.setLogin(login);
		user.setEmail(email);
		user.setName(name);
		user.setSurname(surname);
		user.setPassword(password);
		user.setYearsOld(yearsOld);
		
		return user;
	}
	
}
