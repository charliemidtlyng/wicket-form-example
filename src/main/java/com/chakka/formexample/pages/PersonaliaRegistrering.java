package com.chakka.formexample.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;

import com.chakka.formexample.UserSession;
import com.chakka.formexample.behavior.AjaxVisHvisKriterieOppfylt;
import com.chakka.formexample.behavior.HarFyltInnAlleFeltKriterier;
import com.chakka.formexample.formcomponent.TekstfeltMedLabel;
import com.chakka.formexample.model.Personalia;
import com.chakka.formexample.validator.IkkeTallValidator;
import com.chakka.formexample.validator.TelefonValidator;

public class PersonaliaRegistrering extends WebPage {

	UserSession session = UserSession.get();

	public PersonaliaRegistrering() {
		
		Form form = new Form<Personalia>("form", new CompoundPropertyModel(session.personalia));
		TekstfeltMedLabel fornavn;
		TekstfeltMedLabel etternavn;
		TekstfeltMedLabel telefon;
		add(
			form.add(
				fornavn = new TekstfeltMedLabel("fornavn", form.getModel(), "Fornavn:")
								.addToField(new IkkeTallValidator()),
				etternavn = new TekstfeltMedLabel("etternavn", form.getModel(), "Etternavn:")
								.addToField(new IkkeTallValidator()),
				telefon = new TekstfeltMedLabel("telefon", form.getModel(), "Telefon:")
								.setRequired(true)
								.addToField(new TelefonValidator()),
				new Button("submit"){
					@Override
                    public void onSubmit() {
                       setResponsePage(Ferdig.class); 
                    }
					
				},
				new Label("tekst", new LoadableDetachableModel() {

					@Override
					protected Object load() {
						Personalia p = UserSession.get().personalia;
						return "Fornavn: " + p.fornavn + " - " + "Etternavn: " + p.etternavn + " - " + "TLF: " + p.telefon;
					}
				})
					.add(new AjaxVisHvisKriterieOppfylt(new HarFyltInnAlleFeltKriterier(), fornavn.getFormComponent(), etternavn.getFormComponent(), telefon.getFormComponent()))
					.setOutputMarkupPlaceholderTag(true)
			)
		);
	}
}
