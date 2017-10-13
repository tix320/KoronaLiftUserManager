package client.widgets.forms.tabPanel;

import client.objects.UsersRepository;
import client.widgets.forms.UserForm;

public class EditUserForm extends UserForm {
    
    /** Text of edit button. */
    private static final String SUBMIT_BUTTON_TEXT = "Изменить";
    
    /**
     * Constructor to set own button text.
     */
    public EditUserForm() {
        buttonSubmit.setText(SUBMIT_BUTTON_TEXT);
    }
    
    @Override
    public void submitAction() {
        UsersRepository.getRepository().editUser(currentUserIndex, getUserFromInputs());
    }
}
