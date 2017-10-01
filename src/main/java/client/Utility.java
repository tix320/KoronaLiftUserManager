package client;

import com.google.gwt.user.client.ui.Widget;

/** Class utility to shorten the code of some methods
 * */
public class Utility {

    private static final String PLACE_HOLDER = "placeholder";

    /** set placeholder to the text boxes
     * */
    public static void setPlaceHolder(Widget widget,String value){
        widget.getElement().setAttribute(PLACE_HOLDER,value);
    }
}
