package client.widgets.user.forms;

import client.data.repositories.DataRepository;
import client.widgets.user.BaseUserForm;
import shared.dto.UserDto;

/**
 * Form for add users to repository.
 */
public class AddUserForm extends BaseUserForm {

    /** Text of edit button. */
    private static final String SUBMIT_BUTTON_TEXT = "Добавить";

    /**
     * Constructor to set own button text.
     */
    public AddUserForm() {
        super("gender_group_add");
        buttonSubmit.setText(SUBMIT_BUTTON_TEXT);
    }

    @Override
    public final void submitAction() {
        currentUser = new UserDto();
        setUserDataFromInputs(currentUser);
        sendData(currentUser);
    }

    @Override
    public void sendData(final UserDto user) {
        DataRepository.getUsersRepository().addUser(user);
    }
}
