package ch.fhnw.edu.rental.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.Movie;
import ch.fhnw.edu.rental.persistence.MovieRepository;

@Repository
public class JpaMovieRepository extends AbstractRepository<Movie> implements MovieRepository {

	@Override
	public List<Movie> findByTitle(String title) {
		return createWhereQuery("title", title);
	}

	@Override
	protected Class<Movie> getEntityClass() {
		return Movie.class;
	}

	@Override
	protected String getTableName() {
		return "Movie";
	}

}
