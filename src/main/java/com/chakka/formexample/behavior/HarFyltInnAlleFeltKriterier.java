package com.chakka.formexample.behavior;

import org.apache.wicket.markup.html.form.FormComponent;

import com.chakka.formexample.UserSession;
import com.chakka.formexample.model.Personalia;

/**
 * To måter å lage et kriterium, enten ved å bruke modellobjektet, eller bruke formkomponentenedirekte
 * @author kjell midtlyng
 *
 */
public class HarFyltInnAlleFeltKriterier implements Kriterie {

	public boolean kriterieOppfylt() {
		Personalia personalia = UserSession.get().personalia;
		
		return 
			personalia.etternavn != null &&
			personalia.etternavn != "" &&
			personalia.fornavn != null &&
			personalia.fornavn != "" && 
			personalia.telefon != null &&
			personalia.telefon != "";
	}

	public boolean kriterieOppfylt(FormComponent[] masterComponents) {
		
		for(FormComponent masterComponent : masterComponents) {
			if(masterComponent.getValue() == null || masterComponent.getValue().length() == 0)
				return false;
		}
		return true;
	}

}
