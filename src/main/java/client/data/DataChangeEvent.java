package client.data;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Gwt event for data change.
 *
 * @param <D> is type of data.
 */
public class DataChangeEvent<D> extends GwtEvent<DataChangeHandler> {

    /** Type class used to register events with the {@link HandlerManager}. */
    private static final Type<DataChangeHandler> TYPE = new Type<>();

    /** Data list. */
    @Setter
    private List<D> dataList;

    /**
     * Get data list by using new list.
     *
     * @return data list.
     */
    public List<D> getDataList() {
        return new ArrayList<>(dataList);
    }

    @Override
    public Type<DataChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final DataChangeHandler handler) {
        handler.update(this);
    }
}
