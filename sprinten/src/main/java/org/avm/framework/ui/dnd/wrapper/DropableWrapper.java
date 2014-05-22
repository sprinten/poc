package org.avm.framework.ui.dnd.wrapper;

import org.avm.framework.ui.dnd.CellDropHandler;

import com.vaadin.event.dd.DropHandler;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DropableWrapper extends DragAndDropWrapper {

	public DropableWrapper() {
		super(new VerticalLayout());
		setWidth("95%");
	}

	@Override
	public DropHandler getDropHandler() {
		return new CellDropHandler();
	}

	protected VerticalLayout getRootLayout() {
		return (VerticalLayout) getCompositionRoot();
	}

}
