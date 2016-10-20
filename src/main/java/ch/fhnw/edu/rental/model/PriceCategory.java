package ch.fhnw.edu.rental.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRICECATEGORIES")
@DiscriminatorColumn(name = "PRICECATEGORY_TYPE")
public abstract class PriceCategory {
	
	@Id
	@GeneratedValue
	@Column(name = "PRICECATEGORY_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
