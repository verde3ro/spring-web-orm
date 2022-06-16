package com.appstracta.repository;

import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.Country;

public interface ICountryRepository {

	List<Country> obtenerTodos() throws InternalException;

}
