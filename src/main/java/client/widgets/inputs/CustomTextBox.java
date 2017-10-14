package client.widgets.inputs;

import com.google.gwt.user.client.ui.TextBox;

public class CustomTextBox extends TextBox {
    
    private static final String PLACE_HOLDER = "placeholder";
    
    public void setPlaceHolder(String placeHolder) {
        this.getElement().setAttribute(PLACE_HOLDER, placeHolder);
    }
}
