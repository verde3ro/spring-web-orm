package com.appstracta.controller;

import java.util.List;

import javax.validation.Valid;

import com.appstracta.exception.InternalException;
import com.appstracta.model.City;
import com.appstracta.request.CityRequest;
import com.appstracta.service.ICityService;
import com.appstracta.service.ICountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@PostMapping("guardar")
	public String guardar(Model model, @Valid @ModelAttribute("cityform") CityRequest cityRequest, BindingResult result) {
		try {
			model.addAttribute("countries", countryService.obtenerTodos());

			if (!result.hasErrors()) {
				City city = cityService.guardar(cityRequest);
				model.addAttribute("city", city);

				return "ciudad/exito";
			}

			StringBuilder mensaje = new StringBuilder();
			for(FieldError error : result.getFieldErrors()) {
				String campo = error.getField().trim() + " " + error.getDefaultMessage().trim().replace("null", "nulo") + ".";

				if (mensaje.toString().trim().isEmpty()) {
					mensaje.append(campo);
				} else {
					mensaje.append("<br />").append(campo);
				}
			}

			model.addAttribute("error", mensaje.toString());
		} catch (InternalException ex) {
			model.addAttribute("error", ex.getMessage());
		}

		return "ciudad/crear";
	}

}
