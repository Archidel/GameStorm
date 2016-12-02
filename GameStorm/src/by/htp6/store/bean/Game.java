package by.htp6.store.bean;

import java.io.Serializable;

public class Game implements Serializable{
	private static final long serialVersionUID = -3507579743264912722L;
	
	private int id;
	private String name;
	private int price;
	private String developer;
	private String dataRelease;
	private String partOfseries;
	private String ganre;
	private String image;
	private String site;
	private boolean status;
	private String description;
	private String gameplay;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getDataRelease() {
		return dataRelease;
	}
	public void setDataRelease(String dataRelease) {
		this.dataRelease = dataRelease;
	}
	public String getPartOfseries() {
		return partOfseries;
	}
	public void setPartOfseries(String partOfseries) {
		this.partOfseries = partOfseries;
	}
	public String getGanre() {
		return ganre;
	}
	public void setGanre(String ganre) {
		this.ganre = ganre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGameplay() {
		return gameplay;
	}
	public void setGameplay(String gameplay) {
		this.gameplay = gameplay;
	}
}
