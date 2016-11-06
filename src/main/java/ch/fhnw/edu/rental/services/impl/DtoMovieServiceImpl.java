package ch.fhnw.edu.rental.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.fhnw.edu.rental.dto.MovieDto;
import ch.fhnw.edu.rental.mapper.MovieRentalMapper;
import ch.fhnw.edu.rental.model.Movie;
import ch.fhnw.edu.rental.persistence.PriceCategoryRepository;
import ch.fhnw.edu.rental.services.DtoMovieService;
import ch.fhnw.edu.rental.services.MovieService;

@Service
@Transactional
public class DtoMovieServiceImpl implements DtoMovieService {

	@Autowired
	private MovieService movieService;

	@Autowired
	private PriceCategoryRepository priceCategoryRepository;

	@Autowired
	private MovieRentalMapper movieRentalMapper;

	@Override
	public List<MovieDto> getAllMovies() {
		return movieService.getAllMovies().stream().map(m -> movieRentalMapper.movieToMovieDto(m))
				.collect(Collectors.toList());
	}

	@Override
	public MovieDto getMovieById(Long id) {
		return movieRentalMapper.movieToMovieDto(movieService.getMovieById(id));
	}

	@Override
	public Long saveOrUpdateMovie(MovieDto movieDto) {
		Movie movie = movieService.getMovieById(movieDto.getId());
		if (movie == null)
			movie = new Movie(movieDto.getTitle(), movieDto.getReleaseDate(), priceCategoryRepository.getOne(movieDto.getPriceCategoryId()));
		else
			movie.setPriceCategory(priceCategoryRepository.getOne(movieDto.getPriceCategoryId()));
		movie.setRented(movieDto.isRented());
		return movieService.saveMovie(movie).getId();
	}

	@Override
	public void deleteMovie(Long id) {
		movieService.deleteMovie(movieService.getMovieById(id));
	}

}
