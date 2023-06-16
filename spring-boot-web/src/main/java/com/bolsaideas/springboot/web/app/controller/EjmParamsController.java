package com.bolsaideas.springboot.web.app.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjmParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	public String param(
			@RequestParam(name = "texto", required = false, defaultValue = "valor por default") String texto,
			Model model) {
		model.addAttribute("resultado", "el texto enviado es : " + texto);

		return "params/ver";
	}

	@GetMapping("/mix-params")
	public String mixparams(@RequestParam() String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo es : '" + saludo + "' y el numero es : '" + numero + "'");

		return "params/ver";
	}

	@GetMapping("/mix-params-request")
	public String servletparams(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {

			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado", "El saludo es : '" + saludo + "' y el numero es : '" + numero + "'");

		return "params/ver";
	}
}
