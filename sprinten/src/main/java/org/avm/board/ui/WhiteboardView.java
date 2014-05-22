package org.avm.board.ui;

import org.apache.log4j.Logger;
import org.avm.board.ui.view.AbstractItemView;
import org.avm.board.ui.view.StoryView;
import org.avm.board.ui.view.TaskView;
import org.avm.common.domain.Story;
import org.avm.common.domain.Task;
import org.avm.sprinten.ui.content.Navigation;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class WhiteboardView extends Panel {

	private static final long serialVersionUID = -2723605889365152822L;
	private static final Logger LOGGER = Logger.getLogger(WhiteboardView.class);

	private VerticalLayout newContent = new VerticalLayout();

	private Whiteboard whiteboard = new Whiteboard(6, 6);

	public WhiteboardView() {
		super();

		LOGGER.debug("new");

		setCaption(Navigation.getText("page.board.caption"));
		setContent(newContent);

		setSizeFull();
		newContent.setSpacing(false);

		newContent.addComponent(whiteboard);
		newContent.setComponentAlignment(whiteboard, Alignment.MIDDLE_CENTER);
		addHeaders();
		addItems();
	}

	private void addHeaders() {
		String[] labels = new String[] { "Story", "Planned", "Progress", "Review", "Burndown", "Done" };
		for (int col = 1; col < whiteboard.getColumns() - 1; col++) {
			whiteboard.setHeaderTitle(labels[col-1], col);
		}
	}

	private void addItems() {

		for (int row = whiteboard.getFirstRealRow(); row <= whiteboard.getLastRealRow(); row++) {
			for (int col = whiteboard.getFirstRealCol(); col <= whiteboard.getLastRealCol(); col++) {
				AbstractItemView<?> itemView = new TaskView(new Task());
				if (col == 1) {
					itemView = new StoryView(new Story());
					itemView.setColor(Color.ORANGE);
					itemView.setTitleText("Story" + row);
					whiteboard.addItemView(itemView, col, row);
				} else if ((row + col) % 2 == 0) {
					if ((row + col) % 3 == 0) {
						itemView.setColor(Color.GREEN);
					} else if ((row + col) % 4 == 0) {
						itemView.setColor(Color.BROWN);
					} else if ((row + col) % 5 == 0) {
						itemView.setColor(Color.RED);
					} else if ((row + col) % 6 == 0) {
						itemView.setColor(Color.PURPLE);
					} else {
						itemView.setColor(Color.MAGENTA);
					}

					itemView.setTitleText("Task" + (row + col));
					itemView.addTag("Tag " + col);

					if (row % 2 == 0) {
						itemView.addTag("Hours left: " + row);
					}

					if (row % 3 == 0) {
						itemView.setNotes("Bolo adada bolo tralala. Check test. Arivederci.");
					}

					whiteboard.addItemView(itemView, (col == 0 ? 1 : 2), row);
				}

				itemView = new TaskView(new Task());
				itemView.setTitleText("Some text");
				itemView.setColor(Color.BLUE);
				whiteboard.addItemView(itemView, col, row);

			}

		}
	}

	public Whiteboard getBoard() {
		return whiteboard;
	}
}
