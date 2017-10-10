package client.abstraction.form;

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
     */
    void showError();
}
