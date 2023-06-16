package com.bolsaideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjmVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar  parámetros de la ruta (@PathVariable )");

		return "variables/index";
	}
	/*
	 * Se puede usar name para que el parametro de entrada coincida con el 
	 * nombre colocado en el Getmapping
	 */
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable )");
		model.addAttribute("resultado", "El texto enviado en la ruta  es : '" + texto+"'"   );
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable )");
		model.addAttribute("resultado", "El texto enviado en la ruta  es : '" + texto+"'"   
				+ " y el número enviado en el path es : " +numero);
		return "variables/ver";
	}
}