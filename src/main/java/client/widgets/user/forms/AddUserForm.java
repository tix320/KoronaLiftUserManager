package client.widgets.user.forms;

import client.data.repositories.DataRepository;
import client.widgets.user.BaseUserForm;

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
        super("gender_group_add");
        DataRepository.getUsersRepository().registerSource(this);
        getButtonSubmit().setText(SUBMIT_BUTTON_TEXT);
    }

    @Override
    public final void submitAction() {
        DataRepository.getUsersRepository().addUser(sendNewUser());
    }
}
