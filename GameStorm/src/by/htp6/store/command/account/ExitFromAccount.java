package by.htp6.store.command.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.command.Command;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;

public class ExitFromAccount implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		HttpSession session = request.getSession();
		session.removeAttribute("logged");
		session.removeAttribute("user");
		String page = NamePage.INDEX_PAGE;
		return page;
	}

}
