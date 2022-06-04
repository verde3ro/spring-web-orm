package com.appstracta.repository;

import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.response.CityResponse;

public interface ICityRepository {

	List<City> obtenerTodos() throws InternalException;

	List<CityResponse> obtenerTodosResponse() throws InternalException;

}
