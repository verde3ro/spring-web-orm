package com.appstracta.controller;

import java.util.List;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.service.ICityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ciudad")
public class CityController {

	private final ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
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

}
