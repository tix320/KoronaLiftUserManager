package client.widgets.forms;

import client.data.DataRepository;

public class EditUserForm extends BaseUserForm {
    
    /** Text of edit button. */
    private static final String SUBMIT_BUTTON_TEXT = "Изменить";
    
    /**
     * Constructor to set own button text.
     */
    public EditUserForm() {
        DataRepository.getUsersRepository().registerSource(this);
        buttonSubmit.setText(SUBMIT_BUTTON_TEXT);
    }
    
    @Override
    public void submitAction() {
        DataRepository.getUsersRepository().editUser(currentUserID, getUserFromInputs());
    }
}