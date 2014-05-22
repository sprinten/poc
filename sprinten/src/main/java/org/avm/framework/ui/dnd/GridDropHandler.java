package org.avm.framework.ui.dnd;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.And;
import com.vaadin.incubator.dragdroplayouts.DDGridLayout;
import com.vaadin.incubator.dragdroplayouts.DDGridLayout.GridLayoutTargetDetails;
import com.vaadin.incubator.dragdroplayouts.events.HorizontalLocationIs;
import com.vaadin.incubator.dragdroplayouts.events.LayoutBoundTransferable;
import com.vaadin.incubator.dragdroplayouts.events.VerticalLocationIs;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;

public class GridDropHandler implements DropHandler {

	private static final long serialVersionUID = 211123124814470525L;

	private DDGridLayout layout;

	public GridDropHandler(DDGridLayout gridLayout) {
		this.layout = gridLayout;
	}

	public AcceptCriterion getAcceptCriterion() {
		// Only allow dropping in the middle of the cell
		return new And(VerticalLocationIs.MIDDLE, HorizontalLocationIs.CENTER);
	}

	public void drop(DragAndDropEvent event) {
		// Get GridLayout specific target details
		GridLayoutTargetDetails details = (GridLayoutTargetDetails) event.getTargetDetails();

		// Get the transferable (We now the component comes from a layout so we
		// can cast
		// it without checking)
		LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();

		// Get the cell column
		int column = details.getOverColumn();

		// Get the cell row
		int row = details.getOverRow();

		// Get the dragged component
		Component c = transferable.getComponent();

		// If cell is empty then drop it there
		if (layout.getComponent(column, row) == null) {
			layout.removeComponent(c);
			layout.addComponent(c, column, row);
			layout.setComponentAlignment(c, Alignment.MIDDLE_CENTER);
		}
	}
}
