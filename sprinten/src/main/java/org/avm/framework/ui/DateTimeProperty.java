package org.avm.framework.ui;

import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.vaadin.data.Property;

public class DateTimeProperty implements Property {

    private static final long serialVersionUID = 1843926657810558955L;

	private static final Logger LOGGER = Logger.getLogger(DateTimeProperty.class);

    private Property sourceProperty;

    public DateTimeProperty(Property sourceProperty) {
    	LOGGER.debug("new");
        this.sourceProperty = sourceProperty;

        if (!sourceProperty.getType().equals(DateTime.class)) {
            throw new RuntimeException("Source property a not a DateTime, but is a "
                                       + sourceProperty.getType().getSimpleName());
        }
    }

    public Object getValue() {
        DateTime sourceDate = (DateTime) sourceProperty.getValue();
        Object result = null;
        if (sourceDate != null) {
            result = sourceDate.toDate();
        }
        return result;
    }

    public void setValue(Object newValue) throws ReadOnlyException, ConversionException {
        DateTime value = null;
        if (newValue != null) {
            if (newValue instanceof Date) {
                Date date = (Date) newValue;
                value = new DateTime(date);
            } else {
                throw new RuntimeException("Value supplied was not a Date.class");
            }
        }

        sourceProperty.setValue(value);

    }

    public Class<?> getType() {
        return Date.class;
    }

    public boolean isReadOnly() {
        return sourceProperty.isReadOnly();
    }

    public void setReadOnly(boolean newStatus) {
        sourceProperty.setReadOnly(newStatus);
    }
}
