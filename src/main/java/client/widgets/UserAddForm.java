package client.widgets;

import client.abstraction.userForm.BaseUserForm;
import client.abstraction.userForm.Input;
import client.modules.User;
import com.google.gwt.dom.client.Style;

import java.util.Map;

/**
 * Create custom widget to add a user.
 * Users will be added to the table (UsersTable).
 */
public class UserAddForm extends BaseUserForm {

    private static int currentID = 0;
    private final String ADD_BUTTON_TEXT = "Добавить";

    /**
     * Call the constructor of BaseUserForm to create a user add form.
     */
    public UserAddForm() {
        super();
        buttonSubmit.setText(ADD_BUTTON_TEXT);
    }

    /**
     * Override method of submit button to add user in table.
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

            // Check input fields , if are filled, then add User in table.
            if (areFilled()) {
                usersTable.add(getNewUser());
                usersTable.getDeleteButtonUser().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
            } else showErrors();
        });
    }

    private User getNewUser() {
        currentID++;
        return new User(
                currentID,
                fullNamePanel.getFirstName(),
                fullNamePanel.getMiddleName(),
                fullNamePanel.getLastName(),
                cityPanel.getIndexOfSelectedCity(),
                sexPanel.isMale(),
                datePickerPanel.getDate());
    }
}
