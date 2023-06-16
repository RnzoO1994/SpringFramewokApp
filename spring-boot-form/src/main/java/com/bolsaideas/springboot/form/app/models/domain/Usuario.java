package com.bolsaideas.springboot.form.app.models.domain;

 

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.bolsaideas.springboot.form.app.validation.IdentificadorRegex;
import com.bolsaideas.springboot.form.app.validation.Requerido;

/*
 * Los nombres de los atributos deben ser los mismos, que los utilizados en el formulario html.
 */
public class Usuario {
	@IdentificadorRegex
	// @Pattern(regexp= "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	private String identificador;

	// @NotEmpty (message="el username no debe ser vacío")
	private String nombre;

	// @NotEmpty
	@Requerido
	private String apellidos;

	@NotBlank

	@Size(min = 3, max = 10)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty(message = "el correo no debe ser vacío")
	@Email
	@Requerido
	private String email;

	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	/*
	 * desde la entrada el inputdate form de html5 
	 * lo envia como formato yyyy-MM-dd, por lo tanto no coincide 
	 * con el formato yyyy/MM/dd
	 * 
	 */
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	@NotNull
	private Date fechaNacimiento;
	
 
	@Valid
	private Pais pais;
	
	public Usuario() {

 	}

 
	public Usuario(String identificador, String nombre, String apellidos,
			@NotBlank @Size(min = 3, max = 10) String username, @NotEmpty String password,
			@NotEmpty(message = "el correo no debe ser vacío") @Email String email,
			@NotNull @Min(5) @Max(5000) Integer cuenta, @Past @NotNull Date fechaNacimiento, Pais pais) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.username = username;
		this.password = password;
		this.email = email;
		this.cuenta = cuenta;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;
	}


	 

	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
