package client;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

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
    
    /**
     * Set border color of widget.
     *
     * @param widget which color changes.
     * @param borderColor, which is set.
     */
    public static void setBorderColor(Widget widget, String borderColor) {
        widget.getElement().getStyle().setBorderColor(borderColor);
    }
}
