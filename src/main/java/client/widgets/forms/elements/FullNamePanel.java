package client.widgets.forms.elements;

import client.widgets.forms.Validator;
import client.widgets.inputs.CustomTextBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.Arrays;
import java.util.List;

/**
 * Panel for input full name.
 */
public class FullNamePanel extends Composite implements Validator {
    
    /** Panel for text boxes. */
    private VerticalPanel fullNamePanel;
    
    /** Text box for input first name. */
    private CustomTextBox boxFirstName;
    
    /** Text box for input middle name. */
    private CustomTextBox boxMiddleName;
    
    /** Text box for input last name. */
    private CustomTextBox boxLastName;
    
    /** List of text boxes. */
    private List<CustomTextBox> textBoxes;
    
    /** Place holder text for first name box. */
    private static final String FIRST_NAME = "Имя";
    
    /** Place holder text for middle name box. */
    private static final String MIDDLE_NAME = "Отчество";
    
    /** Place holder text for last name box. */
    private static final String LAST_NAME = "Фамилия";
    
    /**
     * Create the full name input panel.
     */
    public FullNamePanel() {
        fullNamePanel = new VerticalPanel();
        boxFirstName = createBoxFirstName();
        boxMiddleName = createBoxMiddleName();
        boxLastName = createBoxLastName();
    
        textBoxes = Arrays.asList(boxFirstName, boxMiddleName, boxLastName);
        textBoxes.forEach(fullNamePanel::add);
        setDefaultStyles();
    
        initWidget(fullNamePanel);
    }
    
    /**
     * Create text box for input first name.
     */
    private CustomTextBox createBoxFirstName() {
        CustomTextBox boxFirstName = new CustomTextBox();
        boxFirstName.setPlaceHolder(FIRST_NAME);
        return boxFirstName;
    }
    
    /**
     * Create text box for input middle name.
     */
    private CustomTextBox createBoxMiddleName() {
        CustomTextBox boxMiddleName = new CustomTextBox();
        boxMiddleName.setPlaceHolder(MIDDLE_NAME);
        return boxMiddleName;
    }
    
    /**
     * Create text box for input last name.
     */
    private CustomTextBox createBoxLastName() {
        CustomTextBox boxLastName = new CustomTextBox();
        boxLastName.setPlaceHolder(LAST_NAME);
        return boxLastName;
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
     * @return firs name.
     */
    public String getFirstName() {
        return boxFirstName.getText();
    }
    
    /**
     * Set first name to text box.
     */
    public void setFirstName(String text) {
        boxFirstName.setText(text);
    }
    
    /**
     * Get middle name from text box.
     *
     * @return middle name.
     */
    public String getMiddleName() {
        return boxMiddleName.getText();
    }
    
    /**
     * Set middle name to text box.
     */
    public void setMiddleName(String text) {
        boxMiddleName.setText(text);
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
     */
    public void setLastName(String text) {
        boxLastName.setText(text);
    }
    
    @Override
    public boolean validate() {
        return textBoxes.stream().filter(validateBox -> validateBox.getText().isEmpty()).count() == 0;
    }
    
    @Override
    public void showError() {
        textBoxes.stream()
                .filter(validateBox -> validateBox.getText().isEmpty())
                .forEach(validateBox -> validateBox.setStyleName("user-form-text-boxes-fio-error"));
    }
}
