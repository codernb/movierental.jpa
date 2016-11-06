package ch.fhnw.edu.rental.dto;

import java.util.Date;

public class RentalDto {

	private long id;
	private long movieId;
	private long userId;
	private Date rentalDate;
	private int rentalDays;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public int getRentalDays() {
		return rentalDays;
	}
	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

}
