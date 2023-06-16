package com.bolsaideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component("miServicioComplejo")

public class MiServicioComplejo implements IServicio {

	@Override
	public String Operacion() {

		return "Ejecutando servicio complejo";
	}
}
