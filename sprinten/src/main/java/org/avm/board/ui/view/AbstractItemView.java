package org.avm.board.ui.view;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.avm.common.domain.BacklogItem;
import org.avm.framework.ui.form.ItemDialog;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.theme.Icons;
import org.avm.vaadin.aspect.widget.IconButton;
import org.avm.vaadin.aspect.widget.RoundedWrapper;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractItemView<T extends BacklogItem> extends RoundedWrapper implements LayoutClickListener {

	private static final long serialVersionUID = -1952867163098261201L;

	private static final Logger LOGGER = Logger.getLogger(AbstractItemView.class);

	private HorizontalLayout footer = new HorizontalLayout();

	private ItemDialog<T> itemDialog;

	private T element;

	private VerticalLayout tags = new VerticalLayout();

	private VerticalLayout content = new VerticalLayout();

	public AbstractItemView(T element) {
		super();
		this.element = element;
		getTitle().addStyleName(Aspect.LABEL_TITLE);

		content.addListener(this);
		addComponent(content);

		tags.setSpacing(true);

		content.addComponent(tags);
		content.addComponent(footer);
	}

	@Override
	public void setColor(Color newColor) {
		super.setColor(newColor);
		itemDialog.setColor(newColor);
	}

	public void setItemDialog(ItemDialog<T> itemDialog) {
		this.itemDialog = itemDialog;
	}

	public void setTitleText(String text) {
		super.setTitleText(text);
		itemDialog.setCaption(text);
		element.setName(text);
	}

	public boolean isAnnotated() {
		return element.getNotes() != null;
	}

	public void addTag(String tag) {
		Label tagLabel = new Label(tag);
		tagLabel.addStyleName(Aspect.LABEL_TAG);
		tags.addComponent(tagLabel);
	}

	public Component getTags() {
		return tags;
	}

	@SuppressWarnings("serial")
	public void setNotes(String notes) {
		String[] split = notes.split(",");

		Set<String> noteSet = new TreeSet<String>();

		noteSet.addAll(Arrays.asList(split));

		element.setNotes(noteSet);
		if (isAnnotated()) {
			// TODO:
			IconButton iconButton = new IconButton(Icons.ICONS_NOTE_16);
			iconButton.addListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					getWindow().addWindow(itemDialog);
				}
			});
			footer.addComponent(iconButton);
		}
	}

	public void layoutClick(LayoutClickEvent event) {
		LOGGER.info("[layoutClick()][" + event + "]");
		if (event.isDoubleClick()) {
			getWindow().addWindow(itemDialog);
		}
	}
}