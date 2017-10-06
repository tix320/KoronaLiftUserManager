package client.UI.userForm.forms;

import client.UI.main.MainPanel;
import client.abstraction.userForm.BaseUserForm;

/**
 * Create custom widget to edit a user.
 * Users will be added to the table (UsersTable).
 */
public class UserEditForm extends BaseUserForm {
    
    /** Text for edit button. */
    private static final String EDIT_BUTTON_TEXT = "Изменить";
    
    /**
     * Call the constructor of BaseUserForm to create a user edit form.
     */
    public UserEditForm() {
        super();
        buttonSubmit.setText(EDIT_BUTTON_TEXT);
        buttonSubmit.setEnabled(false);
    }
    
    @Override
    protected void submitAction() {
        
        // Set a click handler on button.
        buttonSubmit.addClickHandler(event -> {
            
            // Check inputs.
            if (isCorrect()) {
                refreshUser();
            }
        });
    }
    
    /**
     * Refresh user data in table.
     */
    private void refreshUser() {
        currentUser.setFirstName(fullNamePanel.getFirstName());
        currentUser.setMiddleName(fullNamePanel.getMiddleName());
        currentUser.setLastName(fullNamePanel.getLastName());
        currentUser.setGender(sexPanel.getSelectedGender());
        currentUser.setCity(cityPanel.getSelectedCity());
        currentUser.setDateOfBirth(datePickerPanel.getDate());
        
        MainPanel.getUserContainer().getUsersTable().edit(currentUser);
    }
}
