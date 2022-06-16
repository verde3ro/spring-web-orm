package com.appstracta.service;

import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.Country;

public interface ICountryService {

	List<Country> obtenerTodos() throws InternalException;
}
