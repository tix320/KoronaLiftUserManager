package client.widgets.custom;

import com.google.gwt.user.client.ui.ListBox;

import java.util.List;

/**
 * Custom list box for working with objects.
 * Base list box working only with strings.
 *
 * @param <T> is type of object.
 * @author Tigran Sargsyan and Tiran Manukyan :).
 */
public class CustomListBox<T> extends ListBox {

    /** List of objects. */
    private List<T> objectsList;

    /**
     * Init objects list.
     *
     * @param list of objects.
     */
    public void setList(final List<T> list) {
        objectsList = list;
        addItems();
    }

    /**
     * Add items to list box.
     */
    private void addItems() {
        objectsList.forEach(object -> addItem(object.toString()));
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
    public void selectObject(final T object) {
        setSelectedIndex(objectsList.indexOf(object));
    }
}
