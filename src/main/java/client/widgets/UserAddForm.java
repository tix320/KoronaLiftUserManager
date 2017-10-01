package client.widgets;
import client.abstraction.AbstractUserForm;
import client.modules.User;
import com.google.gwt.dom.client.Style;

/** Create custom widget to add a user.
 * Users will be added to the table (UsersTable)
 * */
public class UserAddForm extends AbstractUserForm {

    /**
     *call the constructor of AbstractUserForm to create a user add form.
     */
    public UserAddForm() {
        super();
        buttonSubmit.setText("Добавить");
    }

    /**
     *Override method of submit button to add user in table.
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

            // check input fields , if are filled, then add User in table
            if (areFilled()) {
                usersTable.add(new User(
                        textFirstName.getText(),
                        textMiddleName.getText(),
                        textLastName.getText(),
                        listCity.getSelectedIndex(),
                        radioMale.getValue(),
                        dateOfBirthdayPicker.getDate()));
                usersTable.getButtonDeleteUser().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
            }
            else showErrors();
        });
    }
}
