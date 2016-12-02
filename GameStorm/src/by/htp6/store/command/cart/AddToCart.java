package by.htp6.store.command.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.store.bean.Cart;
import by.htp6.store.bean.Game;
import by.htp6.store.command.Command;
import by.htp6.store.command.exception.CommandNotFoundException;
import by.htp6.store.controller.NamePage;

public class AddToCart implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
	
		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute("item");
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null){
			Cart newCart = new Cart();
			newCart.addToCart(game);
			session.setAttribute("cart", newCart);
		}else{
			cart.addToCart(game);
			session.setAttribute("cart", cart);
		}
		return NamePage.SEARCH_RESULT_PAGE;
	}
}