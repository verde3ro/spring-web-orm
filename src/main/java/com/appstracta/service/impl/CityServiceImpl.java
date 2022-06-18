package com.appstracta.service.impl;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.model.Country;
import com.appstracta.repository.ICityRepository;
import com.appstracta.request.CityRequest;
import com.appstracta.response.CityResponse;
import com.appstracta.service.ICityService;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

	private final ICityRepository cityRepository;
	private final Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	public CityServiceImpl(ICityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<City> obtenerTodos() throws InternalException {
		try {
			return cityRepository.obtenerTodos();
		} catch (InternalException ex) {
			log.error("Ocurrió un error al obtener las ciudades.", ex);
			throw ex;
		}
	}

	@Override
	public List<CityResponse> obtenerTodosResponse() throws InternalException {
		try {
			return cityRepository.obtenerTodosResponse();
		} catch (InternalException ex) {
			log.error("Ocurrió un error al obtener las ciudades.", ex);
			throw ex;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public City guardar(CityRequest cityRequest) throws InternalException {
		try {
			if (null == cityRequest) {
				throw new InternalException("Los valores del formulario son requeridos");
			}

			City city = new City();
			city.setCity(new String(cityRequest.getCity().trim().getBytes(), StandardCharsets.UTF_8));
			city.setCountry(new Country(cityRequest.getCountryId()));
			city.setLastUpdate(new Timestamp(new Date().getTime()));

			Short id = cityRepository.guardar(city);
			city.setCityId(id);

			return city;
		} catch (InternalException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("Ocurrio un eror al guardar la ciudad", ex);
			throw new InternalException("Ocurrio un eror al guardar la ciudad");
		}
	}

}
