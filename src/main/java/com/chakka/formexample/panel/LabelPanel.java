package com.chakka.formexample.panel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class LabelPanel extends Panel {
	public LabelPanel(String id, String labeltekst) {
		super(id);
		add(
			new Label("label", labeltekst)
		);
	}
}
