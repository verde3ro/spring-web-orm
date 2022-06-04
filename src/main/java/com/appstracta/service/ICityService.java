package com.appstracta.service;

import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.response.CityResponse;

public interface ICityService {

	List<City> obtenerTodos() throws InternalException;

	List<CityResponse> obtenerTodosResponse() throws InternalException;

}
