package client.widgets;

import client.abstraction.AbstractUserForm;

/** Create custom widget to edit a user.
 * Users will be added to the table (UsersTable)
 * */
public class UserEditForm extends AbstractUserForm {

    /**
     *call the constructor of AbstractUserForm to create a user edit form.
     */
    public UserEditForm() {
        super();
        buttonSubmit.setText("Изменить");
    }

    /**
     *Override method of submit button to edit user in table.
     */
    @Override
    protected void setClickHandler() {
        //set a click handler on button
        buttonSubmit.addClickHandler(event -> {
            for (int i = 0; i < 5; i++) {
                arrayAreFilled[i] = false;
            }
            //set input fields to default state
            setFieldsDefault();
            // check input fields , if are filled, then edit user in table
            if (areFilled()) {
                int index = usersTable.getUserListDataProvider().getList().indexOf(usersTable.getSelModel().getLastSelectedObject());

                    currentUser.setFirstName(textFirstName.getText());
                    currentUser.setMiddleName(textMiddleName.getText());
                    currentUser.setLastName(textLastName.getText());
                    currentUser.setMale(radioMale.getValue());
                    currentUser.setCityIndex(listCity.getSelectedIndex());
                    currentUser.setDateOfBirthday(dateOfBirthdayPicker.getDate());

                    usersTable.getUserListDataProvider().getList().set(index,currentUser);
                    usersTable.getUserListDataProvider().refresh();
            }
            else showErrors();
        });
    }
}
