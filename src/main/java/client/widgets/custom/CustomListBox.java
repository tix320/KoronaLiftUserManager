package client.widgets.custom;

import com.google.gwt.user.client.ui.ListBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Custom list box for working with objects.
 * Base list box working only with strings.
 *
 * @param <T> is type of object.
 * @author Tigran Sargsyan and Tiran Manukyan :).
 */
public class CustomListBox<T> extends ListBox {

    /** Function for getting object's string submission. */
    private final Function<T, String> function;

    /** List of objects. */
    private List<T> objectsList;

    /** List of strings. */
    private List<String> stringList;

    /**
     * Constructor for initializing function.
     *
     * @param function to init list box function.
     */
    public CustomListBox(Function<T, String> function) {
        this.function = function;
    }

    /**
     * Init objects list.
     *
     * @param list of objects.
     */
    public void setList(final List<T> list) {
        clear();
        objectsList = list;
        addItems();
    }

    /**
     * Add items to list box and strings list.
     */
    private void addItems() {
        stringList = new ArrayList<>(objectsList.size());
        objectsList.forEach(object -> addItemToList(function.apply(object)));
    }

    /**
     * Add item to lists.
     *
     * @param item for adding.
     */
    private void addItemToList(final String item) {
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
    public void selectObject(final T object) {
        setSelectedIndex(stringList.indexOf(function.apply(object)));
    }
}
