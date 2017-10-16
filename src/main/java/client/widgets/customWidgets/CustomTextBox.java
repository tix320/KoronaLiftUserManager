package client.widgets.customWidgets;

import client.widgets.forms.HasValidation;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Custom text box with useful methods.
 */
public class CustomTextBox extends TextBox implements HasValidation {
    
    /** HTML attribute. */
    private static final String PLACE_HOLDER = "placeholder";
    
    /**
     * Set place holder to text box.
     *
     * @param placeHolder is a text of place holder.
     */
    public void setPlaceHolder(String placeHolder) {
        this.getElement().setAttribute(PLACE_HOLDER, placeHolder);
    }
    
    @Override
    public boolean validate() {
        // TODO: Для будущее.
        return false;
    }
    
    @Override
    public void showError() {
        // TODO: Для будущее.
    }
}