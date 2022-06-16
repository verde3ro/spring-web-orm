package com.appstracta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.service.ICityService;
import com.appstracta.service.ICountryService;

@Controller
@RequestMapping("ciudad")
public class CityController {

	private final ICityService cityService;
	private final ICountryService countryService;

	@Autowired
	public CityController(ICityService cityService, ICountryService countryService) {
		this.cityService = cityService;
		this.countryService = countryService;
	}

	@GetMapping("obtenerTodos")
	public String obtenerTodos(Model model) {
		try {
			List<City> ciudades = cityService.obtenerTodos();
			model.addAttribute("ciudades", ciudades);

			return "ciudad/obtenerTodos";
		} catch (InternalException ex) {
			return "error";
		}
	}

	@GetMapping("crear")
	public String create(Model model) {
		try {
			model.addAttribute("countries", countryService.obtenerTodos());
		} catch (InternalException ex) {
			model.addAttribute("error", ex.getMessage());
		}

		return "ciudad/crear";
	}

}
