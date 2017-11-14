package client.widgets.user;

/**
 * Validate and show error for inputs.
 */
public interface HasValidation {

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
