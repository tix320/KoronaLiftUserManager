package client.widgets;

import client.abstraction.userForm.BaseUserForm;
import client.abstraction.userForm.Input;

import java.util.Map;

/**
 * Create custom widget to edit a user.
 * Users will be added to the table (UsersTable).
 */
public class UserEditForm extends BaseUserForm {

    private final String EDIT_BUTTON_TEXT = "Изменить";

    /**
     * Call the constructor of BaseUserForm to create a user edit form.
     */
    public UserEditForm() {
        super();
        buttonSubmit.setText(EDIT_BUTTON_TEXT);
        buttonSubmit.setEnabled(false);
    }

    /**
     * Override method of submit button to edit user in table.
     */
    @Override
    protected void setClickHandler() {

        // Set a click handler on button.
        buttonSubmit.addClickHandler(event -> {

            // Set input fields to default state.
            setFieldsDefault();

            for (Map.Entry<Input, Boolean> entry : mapAreFilled.entrySet()) {
                entry.setValue(false);
            }

            // Check input fields , if are filled, then edit user in table.
            if (areFilled()) refreshUser();
            else showErrors();
        });
    }

    private void insertUser() {
        currentUser.setFirstName(fullNamePanel.getFirstName());
        currentUser.setMiddleName(fullNamePanel.getMiddleName());
        currentUser.setLastName(fullNamePanel.getLastName());
        currentUser.setMale(sexPanel.isMale());
        currentUser.setCityNumber(cityPanel.getIndexOfSelectedCity());
        currentUser.setDateOfBirthday(datePickerPanel.getDate());
    }

    private void refreshUser() {
        insertUser();
        int index = usersTable.getUserListDataProvider().getList().indexOf(usersTable.getSelModel().getSelectedObject());
        usersTable.getUserListDataProvider().getList().set(index, currentUser);
        usersTable.getUserListDataProvider().refresh();
    }
}
