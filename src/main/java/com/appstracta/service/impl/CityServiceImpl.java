package com.appstracta.service.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.repository.ICityRepository;
import com.appstracta.response.CityResponse;
import com.appstracta.service.ICityService;

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

}
