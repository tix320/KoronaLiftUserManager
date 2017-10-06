package client.UI.userForm.elements;

import client.abstraction.userForm.IsValid;
import client.utilities.Utility;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.stream.Stream;

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
    
    /**
     * Add widgets to full name panel.
     * Set styles to widgets.
     * Set placeholder to text boxes.
     */
    public FullNamePanel() {
        initWidgets();
        setStyles();
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
        
        fullNamePanel.add(boxFirstName);
        fullNamePanel.add(boxMiddleName);
        fullNamePanel.add(boxLastName);
    }
    
    /**
     * Set styles to text boxes.
     */
    private void setStyles() {
        fullNamePanel.setStyleName("user-form-full-name-panel");
        Stream.of(boxFirstName, boxMiddleName, boxLastName)
                .forEach(validateBox -> validateBox.setStyleName("user-form-text-boxes-fio"));
    }
    
    /**
     * Set placeholders to text boxes.
     */
    private void setPlaceHolders() {
        Utility.setPlaceHolder(boxFirstName, "Имя");
        Utility.setPlaceHolder(boxMiddleName, "Отчество");
        Utility.setPlaceHolder(boxLastName, "Фамилия");
    }
    
    public String getFirstName() {
        return boxFirstName.getText();
    }
    
    public void setFirstName(String text) {
        boxFirstName.setText(text);
    }
    
    public String getMiddleName() {
        return boxMiddleName.getText();
    }
    
    public void setMiddleName(String text) {
        boxMiddleName.setText(text);
    }
    
    public String getLastName() {
        return boxLastName.getText();
    }
    
    public void setLastName(String text) {
        boxLastName.setText(text);
    }
    
    /**
     * Get the text box of first name.
     *
     * @return text box.
     */
    public TextBox getBoxFirstName() {
        return boxFirstName;
    }
    
    /**
     * Get the text box of middle name.
     *
     * @return text box.
     */
    public TextBox getBoxMiddleName() {
        return boxMiddleName;
    }
    
    /**
     * Get the text box of last name.
     *
     * @return text box.
     */
    public TextBox getBoxLastName() {
        return boxLastName;
    }
    
    @Override
    public boolean validate() {
        return Stream.of(boxFirstName, boxMiddleName, boxLastName)
                .filter(validateBox -> validateBox.getText().isEmpty())
                .count() == 0;
    }
    
    @Override
    public void showError() {
         Stream.of(boxFirstName, boxMiddleName, boxLastName)
                .filter(validateBox -> validateBox.getText().isEmpty())
                .forEach(validateBox -> validateBox.setStyleName("user-form-text-boxes-fio-error"));
       
    }
}
