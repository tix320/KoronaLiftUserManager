package client.widgets.custom;

import com.google.gwt.user.client.ui.TextBox;

/**
 * Custom text box with useful methods.
 */
public class CustomTextBox extends TextBox {

    /** HTML attribute. */
    private static final String PLACE_HOLDER = "placeholder";

    /**
     * Set place holder to text box.
     *
     * @param placeHolder is a text of place holder.
     */
    public void setPlaceHolder(final String placeHolder) {
        this.getElement().setAttribute(PLACE_HOLDER, placeHolder);
    }
}
