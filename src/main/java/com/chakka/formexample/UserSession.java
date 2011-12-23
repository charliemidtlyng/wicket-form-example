package com.chakka.formexample;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

import com.chakka.formexample.model.Personalia;

/**
 * Sesjonen som lagrer all info om dokumentene og om bruker har signert (klikket på dokumenter)
 * @author Kjell Midtlyng - BEKK
 *
 */
public class UserSession extends WebSession {

	public Personalia personalia;
	public UserSession(Request request) {
		super(request);
		personalia = new Personalia();
	}
	
	public static UserSession get () {
		return (UserSession) WebSession.get();
	}

}
