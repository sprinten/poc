package org.avm.framework.ui;

import java.util.Collection;
import java.util.List;

import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;

public class LazyBeanItem<T> extends BeanItem<T> {

    private static final long serialVersionUID = 5163633077676128519L;

    public LazyBeanItem(T bean) {
        super(bean);
    }

    public LazyBeanItem(T bean, String[] propertyIds) {
        super(bean, propertyIds);
    }

    public LazyBeanItem(T bean, Collection<?> propertyIds) {
        super(bean, propertyIds);
    }

    public LazyBeanItem(BeanItem<T> beanItem) {
        this(beanItem.getBean(), beanItem.getItemPropertyIds());
    }

    @Override
    public String toString() {
        String retValue = "";

        Collection<?> itemPropertyIds = getItemPropertyIds();
        for (Object propertyId : itemPropertyIds) {
            Property itemProperty = getItemProperty(propertyId);
            if (itemProperty.getType() != List.class) {
                retValue += itemProperty.toString();
                retValue += " ";
            }
        }

        return retValue;
    }
}
