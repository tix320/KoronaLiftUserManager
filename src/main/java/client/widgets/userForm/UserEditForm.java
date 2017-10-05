package client.widgets.userForm;

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
    protected void setClickHandler() {
        
        // Set a click handler on button.
        buttonSubmit.addClickHandler(event -> {
            
            // Set input fields to default state.
            setFieldsDefault();
            
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
        insertUser();
        usersTable.edit(currentUser);
    }
    
    /**
     * Edit object info of user.
     */
    private void insertUser() {
        currentUser.setFirstName(fullNamePanel.getFirstName());
        currentUser.setMiddleName(fullNamePanel.getMiddleName());
        currentUser.setLastName(fullNamePanel.getLastName());
        currentUser.setMale(sexPanel.isMale());
        currentUser.setCity(cityPanel.getSelectedCity());
        currentUser.setDateOfBirth(datePickerPanel.getDate());
    }
    
    
}
