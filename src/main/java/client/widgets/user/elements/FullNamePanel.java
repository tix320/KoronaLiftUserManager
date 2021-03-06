package client.widgets.user.elements;

import client.widgets.custom.CustomTextBox;
import client.widgets.user.HasValidation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.Arrays;
import java.util.List;

/**
 * Panel for input full name.
 */
public class FullNamePanel extends Composite implements HasValidation {

    /** Place holder text for first name box. */
    private static final String FIRST_NAME = "Имя";

    /** Place holder text for patronymic box. */
    private static final String PATRONYMIC = "Отчество";

    /** Place holder text for last name box. */
    private static final String LAST_NAME = "Фамилия";

    /** Panel for text boxes. */
    private VerticalPanel fullNamePanel;

    /** Text box for input first name. */
    private CustomTextBox boxFirstName;

    /** Text box for input patronymic. */
    private CustomTextBox boxPatronymic;

    /** Text box for input last name. */
    private CustomTextBox boxLastName;

    /** List of text boxes. */
    private List<CustomTextBox> textBoxes;

    /**
     * Create the full name input panel.
     */
    public FullNamePanel() {
        fullNamePanel = new VerticalPanel();
        initBoxFirstName();
        initBoxPatronymic();
        initBoxLastName();

        textBoxes = Arrays.asList(boxFirstName, boxPatronymic, boxLastName);
        textBoxes.forEach(fullNamePanel::add);
        setDefaultStyles();

        initWidget(fullNamePanel);
    }

    /**
     * Init text box for input first name.
     */
    private void initBoxFirstName() {
        boxFirstName = new CustomTextBox();
        boxFirstName.setPlaceHolder(FIRST_NAME);
    }

    /**
     * Init text box for input patronymic.
     */
    private void initBoxPatronymic() {
        boxPatronymic = new CustomTextBox();
        boxPatronymic.setPlaceHolder(PATRONYMIC);
    }

    /**
     * Init text box for input last name.
     */
    private void initBoxLastName() {
        boxLastName = new CustomTextBox();
        boxLastName.setPlaceHolder(LAST_NAME);
    }

    /**
     * Set styles to text boxes.
     */
    public void setDefaultStyles() {
        fullNamePanel.setStyleName("user-form-full-name-panel");
        textBoxes.forEach(textBox -> textBox.setStyleName("user-form-text-boxes-fio"));
    }

    /**
     * Get first name from text box.
     *
     * @return first name.
     */
    public String getFirstName() {
        return boxFirstName.getText();
    }

    /**
     * Set first name to text box.
     *
     * @param text is first name.
     */
    public void setFirstName(final String text) {
        boxFirstName.setText(text);
    }

    /**
     * Get patronymic from text box.
     *
     * @return patronymic.
     */
    public String getPatronymic() {
        return boxPatronymic.getText();
    }

    /**
     * Set patronymic to text box.
     *
     * @param text is patronymic.
     */
    public void setPatronymic(final String text) {
        boxPatronymic.setText(text);
    }

    /**
     * Get last name from text box.
     *
     * @return last name.
     */
    public String getLastName() {
        return boxLastName.getText();
    }

    /**
     * Set last name to text box.
     *
     * @param text is last name.
     */
    public void setLastName(final String text) {
        boxLastName.setText(text);
    }

    @Override
    public final boolean validate() {
        return textBoxes.stream().filter(validateBox ->
                validateBox.getText().isEmpty()).count() == 0;
    }

    @Override
    public final void showError() {
        textBoxes.stream()
                .filter(validateBox -> validateBox.getText().isEmpty())
                .forEach(validateBox -> validateBox.setStyleName("user-form-text-boxes-fio-error"));
    }
}
