package com.bolsaideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

//@Component("miServicio")
public class MiServicio implements IServicio {

	@Override
	public String Operacion() {

		return "Servicio simple de la capa Service";
	}
}
