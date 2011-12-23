package com.chakka.formexample.validator;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

public class TelefonValidator extends AbstractValidator<String> {

	@Override
	protected void onValidate(IValidatable<String> validatable) {
		String telefonnummer = validatable.getValue();
		try {
			if(telefonnummer == null || telefonnummer.length() != 8){
				error(validatable, "Telefonnummerfeil");
			}
		} catch(Exception e){
			error(validatable, "Telefonnummerfeil");
		}
	}

}
