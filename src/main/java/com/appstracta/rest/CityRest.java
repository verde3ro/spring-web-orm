package com.appstracta.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appstracta.exception.InternalException;
import com.appstracta.service.ICityService;

@RestController
@RequestMapping("ciudad")
public class CityRest {

	private final ICityService cityService;

	@Autowired
	public CityRest(ICityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping(value ="obtenerTodosJson", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> obtenerTodosJson() {
		Map<String, Object> resultado = new HashMap<>();

		try {
			resultado.put("estatus", "success");
			resultado.put("datos", cityService.obtenerTodos());
		} catch (InternalException ex) {
			resultado.put("estatus", "error");
			resultado.put("mensaje", ex.getMessage());
		}

		return resultado;
	}

	@GetMapping(value ="obtenerTodosXml", produces = MediaType.APPLICATION_XML_VALUE)
	public Map<String, Object> obtenerTodosXml() {
		Map<String, Object> resultado = new HashMap<>();

		try {
			resultado.put("estatus", "success");
			resultado.put("datos", cityService.obtenerTodosResponse());
		} catch (InternalException ex) {
			resultado.put("estatus", "error");
			resultado.put("mensaje", ex.getMessage());
		}

		return resultado;
	}
}
