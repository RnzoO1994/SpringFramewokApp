package com.bolsaideas.springboot.web.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@Value("${texto.indexcontroller.index.mensaje}")
	private String mensaje;
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textolistar;
	
	@GetMapping(value = {"/index", "/", "/home",""})
	public String  index( Model model) {
		model.addAttribute("titulo",textoIndex);
 		return  "index";
	
	}
	@RequestMapping ("/perfil")
	public String perfil(Model model){
		Usuario usuario = new Usuario();
		usuario.setApellidos("Inga");
		usuario.setNombre("Renzo");
		usuario.setEmail("renzo@gmail.com");
		model.addAttribute("usuario",usuario);
		
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar (Model model){
		//List<Usuario> lista = new ArrayList<>();
		List<Usuario> lista = Arrays.asList(new Usuario("Antonio","Inga","antonio@gmail.com"),
				new Usuario("Pame","Ballese","pame@gmail.com"),
				new Usuario("Sunni","Eyza","sunni@gmail.com"),
				new Usuario("Renzo","Inga","renzo@gmail.com"));
		/*
		lista.add(new Usuario("Antonio","Inga","antonio@gmail.com"));
		lista.add(new Usuario("Pame","Ballese","pame@gmail.com"));
		lista.add(new Usuario("Sunni","Eyza","sunni@gmail.com"));
		 */
		model.addAttribute("titulo",textolistar);
		model.addAttribute("lista",lista);
		model.addAttribute("mensaje", mensaje);
		return "listar";
		
	}
	/*
	 * @ModelAttribute se utiliza para poblar, los checklist, radio button, etc.7
	 * en este ejemplo lista contiene todos los elementos, esta lista se envia al index
	 * para luego mostrarse la lista de usuarios en la viste del index.html
	 * 
	 */
	@ModelAttribute("lista")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> lista = Arrays.asList(new Usuario("Antonio","Inga","antonio@gmail.com"),
				new Usuario("Pame","Ballese","pame@gmail.com"),
				new Usuario("Sunni","Eyza","sunni@gmail.com"),
				new Usuario("Renzo","Inga","renzo@gmail.com"));
		 return lista;
	}
}
