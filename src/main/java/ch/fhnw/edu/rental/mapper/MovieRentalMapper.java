package ch.fhnw.edu.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ch.fhnw.edu.rental.dto.MovieDto;
import ch.fhnw.edu.rental.dto.PriceCategoryDto;
import ch.fhnw.edu.rental.dto.RentalDto;
import ch.fhnw.edu.rental.dto.UserDto;
import ch.fhnw.edu.rental.model.Movie;
import ch.fhnw.edu.rental.model.PriceCategory;
import ch.fhnw.edu.rental.model.Rental;
import ch.fhnw.edu.rental.model.User;

@Mapper(componentModel = "spring")
public interface MovieRentalMapper {
	
	@Mapping(source = "priceCategory", target = "priceCategoryId")
	MovieDto movieToMovieDto(Movie movie);
	
	PriceCategoryDto priceCategoryToPriceCategoryDto(PriceCategory priceCategory);
	
	@Mapping(source = "movie", target = "movieId")
	@Mapping(source = "user", target = "userId")
	RentalDto rentalToRentalDto(Rental rental);
	
	@Mapping(source = "rentals", target = "rentalIds")
	UserDto userToUserDto(User user);
	
	default Long priceCategoryToLong(PriceCategory priceCategory) {
		return priceCategory.getId();
	}
	
	default Long movieToLong(Movie movie) {
		return movie.getId();
	}
	
	default Long userToLong(User user) {
		return user.getId();
	}
	
	default Long rentalToLong(Rental rental) {
		return rental.getId();
	}

}
