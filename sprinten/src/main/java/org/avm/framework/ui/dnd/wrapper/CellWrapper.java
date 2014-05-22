package org.avm.framework.ui.dnd.wrapper;

import java.util.Collection;
import java.util.Iterator;

import org.avm.board.ui.view.EmptyItemView;

import com.vaadin.event.dd.DropTarget;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;

/**
 * This class represents a cell in the whiteboard. Each cell contains from 1 to
 * n DropableWrappers (EmptyWrapper or DragableWrapper - encompassing ItemView).
 * By default, an empty cell represents a cell which only has 1 components -> an
 * EmptyWrapper. If a cell is not empty, the EmptyWrapper has to be removed.
 *
 *
 */
public class CellWrapper extends DropableWrapper {

	private static final long serialVersionUID = -7550237411154539017L;

	private final EmptyWrapper emptyWrapper = new EmptyWrapper();

	private boolean empty = true;

	// TODO: Actually make cell dropable -> make cell height bigger ?
	public CellWrapper() {
		super();

		getRootLayout().setWidth("100%");
		getRootLayout().setSpacing(true);

		getRootLayout().addComponent(emptyWrapper);
		getRootLayout().setComponentAlignment(emptyWrapper, Alignment.TOP_CENTER);
	}

	public boolean isEmpty() {
		return empty;
	}

	public void add(DragableWrapper newComponent) {
		if (newComponent == null) {
			throw new NullPointerException();
		}

		if (isEmpty()) {
			empty = false;
			getRootLayout().replaceComponent(emptyWrapper, newComponent);
			getRootLayout().setComponentAlignment(newComponent, Alignment.TOP_CENTER);
		} else {
			getRootLayout().addComponent(newComponent);
			getRootLayout().setComponentAlignment(newComponent, Alignment.TOP_CENTER);
		}
	}

	public void remove(DragableWrapper component) {
		getRootLayout().removeComponent(component);
		if (getRootLayout().getComponentCount() == 0) {
			getRootLayout().addComponent(emptyWrapper);
			getRootLayout().setComponentAlignment(emptyWrapper, Alignment.TOP_CENTER);
			empty = true;
		}
	}

	public void removeAll() {
		getRootLayout().removeAllComponents();
		getRootLayout().addComponent(emptyWrapper);
		getRootLayout().setComponentAlignment(emptyWrapper, Alignment.TOP_CENTER);
		empty = true;
	}

	public void addAll(Collection<DragableWrapper> components) {
		for (DragableWrapper component : components) {
			add(component);
		}
	}

	public void swap(DropTarget target, DragableWrapper source) {
		// int targetIndex = getRootLayout().getComponentIndex(target);
		// getRootLayout().removeComponent(target);
		// getRootLayout().addComponent(source, targetIndex);
		getRootLayout().replaceComponent(target, source);
		getRootLayout().setComponentAlignment(source, Alignment.TOP_CENTER);

	}

	public Iterator<Component> getIterator() {
		return getRootLayout().getComponentIterator();
	}

	@SuppressWarnings("serial")
	private static class EmptyWrapper extends DropableWrapper {

		public EmptyWrapper() {
			super();
			EmptyItemView emptyItemView = new EmptyItemView();
			getRootLayout().addComponent(emptyItemView);
			getRootLayout().setComponentAlignment(emptyItemView, Alignment.TOP_CENTER);
		}
	}
}
