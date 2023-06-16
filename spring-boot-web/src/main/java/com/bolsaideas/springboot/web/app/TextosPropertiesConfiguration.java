package com.bolsaideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
@PropertySource("classpath:textos/mensajes.properties")
,
@PropertySource("classpath:textos/mensajes2.properties")
})
public class TextosPropertiesConfiguration {

}
