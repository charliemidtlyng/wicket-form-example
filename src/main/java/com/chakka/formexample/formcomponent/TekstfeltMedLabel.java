package com.chakka.formexample.formcomponent;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.behavior.IBehavior;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.IValidator;

import com.chakka.formexample.panel.LabelPanel;

public class TekstfeltMedLabel extends LabelPanel {

	private TextField tekstfelt;
	private ComponentFeedbackPanel feilmelding;
	public TekstfeltMedLabel(String id, IModel model, String labeltekst) {
		super(id, labeltekst);
		tekstfelt = new TextField("felt", new PropertyModel(model.getObject(), getId()));
		feilmelding = lagComponentFeedbacPanel();
		
		tekstfelt.add(new AjaxFormComponentUpdatingBehavior("onblur") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.addComponent(feilmelding);
			}
			 @Override 
			 protected void onError(AjaxRequestTarget target, RuntimeException e) { 
				 super.onError(target, e); 
				 target.addComponent(tekstfelt); 
				 target.addComponent(feilmelding); 
			 } 

		});
		add(tekstfelt, feilmelding);
		
	}

	public TekstfeltMedLabel addToField(IBehavior... behaviors) {
		tekstfelt.add(behaviors);
		return this;
	}

	public TekstfeltMedLabel addToField(IValidator... validators) {
		tekstfelt.add(validators);
		return this;
	}

	public TekstfeltMedLabel setRequired(boolean bool) {
		tekstfelt.setRequired(bool);
		return this;
	}

	private ComponentFeedbackPanel lagComponentFeedbacPanel() {
		return (ComponentFeedbackPanel) new ComponentFeedbackPanel("feilmelding", tekstfelt).setOutputMarkupPlaceholderTag(true);
	}

}
