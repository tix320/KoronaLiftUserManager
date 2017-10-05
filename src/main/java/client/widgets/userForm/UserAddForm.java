package client.widgets.userForm;

import client.abstraction.userForm.BaseUserForm;
import client.modules.User;

/**
 * Create custom widget to add a user.
 * Users will be added to the table (UsersTable).
 */
public class UserAddForm extends BaseUserForm {
    
    /** Text for add button. */
    private static final String ADD_BUTTON_TEXT = "Добавить";
    /** ID for current user. */
    private static int currentID = 0;
    
    /**
     * Call the constructor of BaseUserForm to create a user add form.
     */
    public UserAddForm() {
        super();
        buttonSubmit.setText(ADD_BUTTON_TEXT);
    }
    
    @Override
    protected void setClickHandler() {
        
        // Set a click handler on button.
        buttonSubmit.addClickHandler(event -> {
            
            // Set input fields to default state.
            setFieldsDefault();
            
            // Check inputs.
            if (isCorrect()) {
                usersTable.add(getNewUser());
            }
        });
    }
    
    private User getNewUser() {
        return new User(currentID++, fullNamePanel.getFirstName(), fullNamePanel.getMiddleName(), fullNamePanel.getLastName(),
                        cityPanel.getSelectedCity(), sexPanel.isMale(), datePickerPanel.getDate());
    }
}
