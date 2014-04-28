package fr.treeptik.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Personne;

@Service
public class PersonneServiceImpl implements PersonneService{
	
	@Autowired
	private PersonneDAO personneDAO;
	
	@Transactional
	@Override
	public Personne save(Personne personne) throws ServiceException{
		try {
			return personneDAO.save(personne);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save Service", e);
		}
	}
	
	@Transactional
	@Override
	public Personne update(Personne personne) throws ServiceException{
		try {
			return personneDAO.update(personne);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update Service", e);
		}
	}
	
	@Transactional
	@Override
	public void remove(Personne personne) throws ServiceException{
		try {
			personne = this.findById(personne.getId());
			personneDAO.remove(personne);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove Service", e);
		}
	}
	
	@Transactional
	@Override
	public Personne findById(Integer id) throws ServiceException{
		try {
			return personneDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById Service", e);
		}
	}
	
	@Transactional
	@Override
	public List<Personne> findAll() throws ServiceException{
		try {
			return personneDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll Service", e);
		}
	}
}
