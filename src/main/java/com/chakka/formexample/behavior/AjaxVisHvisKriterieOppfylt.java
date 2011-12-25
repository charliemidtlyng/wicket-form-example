package com.chakka.formexample.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.markup.html.form.FormComponent;

/**
 * Klasse som viser og skjuler komponenter ved endring av andre komponenter
 * @author kjell midtlyng
 *
 */
public class AjaxVisHvisKriterieOppfylt extends AbstractAjaxBehavior {

	Kriterie kriterie;
	FormComponent[] masterComponents;
	
	public AjaxVisHvisKriterieOppfylt(Kriterie kriterie, FormComponent... masterComponents) {
		this.kriterie = kriterie;
		this.masterComponents = masterComponents;
	}
	
	/**
	 * Binde masterkomponentene til onchange og oppdatere komponenten som skal vises/skjules
	 */
	@Override
	protected void onBind() {
		final Component c = getComponent();
		c.setVisible(kriterie.kriterieOppfylt());
		
		for(final FormComponent masterComponent : masterComponents){
			masterComponent.add(new AjaxFormComponentUpdatingBehavior("onchange") {
				@Override
				protected void onUpdate(AjaxRequestTarget target) {
			        c.setVisible(kriterie.kriterieOppfylt(masterComponents));
			        target.addComponent(c);
				}
        	});
		}	
	}

	public void onRequest() {
	}

}
