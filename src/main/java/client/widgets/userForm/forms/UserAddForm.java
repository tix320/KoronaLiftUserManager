package client.widgets.userForm.forms;

import client.abstraction.userForm.BaseUserForm;
import client.modules.User;
import client.widgets.main.MainPanel;

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
    protected void submitAction() {
        
        // Set a click handler on button.
        buttonSubmit.addClickHandler(event -> {
            
            // Check inputs.
            if (isCorrect()) {
               addNewUser();
            }
        });
    }
    
    private void addNewUser() {
         currentUser = new User(currentID++, fullNamePanel.getFirstName(), fullNamePanel.getMiddleName(), fullNamePanel.getLastName(),
                        cityPanel.getSelectedCity(), sexPanel.getSelectedGender(), datePickerPanel.getDate());
         MainPanel.getUserContainer().getUsersTable().add(currentUser);
    }
}
