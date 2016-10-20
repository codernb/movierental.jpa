package ch.fhnw.edu.rental.persistence.impl;

import java.text.MessageFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;

import org.springframework.beans.factory.annotation.Autowired;

import ch.fhnw.edu.rental.persistence.Repository;

public abstract class AbstractRepository<T> implements Repository<T, Long> {

	private final String SELECT_QUERY = String.format("SELECT e FROM %s e", getTableName());
	private final String SELECT_WHERE_QUERY_FORMAT = MessageFormat.format("{0} WHERE e.%s = :param", SELECT_QUERY);
	private final String COUNT_QUERY = String.format("SELECT COUNT(e) FROM %s e", getTableName());
	private final String EXISTS_QUERY_FORMAT = String.format("%s WHERE e.id = :id", COUNT_QUERY);

	@Autowired
	protected EntityManager entityManager;
	
	@PostConstruct
	private void postConstruct() {
		entityManager.setFlushMode(FlushModeType.AUTO);
	}

	protected abstract Class<T> getEntityClass();

	protected abstract String getTableName();

	protected List<T> createWhereQuery(String parameterName, String parameterValue) {
		return entityManager.createQuery(String.format(SELECT_WHERE_QUERY_FORMAT, parameterName), getEntityClass())
				.setParameter("param", parameterValue).getResultList();
	}

	@Override
	public T findOne(Long id) {
		return entityManager.find(getEntityClass(), id);
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery(SELECT_QUERY, getEntityClass()).getResultList();
	}

	@Override
	public T save(T t) {
		return entityManager.merge(t);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(getEntityClass(), id));
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Override
	public boolean exists(Long id) {
		return entityManager.createQuery(String.format(EXISTS_QUERY_FORMAT, getTableName()), Long.class)
				.setParameter("id", id).getSingleResult() > 0;
	}

	@Override
	public long count() {
		return entityManager.createQuery(COUNT_QUERY, Long.class).getSingleResult();
	}

}
