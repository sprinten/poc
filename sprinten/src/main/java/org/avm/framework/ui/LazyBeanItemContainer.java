package org.avm.framework.ui;

import org.apache.log4j.Logger;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;

public class LazyBeanItemContainer<T> extends BeanItemContainer<T> {

    private static final long serialVersionUID = 3392330142734628613L;

	private static final Logger LOGGER = Logger.getLogger(LazyBeanItemContainer.class);

    public LazyBeanItemContainer(Class<T> type) {
        super(type);
        LOGGER.debug("new");
    }

    @Override
    public LazyBeanItem<T> addItemAt(int index, Object newItemId) throws UnsupportedOperationException {
        BeanItem<T> item = super.addItemAt(index, newItemId);
        return new LazyBeanItem<T>(item);
    }

    @Override
    public LazyBeanItem<T> addItemAfter(Object previousItemId, Object newItemId) throws UnsupportedOperationException {
        BeanItem<T> item = super.addItemAfter(previousItemId, newItemId);
        return new LazyBeanItem<T>(item);
    }

    @Override
    public LazyBeanItem<T> addItem(Object itemId) throws UnsupportedOperationException {
        BeanItem<T> item = super.addItem(itemId);
        return new LazyBeanItem<T>(item);
    }

    @Override
    public LazyBeanItem<T> addBean(T bean) {
        BeanItem<T> item = super.addBean(bean);
        return new LazyBeanItem<T>(item);
    }

    @Override
    public LazyBeanItem<T> getItem(Object itemId) {
        BeanItem<T> item = super.getItem(itemId);
        return new LazyBeanItem<T>(item);
    }
}
