package ch.fhnw.edu.rental.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.Rental;
import ch.fhnw.edu.rental.model.User;
import ch.fhnw.edu.rental.persistence.RentalRepository;

@Repository
public class JpaRentalRepository extends AbstractRepository<Rental> implements RentalRepository {

	@Override
	public List<Rental> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<Rental> getEntityClass() {
		return Rental.class;
	}

	@Override
	protected String getTableName() {
		return "Rental";
	}

}
