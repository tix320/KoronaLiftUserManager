package client.widgets.forms.tabPanel;

import client.objects.UsersRepository;
import client.widgets.forms.UserForm;

public class AddUserForm extends UserForm {
    
    /** Text of edit button. */
    private static final String SUBMIT_BUTTON_TEXT = "Добавить";
    
    /**
     * Constructor to set own button text.
     */
    public AddUserForm() {
        buttonSubmit.setText(SUBMIT_BUTTON_TEXT);
    }
    
    @Override
    public void submitAction() {
        UsersRepository.getRepository().addUser(getUserFromInputs());
    }
}
