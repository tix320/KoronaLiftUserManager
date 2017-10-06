package client.containers;

import client.widgets.userForm.forms.UserAddForm;
import client.widgets.userForm.forms.UserEditForm;
import client.widgets.userTable.UsersTable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This container make relation between table and form.
 */
@AllArgsConstructor
@Getter
public class UserContainer {
    UsersTable usersTable;
    UserAddForm userAddForm;
    UserEditForm userEditForm;
}
