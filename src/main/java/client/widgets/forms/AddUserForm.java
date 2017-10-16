package client.widgets.forms;

import client.data.DataRepository;

/**
 * Form to add users in repository.
 */
public class AddUserForm extends BaseUserForm {
    
    /** Text of edit button. */
    private static final String SUBMIT_BUTTON_TEXT = "Добавить";
    
    /**
     * Constructor to set own button text.
     */
    public AddUserForm() {
        DataRepository.getUsersRepository().registerSource(this);
        buttonSubmit.setText(SUBMIT_BUTTON_TEXT);
    }
    
    @Override
    public void submitAction() {
        DataRepository.getUsersRepository().addUser(getUserFromInputs());
    }
}