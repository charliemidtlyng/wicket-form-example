package com.chakka.formexample.pages;

import org.apache.wicket.ajax.form.AjaxFormValidatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.PatternValidator;

import com.chakka.formexample.UserSession;
import com.chakka.formexample.formcomponent.TekstfeltMedLabel;
import com.chakka.formexample.model.Personalia;
import com.chakka.formexample.validator.TelefonValidator;

public class PersonaliaRegistrering extends WebPage {

	UserSession session = UserSession.get();

	public PersonaliaRegistrering() {
		
		Form form = new Form<Personalia>("form", new CompoundPropertyModel(session.personalia));
		
		add(
			form.add(
				new TekstfeltMedLabel("fornavn", form.getModel(), "Fornavn:").setRequired(true),
				new TekstfeltMedLabel("etternavn", form.getModel(), "Etternavn:").setRequired(true),
				new TekstfeltMedLabel("telefon", form.getModel(), "Telefon:").setRequired(true).addToField(new TelefonValidator()),
				new Button("submit"){
					@Override
                    public void onSubmit() {
                       setResponsePage(Ferdig.class); 
                    }

				}
			)
		);
	}
}
