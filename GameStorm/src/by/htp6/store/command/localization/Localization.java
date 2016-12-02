package by.htp6.store.command.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.store.command.Command;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;

public class Localization implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		request.getSession(true).setAttribute("local", request.getParameter("local"));
		String page = NamePage.INDEX_PAGE;
		return page;
	}

}
