package client.widgets.forms.elements;

import client.widgets.forms.IsValid;
import client.utilities.Utility;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.Arrays;
import java.util.List;

/**
 * Panel for input full name.
 */
public class FullNamePanel extends Composite implements IsValid {
    
    /** Panel for text boxes. */
    private VerticalPanel fullNamePanel;
    
    /** Text box for input first name. */
    private TextBox boxFirstName;
    
    /** Text box for input middle name. */
    private TextBox boxMiddleName;
    
    /** Text box for input last name. */
    private TextBox boxLastName;
    
    /** List of text boxes. */
    private List<TextBox> textBoxes;
    
    /**
     * Create the full name panel.
     */
    public FullNamePanel() {
        initWidgets();
        setDefaultStyles();
        setPlaceHolders();
        
        initWidget(fullNamePanel);
    }
    
    /**
     * Initialize widgets and panel.
     */
    private void initWidgets() {
        fullNamePanel = new VerticalPanel();
        boxFirstName = new TextBox();
        boxMiddleName = new TextBox();
        boxLastName = new TextBox();
        textBoxes = Arrays.asList(boxFirstName, boxMiddleName, boxLastName);
    
        textBoxes.forEach(fullNamePanel::add);
    }
    
    /**
     * Set styles to text boxes.
     */
    public void setDefaultStyles() {
        fullNamePanel.setStyleName("user-form-full-name-panel");
        textBoxes.forEach(validateBox -> validateBox.setStyleName("user-form-text-boxes-fio"));
    }
    
    /**
     * Set placeholders to text boxes.
     */
    private void setPlaceHolders() {
        Utility.setPlaceHolder(boxFirstName, "Имя");
        Utility.setPlaceHolder(boxMiddleName, "Отчество");
        Utility.setPlaceHolder(boxLastName, "Фамилия");
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
