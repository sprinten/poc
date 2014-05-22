package org.avm.framework.ui.form;

import java.util.Map;

import org.apache.log4j.Logger;
import org.avm.common.domain.Element;
import org.avm.common.service.ItemService;
import org.avm.framework.ui.form.FormLayoutDescriptor.PropertyDescriptor;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.ColoredLinkButton;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;

public abstract class ItemForm<T extends Element> extends Form implements ClickListener {

	private static final long serialVersionUID = 3513457370443941648L;

	private static final Logger LOGGER = Logger.getLogger(ItemForm.class);

	private FormLayoutDescriptor descriptor;

	private ColoredLinkButton inputButton;
	private ColoredLinkButton outputButton;

	private ItemService<T> itemService = new ItemService<T>();

	private GridLayout formlay;

	private T element;

	private Color color = Color.UNDEFINED;

	public ItemForm(T element, Color newColor) {
		super();

		this.element = element;
		this.color = newColor;
		String beanName = element.getClass().getSimpleName().toLowerCase();

		descriptor = FormLayoutReader.readFormLayoutDescriptor(beanName);

		formlay = new GridLayout(descriptor.getCols(), descriptor.getRows());
		formlay.addStyleName(Aspect.ITEM_FORM);
		formlay.setSpacing(true);

		setSizeFull();

		setLayout(formlay);

		setWriteThrough(false);
		setImmediate(true);

		createFooter();
		setReadOnly(true);

		setFormFieldFactory(new ItemFieldFactory<T>());
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	protected void createFooter() {
		((HorizontalLayout) getFooter()).setSpacing(true);
		((HorizontalLayout) getFooter()).setMargin(true);

		inputButton = new ColoredLinkButton("Edit", (ClickListener) this);
		inputButton.setWidth("60px");
		inputButton.setHeight("25px");
		inputButton.setColor(color);
		getFooter().addComponent(inputButton);
		((HorizontalLayout) getFooter()).setComponentAlignment(inputButton, Alignment.BOTTOM_LEFT);

		outputButton = new ColoredLinkButton("Clean", (ClickListener) this);
		outputButton.setWidth("60px");
		outputButton.setHeight("25px");
		outputButton.setColor(color);
		getFooter().addComponent(outputButton);
		((HorizontalLayout) getFooter()).setComponentAlignment(outputButton, Alignment.BOTTOM_LEFT);

		getFooter().setVisible(true);
	}

	@Override
	public void setItemDataSource(final Item newDataSource) {

		if (newDataSource != null) {
			super.setItemDataSource(newDataSource);

			// setReadOnly(true);
			getFooter().setVisible(true);
		} else {
			super.setItemDataSource(null);
			getFooter().setVisible(true);
		}
	}

	@Override
	public void setReadOnly(final boolean readOnly) {
		super.setReadOnly(readOnly);

		if (readOnly) {
			inputButton.setCaption("Edit");
			outputButton.setCaption("Clean");
		} else {
			inputButton.setCaption("Save");
			outputButton.setCaption("Cancel");
		}
	}

	public void save(final T bean) {
		itemService.save(bean);
	}

	public void delete(final T bean) {
		itemService.delete(bean.getId());
	}

	@Override
	protected void attachField(Object propertyId, Field field) {
		Map<Object, PropertyDescriptor> positions = descriptor.getPositions();
		if (!positions.containsKey(propertyId)) {
			return;
		}

		PropertyDescriptor desc = positions.get(propertyId);

		field.setWidth(desc.getWidth(), Field.UNITS_PIXELS);

		if (desc.getHeight() != null) {
			field.setHeight(desc.getHeight(), Field.UNITS_PIXELS);
		}

		FormLayout wrapper = new FormLayout();
		wrapper.setSizeFull();

		wrapper.addComponent(field);
		wrapper.setComponentAlignment(field, Alignment.MIDDLE_LEFT);

		if (desc.getLowRightCol() == null || desc.getLowRightRow() == null) {
			formlay.addComponent(wrapper, desc.getUpLeftCol(), desc.getUpLeftRow());
		} else {
			formlay.addComponent(wrapper, desc.getUpLeftCol(), desc.getUpLeftRow(), desc.getLowRightCol(), desc.getLowRightRow());
		}
		formlay.setComponentAlignment(wrapper, Alignment.MIDDLE_LEFT);
	}

	public void buttonClick(final ClickEvent event) {
		final Button source = event.getButton();

		if (source == inputButton.getButton()) {
			if ("edit".equalsIgnoreCase(inputButton.getCaption())) {
				editClicked();
			} else {
				saveClicked();
			}
		} else if (source == outputButton.getButton()) {
			if ("clean".equalsIgnoreCase(outputButton.getCaption())) {
				cleanClicked();
			} else {
				cancelClicked();
			}
		}
	}

	private void cleanClicked() {
		delete(element);
	}

	private void editClicked() {
		setReadOnly(false);
	}

	private void cancelClicked() {
		discard();
		setReadOnly(true);
	}

	private void saveClicked() {
		LOGGER.info("[saveClicked()]");
		// TODO: See about Optimistic Locking
		if (!isValid()) {
			LOGGER.warn("error: " + getErrorMessage());
			return;
		}
		save(element);
		commit();
		setReadOnly(true);
	}

	public void setColor(Color newColor) {
		this.color = newColor;
		inputButton.setColor(newColor);
		outputButton.setColor(newColor);
	}
}