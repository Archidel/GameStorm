package by.htp6.store.command.administration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.Game;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;
import by.htp6.store.service.AdministrationService;
import by.htp6.store.service.ServiceFactory;
import by.htp6.store.service.exception.ServiceException;

public class EditGame implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String idGameStr = request.getParameter(NameParameter.PRM_GAME_ID);
		String editSuccess = request.getParameter(NameParameter.PRM_GAME_EDIT_SUCCESS);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();
		
		Game game = null;
		String page = null;
		
		if(idGameStr != null){
			int idGame = Integer.parseInt(idGameStr);
			try {
				game = administrationService.getGameById(idGame);
				page = NamePage.EDIT_GAME_PAGE;
			} catch (ServiceException e) {
				e.printStackTrace();
				page = NamePage.ERROR_PAGE;
			}
			HttpSession session = request.getSession();
			session.setAttribute("game_edit", game);
		}
		
		if(editSuccess != null){
			game = packingGame(request, response);		
			try {
				administrationService.EditGame(game);
				page = NamePage.ADMINISTRATION_PAGE;
			} catch (ServiceException e) {
				e.printStackTrace();
				page = NamePage.ERROR_PAGE;
			}
		}
		return page;
	}
	
	private Game packingGame(HttpServletRequest request, HttpServletResponse response){
		
		String name = request.getParameter(NameParameter.PRM_GAME_NAME);
		String priceStr = request.getParameter(NameParameter.PRM_GAME_PRICE);
		int price = Integer.parseInt(priceStr);
		String image = request.getParameter(NameParameter.PRM_GAME_IMAGE);
		String developer = request.getParameter(NameParameter.PRM_GAME_DEVELOPER);
		String partOfSeries = request.getParameter(NameParameter.PRM_GAME_PART_OF_SERIES);
		String dateRelease = request.getParameter(NameParameter.PRM_GAME_DATA_RELEASE);
		String genre = request.getParameter(NameParameter.PRM_GAME_GENRE);
		String site = request.getParameter(NameParameter.PRM_GAME_SITE);
		String description = request.getParameter(NameParameter.PRM_GAME_DESCRIPTION);
		String gameplay = request.getParameter(NameParameter.PRM_GAME_GAMEPLAY);
		
		System.out.println(name);
		System.out.println(priceStr);
		System.out.println(site);
		System.out.println(dateRelease);
		System.out.println(genre);
		System.out.println(site);
		System.out.println(description);
		System.out.println(gameplay);
		
		Game game = new Game();
		HttpSession session = request.getSession();
		game = (Game) session.getAttribute("game_edit");
		
		game.setName(name);
		game.setPrice(price);
		game.setImage(image);
		game.setDeveloper(developer);
		game.setPartOfseries(partOfSeries);
		game.setDataRelease(dateRelease);
		game.setGanre(genre);
		game.setSite(site);
		game.setDescription(description);
		game.setGameplay(gameplay);

		return game;
	}
}
