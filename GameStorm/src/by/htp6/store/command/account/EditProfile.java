package by.htp6.store.command.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.User;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.command.exception.IncorrentDataException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.UserService;
import by.htp6.store.service.exception.ServiceException;

public class EditProfile implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String newPassword = request.getParameter(NameParameter.PRM_USER_PASSWORD); // means new password
		String confNewPassword = request.getParameter(NameParameter.PRM_USER_RE_PASSWORD);// means new re-password
	 
		User user = null;
		
		try {	//packing user for transmission to layers
			user = packingUser(request, response);
		} catch (IncorrentDataException e) {
			e.printStackTrace();
		}
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		
		try {
			user = userService.EditProfile(user, newPassword, confNewPassword);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		String page = logout(request, response);
		return page;
	}
	
	private User packingUser(HttpServletRequest request, HttpServletResponse response) throws IncorrentDataException{
		
		String name = request.getParameter(NameParameter.PRM_USER_NAME);
		String surname = request.getParameter(NameParameter.PRM_USER_SURNAME);
		String yearsOld = request.getParameter(NameParameter.PRM_USER_YEARS_OLD);
		String email = request.getParameter(NameParameter.PRM_USER_EMAIL);
		String Oldpassword = request.getParameter(NameParameter.PRM_USER_OLD_PASSWORD);
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user.getPassword().equalsIgnoreCase(Oldpassword)){
			user.setName(name);
			user.setSurname(surname);
			user.setYearsOld(yearsOld);
			user.setEmail(email);
		}else{
			throw new IncorrentDataException();
		}
		return user;
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("logged");

		return NamePage.INDEX_PAGE;
	}
}
