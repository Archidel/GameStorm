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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRelease == null) ? 0 : dataRelease.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((developer == null) ? 0 : developer.hashCode());
		result = prime * result + ((gameplay == null) ? 0 : gameplay.hashCode());
		result = prime * result + ((ganre == null) ? 0 : ganre.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((partOfseries == null) ? 0 : partOfseries.hashCode());
		result = prime * result + price;
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (dataRelease == null) {
			if (other.dataRelease != null)
				return false;
		} else if (!dataRelease.equals(other.dataRelease))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (developer == null) {
			if (other.developer != null)
				return false;
		} else if (!developer.equals(other.developer))
			return false;
		if (gameplay == null) {
			if (other.gameplay != null)
				return false;
		} else if (!gameplay.equals(other.gameplay))
			return false;
		if (ganre == null) {
			if (other.ganre != null)
				return false;
		} else if (!ganre.equals(other.ganre))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (partOfseries == null) {
			if (other.partOfseries != null)
				return false;
		} else if (!partOfseries.equals(other.partOfseries))
			return false;
		if (price != other.price)
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", price=" + price + ", developer=" + developer + ", dataRelease="
				+ dataRelease + ", partOfseries=" + partOfseries + ", ganre=" + ganre + ", image=" + image + ", site="
				+ site + ", status=" + status + ", description=" + description + ", gameplay=" + gameplay + "]";
	}

}
