package ch.fhnw.edu.rental.services;

import java.util.List;

import ch.fhnw.edu.rental.dto.MovieDto;

public interface DtoMovieService {
	
	List<MovieDto> getAllMovies();

	MovieDto getMovieById(Long id);

	Long saveOrUpdateMovie(MovieDto movieDto);

	void deleteMovie(Long id);

}
