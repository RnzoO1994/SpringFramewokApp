package com.bolsaideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsaideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsaideas.springboot.di.app.models.domain.Producto;
import com.bolsaideas.springboot.di.app.models.service.IServicio;
import com.bolsaideas.springboot.di.app.models.service.MiServicio;
import com.bolsaideas.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {
	
	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	@Primary
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Camara Sony", 500.0);
		Producto producto2 = new Producto("Laptop Lenovo", 6000.0);
		ItemFactura linea1= new ItemFactura(producto1, 1);
		ItemFactura linea2= new ItemFactura(producto2, 2);
		return Arrays.asList(linea1,linea2);
	}
	@Primary
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Monitor lenovo", 300.0);
		Producto producto2 = new Producto("Impresora Lexmark", 600.0);
		Producto producto3 = new Producto("Escritorio en L", 500.0);
		Producto producto4 = new Producto("Aire acondicionado cold point", 800.0);

		ItemFactura linea1= new ItemFactura(producto1, 5);
		ItemFactura linea2= new ItemFactura(producto2, 2);
		ItemFactura linea3= new ItemFactura(producto3, 1);
		ItemFactura linea4= new ItemFactura(producto4, 1);
		return Arrays.asList(linea1,linea2,linea3,linea4);
	}
}
