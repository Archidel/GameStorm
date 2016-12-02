package by.htp6.store.command.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.Cart;
import by.htp6.store.command.Command;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;

public class RemoveFromCart implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String remove = request.getParameter(NameParameter.PRM_REMOVE_GAME_FORM_CART);
		String page = NamePage.INDEX_PAGE;
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null){
			page = NamePage.ERROR_PAGE;
		}
		
		if(remove.equals(NameParameter.PRM_REMOVE_FROM_CART_ALL)){
			if(cart == null){
				page = NamePage.INDEX_PAGE;	
			}else{
				cart.clearList();
				session.setAttribute("cart", cart);	
			}
		}

		if(remove.equals(NameParameter.PRM_REMOVE_FROM_CART_ONE)){
			String idGameStr = request.getParameter(NameParameter.PRM_GAME_ID);
			int idGame = Integer.parseInt(idGameStr);
			cart.removeFromCart(idGame);
			session.setAttribute("cart", cart);
		}
		return page;
	}

}
