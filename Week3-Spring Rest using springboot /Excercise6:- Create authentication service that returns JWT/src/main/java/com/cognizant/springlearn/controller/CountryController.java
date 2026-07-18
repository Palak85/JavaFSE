package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		return countryService.getCountry("IN");
	}

	@GetMapping({"/countries/{code}", "/country/{code}"})
	public Country getCountry(@PathVariable String code) {
		return countryService.getCountry(code);
	}

}
