package client.containers;

import client.UI.userForm.forms.UserAddForm;
import client.UI.userForm.forms.UserEditForm;
import client.UI.userTable.UsersTable;
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
