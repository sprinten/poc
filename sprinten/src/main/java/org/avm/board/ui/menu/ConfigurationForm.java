package org.avm.board.ui.menu;

import org.avm.board.ui.Whiteboard;
import org.avm.vaadin.aspect.widget.ColoredButton;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;

public abstract class ConfigurationForm extends Form implements Button.ClickListener {

	private static final long serialVersionUID = 5477873887195135527L;

	private Button submit = new ColoredButton("Submit", (ClickListener) this);

	private Whiteboard whiteboard;

	public ConfigurationForm(Whiteboard whiteboard) {
		super();
		this.whiteboard = whiteboard;
		getFooter().addComponent(submit);
	}

	public Button getSubmit() {
		return submit;
	}

	public Whiteboard getBoard() {
		return whiteboard;
	}
}
