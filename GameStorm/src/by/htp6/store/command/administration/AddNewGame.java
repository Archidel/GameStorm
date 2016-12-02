package by.htp6.store.command.administration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.store.bean.Game;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.AdministrationService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class AddNewGame implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		Game game = packingGame(response, request);
		String page = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();
		
		try {
			administrationService.AddNewGame(game);
			page = NamePage.ADMINISTRATION_PAGE;
		} catch (ServiceException e) {
			e.printStackTrace();
			page = NamePage.ERROR_PAGE;
		}
		return page;
	}
	
	private Game packingGame(HttpServletResponse response, HttpServletRequest request){
		String name = request.getParameter(NameParameter.PRM_GAME_NAME);
		String priceStr = request.getParameter(NameParameter.PRM_GAME_PRICE);
		String developer = request.getParameter(NameParameter.PRM_GAME_DEVELOPER);
		String dataRelease = request.getParameter(NameParameter.PRM_GAME_DATA_RELEASE);
		String partOfSeries = request.getParameter(NameParameter.PRM_GAME_PART_OF_SERIES);
		String genre = request.getParameter(NameParameter.PRM_GAME_GENRE);
		String image = request.getParameter(NameParameter.PRM_GAME_IMAGE);
		String site = request.getParameter(NameParameter.PRM_GAME_SITE);
		String description = request.getParameter(NameParameter.PRM_GAME_DESCRIPTION);
		String gameplay = request.getParameter(NameParameter.PRM_GAME_GAMEPLAY);
		int price = Integer.parseInt(priceStr);

		Game game = new Game();
		game.setName(name);
		game.setPrice(price);
		game.setDeveloper(developer);
		game.setDataRelease(dataRelease);
		game.setPartOfseries(partOfSeries);
		game.setGanre(genre);
		game.setImage(image);
		game.setSite(site);
		game.setDescription(description);
		game.setGameplay(gameplay);
		
		return game;
	}
	
}