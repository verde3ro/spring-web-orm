package com.appstracta.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appstracta.exception.InternalException;
import com.appstracta.model.Country;
import com.appstracta.repository.ICountryRepository;

@Repository
public class CountryRepositoryImpl implements ICountryRepository {

	private final Logger log = Logger.getLogger(getClass().getName());
	private SessionFactory sessionFactory;

	// Intección de dependecias por constructor
	@Autowired
	public CountryRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Country> obtenerTodos() throws InternalException {
		try {
			Session session = sessionFactory.getCurrentSession();

			return session.createNamedQuery("Country.findAll").getResultList();
		} catch (Exception ex) {
			log.error("Ócurrio un error al obtner los paises.", ex);
			throw new InternalException("Ócurrio un error al obtner los paises.");
		}
	}

}
