package com.chakka.formexample.behavior;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.FormComponent;

public interface Kriterie extends Serializable{

	boolean kriterieOppfylt(FormComponent[] masterComponents);
	boolean kriterieOppfylt();
}
