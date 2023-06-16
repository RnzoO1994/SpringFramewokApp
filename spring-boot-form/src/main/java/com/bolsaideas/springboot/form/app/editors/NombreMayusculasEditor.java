package com.bolsaideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculasEditor  extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		setValue(text.toUpperCase().trim());
		
	}
	

}
