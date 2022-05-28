package com.appstracta.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.repository.ICityRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryImpl implements ICityRepository {

	private final Logger log = Logger.getLogger(getClass().getName());
	private SessionFactory sessionFactory;

	// Intección de dependecias por constructor
	@Autowired
	public CityRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<City> obtenerTodos() throws InternalException {
		try {
			Session session = sessionFactory.getCurrentSession();

			// Se crea Query con clases
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<City> cq =cb.createQuery(City.class);
			Root<City> root = cq.from(City.class);
			cq.select(root);

			// Se ejecuta Query
			Query query = session.createQuery(cq);

			// se obtiene la lista de resultados
			return query.getResultList();
		} catch (Exception ex) {
			log.error("Ocurrió un error al obtener las ciudades.", ex);
			throw new InternalException("Ocurrió un error al obtener las ciudades.");
		}
	}

}
