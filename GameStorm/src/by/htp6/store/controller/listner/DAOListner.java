package by.htp6.store.controller.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import by.htp6.store.command.Command;
import by.htp6.store.command.CommandProvider;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;

public class DAOListner implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	CommandProvider provider = CommandProvider.getInstatnce();	
    	try {
    		Command command = provider.getCommand(NameParameter.CMD_DESTROY_DAO);
    		command.execute(null, null);
    	} catch (CommandNotFoundException e) {
			e.printStackTrace();
		}
    }

	public void contextInitialized(ServletContextEvent sce)  { 
		CommandProvider provider = CommandProvider.getInstatnce();
    	try {
    		Command command = provider.getCommand(NameParameter.CMD_INIT_DAO);
    		command.execute(null, null);
    	} catch (CommandNotFoundException e) {
			e.printStackTrace();
		}
    }
	
}
