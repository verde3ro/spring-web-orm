package com.appstracta.repository;

import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;

public interface ICityRepository {

	List<City> obtenerTodos() throws InternalException;

}
