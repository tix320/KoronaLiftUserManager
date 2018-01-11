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
    private final Function<T, String> displayExecutor;

    /** List of objects. */
    private List<T> objectList;

    /** List of strings to display objects. */
    private List<String> displayObjectList;

    /**
     * Constructor for initializing display executor.
     *
     * @param displayExecutor to init displayExecutor.
     */
    public CustomListBox(Function<T, String> displayExecutor) {
        this.displayExecutor = displayExecutor;
    }

    /**
     * Init objects list.
     *
     * @param list of objects.
     */
    public void setList(final List<T> list) {
        clear();
        objectList = list;
        addItems();
    }

    /**
     * Add items to list box and strings list.
     */
    private void addItems() {
        displayObjectList = new ArrayList<>(objectList.size());
        objectList.forEach(object -> addItemToList(displayExecutor.apply(object)));
    }

    /**
     * Add item to lists.
     *
     * @param item for adding.
     */
    private void addItemToList(final String item) {
        displayObjectList.add(item);
        addItem(item);
    }

    /**
     * Get selected object from list.
     *
     * @return selected object.
     */
    public T getSelectedObject() {
        return objectList.get(getSelectedIndex());
    }

    /**
     * Select object in list box.
     *
     * @param object is selecting object.
     */
    public void selectObject(final T object) {
        setSelectedIndex(displayObjectList.indexOf(displayExecutor.apply(object)));
    }
}
