package org.avm.vaadin.aspect.widget;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import com.vaadin.Application;
import com.vaadin.data.Buffered.SourceException;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ConversionException;
import com.vaadin.data.Property.ReadOnlyException;
import com.vaadin.data.Property.ReadOnlyStatusChangeEvent;
import com.vaadin.data.Property.ReadOnlyStatusChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.event.ShortcutListener;
import com.vaadin.terminal.ErrorMessage;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.terminal.Resource;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.AbstractComponent.ComponentErrorEvent;
import com.vaadin.ui.AbstractComponent.ComponentErrorHandler;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Link;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Window;

public class LinkButton implements Component {

	private static final long serialVersionUID = 2132510642106465721L;

	private Link link;

	private NativeButton button;

	private boolean href;

	private AbstractComponent activeComponent;

	public LinkButton() {
		this.link = new Link();
		this.button = null;
		this.href = true;
		this.activeComponent = this.link;
	}

	public LinkButton(String caption, boolean isLink) {
		this.href = isLink;
		if (isLink) {
			this.link = new Link(caption, new ExternalResource(""));
			this.activeComponent = this.link;
		} else {
			this.button = new NativeButton(caption);
			this.activeComponent = this.button;
		}
	}

	public LinkButton(Link link) {
		this.link = link;
		this.button = null;
		this.href = true;
		this.activeComponent = this.link;
	}

	public LinkButton(String caption, Resource resource, String targetName, int width, int height, int border) {
		this.link = new Link(caption, resource, targetName, width, height, border);
		this.button = null;
		this.href = true;
		this.activeComponent = this.link;
	}

	public LinkButton(String caption, Resource resource) {
		this.link = new Link(caption, resource);
		this.button = null;
		this.href = true;
		this.activeComponent = this.link;
	}

	public LinkButton(NativeButton button) {
		this.link = null;
		this.button = button;
		this.href = false;
		this.activeComponent = this.button;
	}

	public LinkButton(String caption, ClickListener listener) {
		this.link = null;
		this.button = new NativeButton(caption, listener);
		this.href = false;
		this.activeComponent = this.button;
	}

	public LinkButton(String caption, Object target, String methodName) {
		this.link = null;
		this.button = new NativeButton(caption, target, methodName);
		this.href = false;
		this.activeComponent = this.button;
	}


	public Button getButton() {
		return button;
	}

	public Link getLink() {
		return link;
	}

	public boolean isInvalidCommitted() {
		if (!href) {
			return button.isInvalidCommitted();
		}
		return false;
	}

	public void setInvalidCommitted(boolean isCommitted) {
		if (!href) {
			button.setInvalidCommitted(isCommitted);
		}
	}

	public void commit() throws SourceException, InvalidValueException {
		if (!href) {
			button.commit();
		}
	}

	public void discard() throws SourceException {
		if (!href) {
			button.discard();
		}
	}

	public boolean isModified() {
		if (!href) {
			return button.isModified();
		}
		return false;
	}

	public boolean isWriteThrough() {
		if (!href) {
			return button.isWriteThrough();
		}
		return false;
	}

	public void setWriteThrough(boolean writeThrough) throws SourceException, InvalidValueException {
		if (!href) {
			button.setWriteThrough(writeThrough);
		}
	}

	public boolean isReadThrough() {
		if (!href) {
			return button.isReadThrough();
		}
		return false;
	}

	public void setReadThrough(boolean readThrough) throws SourceException {
		if (!href) {
			button.setReadThrough(readThrough);
		}
	}

	public Object getValue() {
		if (!href) {
			return button.getValue();
		}
		return link.getData();
	}

	public void setValue(Object newValue) throws ReadOnlyException, ConversionException {
		if (!href) {
			button.setValue(newValue);
		}
	}

	public Property getPropertyDataSource() {
		if (!href) {
			return button.getPropertyDataSource();
		}
		return null;
	}

	public void setPropertyDataSource(Property newDataSource) {
		if (!href) {
			button.setPropertyDataSource(newDataSource);
		}
	}

	public void addValidator(Validator validator) {
		if (!href) {
			button.addValidator(validator);
		}
	}

	public Collection<Validator> getValidators() {
		if (!href) {
			return button.getValidators();
		}
		return null;

	}

	public void removeValidator(Validator validator) {
		if (!href) {
			button.removeValidator(validator);
		}
	}

	public boolean isValid() {
		if (!href) {
			return button.isValid();
		}
		return false;
	}

	public void validate() throws InvalidValueException {
		if (!href) {
			button.validate();
		}
	}

	public boolean isInvalidAllowed() {
		if (!href) {
			return button.isInvalidAllowed();
		}
		return false;
	}

	public void setInvalidAllowed(boolean invalidAllowed) throws UnsupportedOperationException {
		if (!href) {
			button.setInvalidAllowed(invalidAllowed);
		}
	}

	public void addListener(ValueChangeListener listener) {
		if (!href) {
			button.addListener(listener);
		}
	}

	public void removeListener(ValueChangeListener listener) {
		if (!href) {
			button.removeListener(listener);
		}
	}

	public void readOnlyStatusChange(ReadOnlyStatusChangeEvent event) {
		if (!href) {
			button.readOnlyStatusChange(event);
		}
	}

	public void addListener(ReadOnlyStatusChangeListener listener) {
		if (!href) {
			button.addListener(listener);
		}
	}

	public void removeListener(ReadOnlyStatusChangeListener listener) {
		if (!href) {
			button.removeListener(listener);
		}
	}

	public void valueChange(ValueChangeEvent event) {
		if (!href) {
			button.valueChange(event);
		}
	}

	public void focus() {
		if (!href) {
			button.focus();
		}
	}

	public int getTabIndex() {
		if (!href) {
			return button.getTabIndex();
		}
		return 0;
	}

	public void setTabIndex(int tabIndex) {
		if (!href) {
			button.setTabIndex(tabIndex);
		}
	}

	public boolean isRequired() {
		if (!href) {
			return button.isRequired();
		}
		return false;
	}

	public void setRequired(boolean required) {
		if (!href) {
			button.setRequired(required);
		}
	}

	public void setRequiredError(String requiredMessage) {
		if (!href) {
			button.setRequiredError(requiredMessage);
		}
	}

	public String getRequiredError() {
		if (!href) {
			return button.getRequiredError();
		}
		return null;
	}

	public boolean isValidationVisible() {
		if (!href) {
			return button.isValidationVisible();
		}
		return false;
	}

	public void setValidationVisible(boolean validateAutomatically) {
		if (!href) {
			button.setValidationVisible(validateAutomatically);
		}
	}

	public void setCurrentBufferedSourceException(SourceException currentBufferedSourceException) {
		if (!href) {
			button.setCurrentBufferedSourceException(currentBufferedSourceException);
		}
	}

	public void addShortcutListener(ShortcutListener shortcut) {
		if (!href) {
			button.addShortcutListener(shortcut);
		}
	}

	public void removeShortcutListener(ShortcutListener shortcut) {
		if (!href) {
			button.removeShortcutListener(shortcut);
		}
	}

	public ErrorMessage getErrorMessage() {
		return activeComponent.getErrorMessage();
	}

	public void addListener(Class<?> eventType, Object target, Method method) {
		activeComponent.addListener(eventType, target, method);
	}

	public void addListener(Class<?> eventType, Object target, String methodName) {
		activeComponent.addListener(eventType, target, methodName);
	}

	public void paintContent(PaintTarget target) throws PaintException {
		activeComponent.paintContent(target);
	}

	public boolean booleanValue() {
		if (!href) {
			return button.booleanValue();
		}
		return false;
	}

	public void setImmediate(boolean immediate) {
		activeComponent.setImmediate(immediate);
	}

	public Class<Boolean> getType() {
		return Boolean.class;
	}

	public void addListener(ClickListener listener) {
		if (!href) {
			button.addListener(listener);
		}
	}

	public void removeListener(ClickListener listener) {
		if (!href) {
			button.removeListener(listener);
		}
	}

	public void addListener(BlurListener listener) {
		if (!href) {
			button.addListener(listener);
		}
	}

	public void removeListener(BlurListener listener) {
		if (!href) {
			button.removeListener(listener);
		}
	}

	public void addListener(FocusListener listener) {
		if (!href) {
			button.addListener(listener);
		}
	}

	public void removeListener(FocusListener listener) {
		if (!href) {
			button.removeListener(listener);
		}
	}

	public void setClickShortcut(int keyCode, int... modifiers) {
		if (!href) {
			button.setClickShortcut(keyCode, modifiers);
		}
	}

	public void removeClickShortcut() {
		if (!href) {
			button.removeClickShortcut();
		}
	}

	public void setLocale(Locale locale) {
		activeComponent.setLocale(locale);
	}

	public String getDescription() {
		return activeComponent.getDescription();
	}

	public void setDescription(String description) {
		activeComponent.setDescription(description);
	}

	public ErrorMessage getComponentError() {
		return activeComponent.getComponentError();
	}

	public void setComponentError(ErrorMessage componentError) {
		activeComponent.setComponentError(componentError);
	}

	public void removeListener(Class<?> eventType, Object target) {
		activeComponent.removeListener(eventType, target);
	}

	public void removeListener(Class<?> eventType, Object target, Method method) {
		activeComponent.removeListener(eventType, target, method);
	}

	public void removeListener(Class<?> eventType, Object target, String methodName) {
		activeComponent.removeListener(eventType, target, methodName);
	}

	public Collection<?> getListeners(Class<?> eventType) {
		return activeComponent.getListeners(eventType);
	}

	public void setData(Object data) {
		activeComponent.setData(data);
	}

	public Object getData() {
		return activeComponent.getData();
	}

	public ComponentErrorHandler getErrorHandler() {
		return activeComponent.getErrorHandler();
	}

	public void setErrorHandler(ComponentErrorHandler errorHandler) {
		activeComponent.setErrorHandler(errorHandler);
	}

	public boolean handleError(ComponentErrorEvent error) {
		return activeComponent.handleError(error);
	}

	public int getTargetBorder() {
		if (href) {
			link.getTargetBorder();
		}
		return 0;
	}

	public int getTargetHeight() {
		if (href) {
			link.getTargetHeight();
		}
		return 0;
	}

	public String getTargetName() {
		if (href) {
			link.getTargetName();
		}
		return null;
	}

	public int getTargetWidth() {
		if (href) {
			link.getTargetWidth();
		}
		return 0;
	}

	public void setTargetBorder(int targetBorder) {
		if (href) {
			link.setTargetBorder(targetBorder);
		}
	}

	public void setTargetHeight(int targetHeight) {
		if (href) {
			link.setTargetHeight(targetHeight);
		}
	}

	public void setTargetName(String targetName) {
		if (href) {
			link.setTargetName(targetName);
		}
	}

	public void setTargetWidth(int targetWidth) {
		if (href) {
			link.setTargetWidth(targetWidth);
		}
	}

	public Resource getResource() {
		if (href) {
			link.getResource();
		}
		return null;
	}

	public void setResource(Resource resource) {
		if (href) {
			link.setResource(resource);
		}
	}

	public void changeVariables(Object source, Map<String, Object> variables) {
		activeComponent.changeVariables(source, variables);
	}

	public void requestRepaint() {
		activeComponent.requestRepaint();
	}

	public void setDebugId(String id) {
		activeComponent.setDebugId(id);
	}

	public boolean isImmediate() {
		return activeComponent.isImmediate();
	}

	public String getStyleName() {
		return activeComponent.getStyleName();
	}

	public String getDebugId() {
		return activeComponent.getDebugId();
	}

	public float getWidth() {
		return activeComponent.getWidth();
	}

	public void setStyleName(String style) {
		activeComponent.setStyleName(style);
	}

	public float getHeight() {
		return activeComponent.getHeight();
	}

	public void addListener(RepaintRequestListener listener) {
		activeComponent.addListener(listener);
	}

	public int getWidthUnits() {
		return activeComponent.getWidthUnits();
	}

	public void removeListener(RepaintRequestListener listener) {
		activeComponent.removeListener(listener);
	}

	public void requestRepaintRequests() {
		activeComponent.requestRepaintRequests();
	}

	public int getHeightUnits() {
		return activeComponent.getHeightUnits();
	}

	public void addStyleName(String style) {
		activeComponent.addStyleName(style);
	}

	public void setHeight(String height) {
		activeComponent.setHeight(height);
	}

	public void setWidth(float width, int unit) {
		activeComponent.setWidth(width, unit);
	}

	public void removeStyleName(String style) {
		activeComponent.removeStyleName(style);
	}

	public void setHeight(float height, int unit) {
		activeComponent.setHeight(height, unit);
	}

	public boolean isEnabled() {
		return activeComponent.isEnabled();
	}

	public void setWidth(String width) {
		activeComponent.setWidth(width);
	}

	public void setEnabled(boolean enabled) {
		activeComponent.setEnabled(enabled);
	}

	public void setSizeFull() {
		activeComponent.setSizeFull();
	}

	public void setSizeUndefined() {
		activeComponent.setSizeUndefined();
	}

	public boolean isVisible() {
		return activeComponent.isVisible();
	}

	public void setVisible(boolean visible) {
		activeComponent.setVisible(visible);
	}

	public Component getParent() {
		return activeComponent.getParent();
	}

	public void setParent(Component parent) {
		activeComponent.setParent(parent);
	}

	public boolean isReadOnly() {
		return activeComponent.isReadOnly();
	}

	public void setReadOnly(boolean readOnly) {
		activeComponent.setReadOnly(readOnly);
	}

	public String getCaption() {
		return activeComponent.getCaption();
	}

	public void setCaption(String caption) {
		activeComponent.setCaption(caption);
	}

	public Resource getIcon() {
		return activeComponent.getIcon();
	}

	public void setIcon(Resource icon) {
		activeComponent.setIcon(icon);
	}

	public Window getWindow() {
		return activeComponent.getWindow();
	}

	public Application getApplication() {
		return activeComponent.getApplication();
	}

	public void attach() {
		activeComponent.attach();
	}

	public void detach() {
		activeComponent.detach();
	}

	public Locale getLocale() {
		return activeComponent.getLocale();
	}

	public void childRequestedRepaint(Collection<RepaintRequestListener> alreadyNotified) {
		activeComponent.childRequestedRepaint(alreadyNotified);
	}

	public void addListener(Listener listener) {
		activeComponent.addListener(listener);
	}

	public void removeListener(Listener listener) {
		activeComponent.removeListener(listener);
	}

	public void paint(PaintTarget target) throws PaintException {
		activeComponent.paint(target);
	}

	public void setWidth(float width) {
		// Deprecated
	}

	public void setHeight(float height) {
		// Deprecated

	}

	public void setWidthUnits(int units) {
		// Deprecated

	}

	public void setHeightUnits(int units) {
		// Deprecated
	}

	@Override
	public int hashCode() {
		return activeComponent.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LinkButton other = (LinkButton) obj;
		if (activeComponent == null) {
			if (other.activeComponent != null) {
				return false;
			}
		} else if (!activeComponent.equals(other.activeComponent)) {
			return false;
		}
		return true;
	}

	public String toString() {
		return activeComponent.toString();
	}
}
