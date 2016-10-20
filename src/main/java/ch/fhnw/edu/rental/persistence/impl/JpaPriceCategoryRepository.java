package ch.fhnw.edu.rental.persistence.impl;

import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.PriceCategory;
import ch.fhnw.edu.rental.persistence.PriceCategoryRepository;

@Repository
public class JpaPriceCategoryRepository extends AbstractRepository<PriceCategory> implements PriceCategoryRepository {

	@Override
	protected Class<PriceCategory> getEntityClass() {
		return PriceCategory.class;
	}

	@Override
	protected String getTableName() {
		return "PriceCategory";
	}

}
