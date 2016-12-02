package by.htp6.store.command;

import java.util.HashMap;
import java.util.Map;

import by.htp6.store.command.account.EditProfile;
import by.htp6.store.command.account.ExitFromAccount;
import by.htp6.store.command.administration.AddNewGame;
import by.htp6.store.command.administration.EditGame;
import by.htp6.store.command.administration.RemoveGame;
import by.htp6.store.command.administration.ShowGameList;
import by.htp6.store.command.administration.ShowUserList;
import by.htp6.store.command.administration.StatusAndLevel;
import by.htp6.store.command.authorization.SingInUser;
import by.htp6.store.command.authorization.SingUpUser;
import by.htp6.store.command.cart.AddToCart;
import by.htp6.store.command.cart.RemoveFromCart;
import by.htp6.store.command.dao.DestroyDAO;
import by.htp6.store.command.dao.InitializationDAO;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.command.localization.Localization;
import by.htp6.store.command.order.MakeOrder;
import by.htp6.store.command.search.MoreAboutGame;
import by.htp6.store.command.search.RandomGame;
import by.htp6.store.command.search.Search;
import by.htp6.store.command.NameParameter;

public class CommandProvider {
	private static CommandProvider instatnce;
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	private CommandProvider(){
		commands.put(NameParameter.CMD_DESTROY_DAO, new DestroyDAO());
		commands.put(NameParameter.CMD_INIT_DAO, new InitializationDAO());
		commands.put(NameParameter.CMD_LOCALIZATION, new Localization());
		commands.put(NameParameter.CMD_SING_IN_USER, new SingInUser());
		commands.put(NameParameter.CMD_SING_UP_USER, new SingUpUser());
		commands.put(NameParameter.CMD_RANDOM_GAME, new RandomGame());
		commands.put(NameParameter.CMD_SEARCH, new Search());
		commands.put(NameParameter.CMD_EDIT_PROFILE, new EditProfile());
		commands.put(NameParameter.CMD_EXIT_FROM_ACCOUNT, new ExitFromAccount());
		commands.put(NameParameter.CMD_ADD_NEW_GAME, new AddNewGame());
		commands.put(NameParameter.CMD_EDIT_GAME, new EditGame());
		commands.put(NameParameter.CMD_SHOW_GAME_LIST, new ShowGameList());
		commands.put(NameParameter.CMD_SHOW_USER_LIST, new ShowUserList());
		commands.put(NameParameter.CMD_STATUS_AND_LEVEl, new StatusAndLevel());
		commands.put(NameParameter.CMD_REMOVE_GAME, new RemoveGame());
		commands.put(NameParameter.CMD_MORE_ABOUT_GAME, new MoreAboutGame());
		commands.put(NameParameter.CMD_ADD_TO_CART, new AddToCart());
		commands.put(NameParameter.CMD_REMOVE_FROM_CART, new RemoveFromCart());
		commands.put(NameParameter.CMD_MAKE_ORDER, new MakeOrder());
	}
	
	public Command getCommand(String commandName) throws CommandNotFoundException{
		Command command;
		command = commands.get(commandName);
		if(command != null){
			return command;
		}else{
			throw new CommandNotFoundException();
		}	
	}
	
	public static CommandProvider getInstatnce() {
		if(instatnce == null){
			instatnce = new CommandProvider();
		}
		return instatnce;
	}

}
