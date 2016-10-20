package ch.fhnw.edu.rental.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.User;
import ch.fhnw.edu.rental.persistence.UserRepository;

@Repository
public class JpaUserRepository extends AbstractRepository<User> implements UserRepository {

	@Override
	public List<User> findByLastName(String lastName) {
		return createWhereQuery("lastName", lastName);
	}

	@Override
	public List<User> findByFirstName(String firstName) {
		return createWhereQuery("firstName", firstName);
	}

	@Override
	public List<User> findByEmail(String email) {
		return createWhereQuery("email", email);
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	protected String getTableName() {
		return "User";
	}

}
