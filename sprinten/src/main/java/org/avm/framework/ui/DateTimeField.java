package org.avm.framework.ui;

import java.util.Date;

import org.joda.time.DateTime;

import com.vaadin.data.Property;
import com.vaadin.ui.DateField;

public class DateTimeField extends DateField {

    private static final long serialVersionUID = 5310979355747627434L;

    public DateTimeField() {
        super();
    }

    public DateTimeField(Property dataSource) throws IllegalArgumentException {
        super(dataSource);
    }

    public DateTimeField(String caption, Date value) {
        super(caption, value);
    }

    public DateTimeField(String caption, Property dataSource) {
        super(caption, dataSource);
    }

    public DateTimeField(String caption) {
        super(caption);
    }

    @Override
    public void setPropertyDataSource(Property newDataSource) {
        if (newDataSource.getType().equals(DateTime.class)) {
            super.setPropertyDataSource(new DateTimeProperty(newDataSource));
        } else {
            super.setPropertyDataSource(newDataSource);
        }
    }
}
