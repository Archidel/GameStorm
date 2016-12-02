package by.htp6.store.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp6.store.command.exception.CommandNotFoundException;

public interface Command {
	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException;
}
