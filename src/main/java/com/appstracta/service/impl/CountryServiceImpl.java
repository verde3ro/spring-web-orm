package com.appstracta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appstracta.exception.InternalException;
import com.appstracta.model.Country;
import com.appstracta.repository.ICountryRepository;
import com.appstracta.service.ICountryService;

@Service
@Transactional
public class CountryServiceImpl implements ICountryService {

	private final ICountryRepository countryRepository;

	@Autowired
	public CountryServiceImpl(ICountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@Override
	public List<Country> obtenerTodos() throws InternalException {
		try {
			return countryRepository.obtenerTodos();
		} catch (InternalException ex) {
			throw ex;
		}
	}

}
