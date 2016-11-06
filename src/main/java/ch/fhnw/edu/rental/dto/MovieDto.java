package ch.fhnw.edu.rental.dto;

import java.util.Date;

public class MovieDto {

	private long id;
	private String title;
	private Date releaseDate;
	private boolean rented;
	private long priceCategoryId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public long getPriceCategoryId() {
		return priceCategoryId;
	}

	public void setPriceCategoryId(long priceCategoryId) {
		this.priceCategoryId = priceCategoryId;
	}

}
