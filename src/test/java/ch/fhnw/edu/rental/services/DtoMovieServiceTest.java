package ch.fhnw.edu.rental.services;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.fhnw.edu.rental.dto.MovieDto;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "gui=false"})
public class DtoMovieServiceTest {
	
	@Autowired
	private DtoMovieService dtoMovieService;

	@Test
	public void testGetAllMovies() throws Exception {
		assertEquals(5, dtoMovieService.getAllMovies().size());
	}

	@Test
	public void testGetMovieById() throws Exception {
		assertEquals("The Revenant", dtoMovieService.getMovieById(1L).getTitle());
	}

	@Test
	public void testSaveOrUpdateMovie() throws Exception {
		MovieDto movieDto = new MovieDto();
		movieDto.setId(1);
		movieDto.setRented(!dtoMovieService.getMovieById(movieDto.getId()).isRented());
		movieDto.setPriceCategoryId(1);
		dtoMovieService.saveOrUpdateMovie(movieDto);
		MovieDto movieDtoFromService = dtoMovieService.getMovieById(1L);
		assertEquals(movieDto.isRented(), movieDtoFromService.isRented());
	}

	@Test
	public void testDeleteMovie() throws Exception {
		MovieDto movieDto = new MovieDto();
		movieDto.setPriceCategoryId(1);
		movieDto.setReleaseDate(new Date());
		movieDto.setTitle("test");
		Long id = dtoMovieService.saveOrUpdateMovie(movieDto);
		assertEquals(6, dtoMovieService.getAllMovies().size());
		dtoMovieService.deleteMovie(id);
		assertEquals(5, dtoMovieService.getAllMovies().size());
	}

}
