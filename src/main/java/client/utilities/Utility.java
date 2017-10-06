package client.utilities;

import com.google.gwt.user.client.ui.TextBox;

/**
 * Class utility to shorten the code of some methods.
 */
public class Utility {
    
    /** HTML constant attribute. */
    private static final String PLACE_HOLDER = "placeholder";
    
    /**
     * Set placeholder to the text boxes.
     *
     * @param textBox which is put place holder.
     * @param value of place holder.
     */
    public static void setPlaceHolder(TextBox textBox, String value) {
        textBox.getElement().setAttribute(PLACE_HOLDER, value);
    }
}
