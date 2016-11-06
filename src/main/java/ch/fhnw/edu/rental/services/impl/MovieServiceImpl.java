package ch.fhnw.edu.rental.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.edu.rental.model.Movie;
import ch.fhnw.edu.rental.model.PriceCategory;
import ch.fhnw.edu.rental.persistence.MovieRepository;
import ch.fhnw.edu.rental.persistence.PriceCategoryRepository;
import ch.fhnw.edu.rental.services.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	private Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private PriceCategoryRepository priceCategoryRepo;

	@Override
	public Movie getMovieById(Long id) {
		return movieRepo.findOne(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieRepo.findAll();
		log.debug("getAllMovies() done");
		return movies;
	}

	@Override
	public List<Movie> getMoviesByTitle(String title) {
		return movieRepo.findByTitle(title);
	}

	@Override
	public Movie saveMovie(Movie movie) {
		if (movie == null) {
			throw new RuntimeException("'movie' parameter is not set!");
		}
		movie = movieRepo.save(movie);
		log.debug("saved or updated movie[" + movie.getId() + "]");
		return movie;
	}

	@Override
	public void deleteMovie(Movie movie) {
		if (movie == null) {
			throw new RuntimeException("'movie' parameter is not set!");
		}
		if (movie.isRented()) {
			throw new RuntimeException("movie is still used");
		}

		movieRepo.delete(movie);

		if (log.isDebugEnabled()) {
			log.debug("movie[" + movie.getId() + "] deleted");
		}
	}

	@Override
	public List<PriceCategory> getAllPriceCategories() {
		return priceCategoryRepo.findAll();
	}

}
