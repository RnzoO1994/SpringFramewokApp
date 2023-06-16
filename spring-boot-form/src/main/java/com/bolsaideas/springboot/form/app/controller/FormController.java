package com.bolsaideas.springboot.form.app.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsaideas.springboot.form.app.editors.NombreMayusculasEditor;
import com.bolsaideas.springboot.form.app.models.domain.Pais;
import com.bolsaideas.springboot.form.app.models.domain.Usuario;
import com.bolsaideas.springboot.form.app.validation.UsuarioValidador;

@SessionAttributes("usuario")
@Controller
public class FormController {
	@Autowired
	private UsuarioValidador validador;
	@InitBinder
	public void initBinder( WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//el atributo Lenient, permite que no sea tan estricto al momento de convertir la fecha.
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"fechaNacimiento",new CustomDateEditor(dateFormat, true)  );
		binder.registerCustomEditor(String.class ,"nombre",new NombreMayusculasEditor( )  );
		binder.registerCustomEditor(String.class ,"apellidos",new NombreMayusculasEditor( )  );

	}
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises(){
		return Arrays.asList(
				new Pais (1,"PE","Perú"),
				new Pais (2,"CO","Colombia"),
				new Pais (3,"EC","Ecuador"),
				new Pais (4,"BR","Brasil"));
	}
	
	@ModelAttribute("paises")
	public List<String> paises (){
		return Arrays.asList("Perú","Colombia","Ecuador","Brasil");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String > paisesMap(){
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("PE","Perú");
		paises.put("CO","Colombia");
		paises.put("EC","Ecuador");
		paises.put("BR","Brasil");
		return paises;
 	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Pame");
		usuario.setApellidos("Ballesteros");
		usuario.setIdentificador("12.451.147-B");
		model.addAttribute("tituo", "formulario Usuario");
		model.addAttribute("usuario", usuario);
		return "form";

	}

	/*
	 * la anotacion @RequestParam sirve para recoger datos desde un formulario, en
	 * este caso desde del formulario form.html -- El objeto de la interfaz
	 * BindingResult, obtiene la respuesta de la validacion realizada a los objetos
	 * anotados con @valid siempre tiene que ir despues del objeto a validar,
	 * ejemplo usuario, bindingresult.
	 */
	@PostMapping("/form")
	public String procesar( @Valid Usuario usuario, BindingResult result,Model model, SessionStatus status) {
		// objeto entity o pojo.
		//validador.validate(usuario, result);
		model.addAttribute("titulo", "Resultado del formulario");
		if (result.hasErrors()) {
			/*
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(),
						"El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage())));
			});
			
			model.addAttribute("error", errores);
			*/
			return "form";
		}

		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
