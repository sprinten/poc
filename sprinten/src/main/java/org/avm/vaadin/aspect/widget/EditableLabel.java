package org.avm.vaadin.aspect.widget;

import org.apache.log4j.Logger;
import org.avm.vaadin.aspect.theme.Aspect;

import com.vaadin.event.LayoutEvents;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.AbstractField.FocusShortcut;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class EditableLabel extends VerticalLayout {

	private static final long serialVersionUID = -4801998257811933396L;

	private static final Logger LOGGER = Logger.getLogger(EditableLabel.class);

	private Label label;

	private TextField field;

	@SuppressWarnings("serial")
	public EditableLabel(String title) {
		super();

		LOGGER.debug("new");

		field = new TextField();
		field.addStyleName(Aspect.ITEM_FORM);
		field.setImmediate(true);
		field.setMaxLength(20);
		field.setWidth("120px");

		field.addShortcutListener(new FocusShortcut(field, KeyCode.ENTER, null) {
			@Override
			public void handleAction(Object sender, Object target) {
				LOGGER.info("[handleAction()][sender=" + sender + "]");
				LOGGER.info("[handleAction()][target=" + target + "]");
				if (target instanceof TextField) {
					EditableLabel editable = (EditableLabel) ((TextField) target).getParent();

					editable.label.setValue(editable.field.getValue());
					editable.removeComponent(editable.field);
					editable.addComponent(editable.label);
				}
			}
		});

		label = new Label(title);
		addComponent(label);
		setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		addListener(new LabelClickListener());
	}

	public Label getLabel() {
		return label;
	}

	public void addStyleName(String style) {
		label.addStyleName(style);
	}

	public TextField getField() {
		return field;
	}

	public void setValue(String text) {
		label.setValue(text);
	}

	@SuppressWarnings("serial")
	private static class LabelClickListener implements LayoutClickListener {

		public void layoutClick(LayoutClickEvent event) {
			LOGGER.info("[layoutClick()][" + event + "]");
			Component child = event.getChildComponent();

			EditableLabel editable = (EditableLabel) event.getComponent();

			if (event.isDoubleClick() && (child instanceof Label) && event.getClass() == LayoutEvents.LayoutClickEvent.class) {

				editable.field.setValue(editable.label.getValue());
				editable.removeComponent(editable.label);
				editable.addComponent(editable.field);
			}
		}
	}

}
