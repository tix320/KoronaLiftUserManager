package client.widgets.user.forms;

import client.data.repositories.DataRepository;
import client.widgets.user.BaseUserForm;

/**
 * Form to edit users in repository.
 */
public class EditUserForm extends BaseUserForm {

    /** Text of edit button. */
    private static final String SUBMIT_BUTTON_TEXT = "Изменить";

    /**
     * Constructor to set own button text.
     */
    public EditUserForm() {
        super("gender_group_edit");
        DataRepository.getUsersRepository().registerSource(this);
        getButtonSubmit().setText(SUBMIT_BUTTON_TEXT);
    }

    @Override
    public final void submitAction() {
        DataRepository.getUsersRepository().editUser(sendCurrentUser());
    }
}
