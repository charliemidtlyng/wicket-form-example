package com.chakka.formexample.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;
/**
 * Validator for Œ sjekke at det ikke er tall i inputfelt
 * @author kjell midtlyng
 *
 */
public class IkkeTallValidator extends AbstractValidator<String> {

	@Override
	protected void onValidate(IValidatable<String> validatable) {
		
		String streng = validatable.getValue();
		if(streng != null){
			Pattern p = Pattern.compile(".*\\d.*");
			Matcher m = p.matcher(streng);
			if(m.matches())
				error(validatable, "StrengFeil");
		}
	}

}
