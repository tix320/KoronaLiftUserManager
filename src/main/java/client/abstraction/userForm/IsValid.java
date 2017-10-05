package client.abstraction.userForm;

import com.google.gwt.user.client.ui.Widget;

/**
 * Validate and show error for inputs.
 */
public interface IsValid {
    
    /**
     * Validate the input.
     *
     * @return is a correct.
     */
    boolean validate();
    
    /**
     * Show error on input.
     *
     * @param widget is a input widget.
     */
    void showError(Widget widget);
}
