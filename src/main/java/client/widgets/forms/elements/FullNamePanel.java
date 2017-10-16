package client.widgets.forms.elements;

import client.widgets.customWidgets.CustomTextBox;
import client.widgets.forms.HasValidation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import lombok.Getter;

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
    @Getter
    private CustomTextBox boxFirstName;
    
    /** Text box for input patronymic. */
    @Getter
    private CustomTextBox boxPatronymic;
    
    /** Text box for input last name. */
    @Getter
    private CustomTextBox boxLastName;
    
    /** List of text boxes. */
    private List<CustomTextBox> textBoxes;
    
    /**
     * Create the full name input panel.
     */
    public FullNamePanel() {
        fullNamePanel = new VerticalPanel();
        boxFirstName = createBoxFirstName();
        boxPatronymic = createBoxPatronymic();
        boxLastName = createBoxLastName();
        
        textBoxes = Arrays.asList(boxFirstName, boxPatronymic, boxLastName);
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
     * Create text box for input patronymic.
     */
    private CustomTextBox createBoxPatronymic() {
        CustomTextBox boxMiddleName = new CustomTextBox();
        boxMiddleName.setPlaceHolder(PATRONYMIC);
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
     * @return first name.
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
     * Get patronymic from text box.
     *
     * @return patronymic.
     */
    public String getPatronymic() {
        return boxPatronymic.getText();
    }
    
    /**
     * Set patronymic to text box.
     */
    public void setPatronymic(String text) {
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