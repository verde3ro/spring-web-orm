package com.appstracta.service;

import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;

public interface ICityService {

	List<City> obtenerTodos() throws InternalException;

}
