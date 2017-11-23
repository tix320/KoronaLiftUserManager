package client.widgets.custom;

import client.widgets.user.HasUniqueness;
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
public class CustomListBox<T extends HasUniqueness> extends ListBox {

    /** List of objects. */
    private List<T> objectsList;

    /** List of unique numbers. */
    private List<Integer> uniqueItems;

    /**
     * Init objects list.
     *
     * @param list of objects.
     */
    public void setList(List<T> list) {
        objectsList = list;
        addItems();
        initUniqueList();
    }

    /**
     * Add items to list box.
     */
    private void addItems() {
        objectsList.stream().map(T::getValue).forEach(this::addItem);
    }

    /**
     * Init unique list.
     */
    private void initUniqueList() {
        uniqueItems = new ArrayList<>();
        objectsList.stream().map(T::uniqueNumber).forEach(uniqueItems::add);
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
        setSelectedIndex(uniqueItems.indexOf(object.uniqueNumber()));
    }
}
