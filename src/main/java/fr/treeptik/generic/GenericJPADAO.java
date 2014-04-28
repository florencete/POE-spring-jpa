package fr.treeptik.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.exception.DAOException;

@Repository
public abstract class GenericJPADAO<T, K> implements GenericDAO<T, K>{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> type;

	public GenericJPADAO(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public T save(T entity) throws DAOException{
		try{
			entityManager.persist(entity);
		}catch(PersistenceException e){
			throw new DAOException("Erreur save entity", e);
		}
		return entity;
	}
	
	@Override
	public T update(T entity) throws DAOException{
		try{
			entity = entityManager.merge(entity);
		}catch(PersistenceException e){
			throw new DAOException("Erreur update entity", e);
		}
		return entity;
	}
	
	@Override
	public void remove(T entity) throws DAOException{
		try{
			entityManager.remove(entity);
		}catch(PersistenceException e){
			throw new DAOException("Erreur remove entity", e);
		}
	}
	
	@Override
	public T findById(K id) throws DAOException{
		T personne = null;
		try{
			personne = entityManager.find(type, id);
		}catch(PersistenceException e){
			throw new DAOException("Erreur finById entity", e);
		}
		return personne;
	}
	
	@Override
	public List<T> findAll() throws DAOException{
		try{
			TypedQuery<T> query = entityManager.createQuery("select t from " + type.getName() + " p", type);
			return query.getResultList();
		}catch(PersistenceException e){
			throw new DAOException("Erreur findAll entity", e);
		}
	}
}
