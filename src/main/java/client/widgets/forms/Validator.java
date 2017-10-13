package client.widgets.forms;

/**
 * Validate and show error for inputs.
 */
public interface Validator {
    
    /**
     * Validate the input.
     *
     * @return is a correct.
     */
    boolean validate();
    
    /**
     * Show error on input.
     */
    void showError();
}
