package client.widgets.custom;

import com.google.gwt.user.client.ui.ListBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom list box for working with objects.
 * Base list box working only with strings.
 *
 * @param <T> is type of object.
 * @author Tigran Sargsyan and Tiran Manukyan :).
 */
public abstract class CustomListBox<T> extends ListBox {

    /** List of objects. */
    private List<T> objectsList;

    /** List of strings. */
    private List<String> stringList;

    /**
     * Init objects list.
     *
     * @param list of objects.
     */
    public void setList(List<T> list) {
        clear();
        objectsList = list;
        addItems();
    }

    /**
     * Add items to list box and strings list.
     */
    private void addItems() {
        stringList = new ArrayList<>(objectsList.size());
        objectsList.forEach(object -> addItemToList(getValue(object)));
    }

    /**
     * Add item to lists.
     *
     * @param item for adding.
     */
    private void addItemToList(String item) {
        stringList.add(item);
        addItem(item);
    }

    /**
     * Get selected object from list.
     *
     * @return selected object.
     */
    public T getSelectedObject() {
        return objectsList.get(getSelectedIndex());
    }

    /**
     * Select object in list box.
     *
     * @param object is selecting object.
     */
    public void selectObject(T object) {
        setSelectedIndex(stringList.indexOf(getValue(object)));
    }

    /**
     * Get string value from object of generic type.
     *
     * @param object of generic type.
     * @return string value.
     */
    public abstract String getValue(T object);
}
