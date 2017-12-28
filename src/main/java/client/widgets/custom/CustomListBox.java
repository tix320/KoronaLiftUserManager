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
public class CustomListBox<T> extends ListBox {

    /** Analyzer for getting object's string submission. */
    private final Analyzer<T, String> analyzer;

    /** List of objects. */
    private List<T> objectsList;

    /** List of strings. */
    private List<String> stringList;

    /**
     * Constructor for initializing analyzer.
     *
     * @param analyzer to init list box analyzer.
     */
    public CustomListBox(Analyzer<T, String> analyzer) {
        this.analyzer = analyzer;
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
        objectsList.forEach(object -> addItemToList(analyzer.getValue(object)));
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
        setSelectedIndex(stringList.indexOf(analyzer.getValue(object)));
    }
}
