package com.appstracta.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.repository.ICityRepository;
import com.appstracta.response.CityResponse;

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
			/*CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<City> cq =cb.createQuery(City.class);
			Root<City> root = cq.from(City.class);
			cq.select(root);*/

			// Se ejecuta Query
			//Query query = session.createQuery(cq);

			// se obtiene la lista de resultados
			//return query.getResultList();

			// Query con NamedQuery
			//return session.createNamedQuery("City.findAll").list();
			// Query con createQuery
			return session.createQuery("SELECT NEW City(c.cityId, c.city, c.lastUpdate, c1.countryId, c1.country) FROM City c JOIN c.country c1 ORDER BY c.cityId ASC").list();
		} catch (Exception ex) {
			log.error("Ocurrió un error al obtener las ciudades.", ex);
			throw new InternalException("Ocurrió un error al obtener las ciudades.");
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<CityResponse> obtenerTodosResponse() throws InternalException {
		try {
			Session session = sessionFactory.getCurrentSession();

			return session.createQuery("SELECT NEW com.appstracta.response.CityResponse(c.cityId, c.city, c.lastUpdate, c1.countryId, c1.country) FROM City c JOIN c.country c1 ORDER BY c.cityId ASC").list();
		} catch (Exception ex) {
			log.error("Ocurrió un error al obtener las ciudades.", ex);
			throw new InternalException("Ocurrió un error al obtener las ciudades.");
		}
	}

}
