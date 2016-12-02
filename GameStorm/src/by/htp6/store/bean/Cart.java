package by.htp6.store.bean;

import java.io.Serializable;
import java.util.LinkedList;

public class Cart implements Serializable{
	private static final long serialVersionUID = -1208266974104886915L;
	@SuppressWarnings("unused")
	private int lenghtList;
	@SuppressWarnings("unused")
	private int totalPrice;
	private LinkedList<Game> list = new LinkedList<Game>();
	
	public void addToCart(Game game){
		list.add(game);
	}
	
	public void removeFromCart(int idGame){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getId() == idGame){
				list.remove(i);
				break;
			}
		}
	}

	public LinkedList<Game> getList() {
		return list;
	}
	
	public void setList(LinkedList<Game> list) {
		this.list = list;
	}

	public void clearList(){
		list.remove();
		list.clear();
	}

	public int getLenghtList() {
		return list.size();
	}

	public void setLenghtList(int lenghtList) {
		this.lenghtList = lenghtList;
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for(int i = 0; i < list.size(); i++){
			totalPrice += list.get(i).getPrice();
		}
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}