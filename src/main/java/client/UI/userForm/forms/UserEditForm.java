package client.UI.userForm.forms;

import client.UI.userTable.UsersTableUpdater;
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
    }
    
    @Override
    public void submitAction() {
    
        // Check inputs.
        if (isCorrect()) {
            currentUser.setFirstName(fullNamePanel.getFirstName());
            currentUser.setMiddleName(fullNamePanel.getMiddleName());
            currentUser.setLastName(fullNamePanel.getLastName());
            currentUser.setGender(sexPanel.getSelectedGender());
            currentUser.setCity(cityPanel.getSelectedCity());
            currentUser.setDateOfBirth(datePickerPanel.getDate());
            usersTableUpdaters.forEach(UsersTableUpdater::editUser);
        }
    }
}
