package org.avm.framework.ui.dnd;

import org.apache.log4j.Logger;
import org.avm.framework.ui.dnd.wrapper.CellWrapper;
import org.avm.framework.ui.dnd.wrapper.DragableWrapper;

import com.vaadin.event.Transferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.DropTarget;
import com.vaadin.event.dd.TargetDetails;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.event.dd.acceptcriteria.SourceIsTarget;
import com.vaadin.ui.Component;

public class CellDropHandler implements DropHandler {

	private static final long serialVersionUID = 211123124814470525L;

	private static final Logger LOGGER = Logger.getLogger(CellDropHandler.class);

	public CellDropHandler() {
	}

	public AcceptCriterion getAcceptCriterion() {
		return new Not(SourceIsTarget.get());
	}

	public void drop(DragAndDropEvent dropEvent) {
		Transferable transferable = dropEvent.getTransferable();
		Component source = transferable.getSourceComponent();

		if (source instanceof DragableWrapper) {
			TargetDetails dropTargetData = dropEvent.getTargetDetails();
			LOGGER.info("[dropTargetData][" + dropTargetData + "]");

			DropTarget target = dropTargetData.getTarget();

			LOGGER.info("[source][" + source + "]");
			LOGGER.info("[source.parent][" + source.getParent() + "]");
			LOGGER.info("[source.parent.parent][" + source.getParent().getParent() + "]");
			CellWrapper sourceCell = (CellWrapper) source.getParent().getParent();

			LOGGER.info("[target][" + target + "]");
			LOGGER.info("[target.parent][" + target.getParent() + "]");
			LOGGER.info("[target.parent.parent][" + target.getParent().getParent() + "]");

			CellWrapper targetCell = null;

			if (target instanceof CellWrapper) {
				targetCell = (CellWrapper) target;
			} else if (target.getParent() instanceof CellWrapper) {
				targetCell = (CellWrapper) target.getParent();
			} else {
				targetCell = (CellWrapper) target.getParent().getParent();
			}

			if (sourceCell == targetCell) {
				sourceCell.swap(target, (DragableWrapper) source);
				return;
			}

			sourceCell.remove((DragableWrapper) source);
			targetCell.add((DragableWrapper) source);
		}
	}
}
