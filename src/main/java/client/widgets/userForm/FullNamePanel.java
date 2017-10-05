package client.widgets.userForm;

import client.Utility;
import client.abstraction.userForm.IsValid;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

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
        boxFirstName.setStyleName("user-form-text-boxes-fio");
        boxMiddleName.setStyleName("user-form-text-boxes-fio");
        boxLastName.setStyleName("user-form-text-boxes-fio");
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
        boolean validate = true;
        if (getBoxFirstName().getText().isEmpty()) {
            showError(getBoxFirstName());
            validate = false;
        }
        if (getBoxMiddleName().getText().isEmpty()) {
            showError(getBoxMiddleName());
            validate = false;
        }
        if (getBoxLastName().getText().isEmpty()) {
            showError(getBoxLastName());
            validate = false;
        }
        return validate;
    }
    
    @Override
    public void showError(Widget widget) {
        widget.setStyleName("user-form-text-boxes-fio-error");
    }
}
