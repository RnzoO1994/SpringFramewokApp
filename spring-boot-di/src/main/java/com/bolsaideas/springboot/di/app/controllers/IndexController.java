package com.bolsaideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsaideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	// se puede inyectar una dependencia mediante atributo ,  metodo set y  constructor (de manera implicita o explicita) .
	@Autowired
	private IServicio servicio;

	@GetMapping({ "/", "", "/index" })
	public String index(Model model) {
		model.addAttribute("objeto", servicio.Operacion());
		return "index";
	}

}
