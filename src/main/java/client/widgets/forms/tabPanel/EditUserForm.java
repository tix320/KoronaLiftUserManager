package client.widgets.forms.tabPanel;

import client.widgets.forms.UserForm;
import client.widgets.tables.UpdateType;

public class EditUserForm extends UserForm {
    
    private static final String SUBMIT_BUTTON_TEXT = "Изменить";
    
    public EditUserForm() {
        buttonSubmit.setText(SUBMIT_BUTTON_TEXT);
    }
    
    @Override
    public void submitAction() {
        dataUpdater.updateObservers(getUserFromInputs(currentID), UpdateType.EDIT);
    }
}
