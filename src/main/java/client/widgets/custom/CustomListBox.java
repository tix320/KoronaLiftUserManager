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
        objectsList = list;
        addItems();
    }

    /**
     * Add items to list box and strings list.
     */
    private void addItems() {
        stringList = new ArrayList<>(objectsList.size());
        for (T object : objectsList) {
            String tmp = getValue(object);
            stringList.add(tmp);
            addItem(tmp);
        }
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
