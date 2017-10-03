package client.abstraction;

import client.Utility;
import client.modules.User;
import client.widgets.*;
import com.google.gwt.user.client.ui.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

/**
 * Base form to create user add and edit forms.
 */
public abstract class BaseUserForm extends Composite {

    /**
     * The constants of HashMap's keys.
     */
    public enum Input {
        FIRST_NAME,
        MIDDLE_NAME,
        LAST_NAME,
        SEX,
        CITY
    }

    // Table with which forms will work.
    @Setter
    protected UsersTable usersTable;

    // Form main panel.
    private FlowPanel panelSubmit;

    // Full name inputs.
    protected FullNamePanel fullNamePanel;

    // Sex,City and Date selection panels.
    protected SexPanel sexPanel;
    @Getter protected CityPanel cityPanel;
    protected DatePickerPanel datePickerPanel;

    // Submit button - add new user or edit.
    @Getter protected Button buttonSubmit;

    // Map for checking inputs.
    protected HashMap<Input, Boolean> mapAreFilled;

    // User, which is being edited.
    protected User currentUser;

    /**
     * Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     */
    public BaseUserForm() {

        initWidgets();
        initAreFilled();
        setClickHandler();

        panelSubmit.add(fullNamePanel);
        panelSubmit.add(sexPanel);
        panelSubmit.add(cityPanel);
        panelSubmit.add(datePickerPanel);
        panelSubmit.add(buttonSubmit);

        initWidget(panelSubmit);
    }

    /**
     * initialize the widgets of user form.
     */
    private void initWidgets() {
        panelSubmit = new FlowPanel();
        fullNamePanel = new FullNamePanel();
        sexPanel = new SexPanel();
        cityPanel = new CityPanel();
        datePickerPanel = new DatePickerPanel();
        buttonSubmit = new Button();
        mapAreFilled = new HashMap<>();
    }

    /**
     * Initialize HashMap.
     */
    private void initAreFilled() {
        mapAreFilled.put(Input.FIRST_NAME, false);
        mapAreFilled.put(Input.MIDDLE_NAME, false);
        mapAreFilled.put(Input.LAST_NAME, false);
        mapAreFilled.put(Input.SEX, false);
        mapAreFilled.put(Input.CITY, false);
    }

    /**
     * Get the selected user's attributes from table and insert their to user form for future editing.
     * @param user is selected User in table.
     */
    public void insertSelectedItem(User user) {
        currentUser = user;
        fullNamePanel.setFirstName(user.getFirstName());
        fullNamePanel.setMiddleName(user.getMiddleName());
        fullNamePanel.setLastName(user.getLastName());
        sexPanel.setSelectedButton(user.isMale());
        cityPanel.setSelectedCity(user.getCityNumber());
        datePickerPanel.setDate(user.getDateOfBirthday());

    }

    /**
     * Check the fillability and correctness of inputs.
     */
    protected boolean areFilled() {

        // Collect the correctness of the inputs in the hashMap, true==correctly.
        if (!fullNamePanel.getFirstName().isEmpty()) mapAreFilled.put(Input.FIRST_NAME, true);
        if (!fullNamePanel.getMiddleName().isEmpty()) mapAreFilled.put(Input.MIDDLE_NAME, true);
        if (!fullNamePanel.getLastName().isEmpty()) mapAreFilled.put(Input.LAST_NAME, true);
        if (sexPanel.getSelectedButton() != null) mapAreFilled.put(Input.SEX, true);
        if ((cityPanel.getIndexOfSelectedCity() != 0)) mapAreFilled.put(Input.CITY, true);

        // If all the fields are filled correctly, return true.
        for(Map.Entry<Input,Boolean> entry : mapAreFilled.entrySet())
        {
            if (!entry.getValue()) return false;
        }
        return true;
    }

    /**
     * If inputs are not filled, then show a hint on the fields where there is an error.
     */
    protected void showErrors() {
        if (!mapAreFilled.get(Input.FIRST_NAME)) {
            Utility.setBorderColor(fullNamePanel.getBoxFirstName(), "red");
        }
        if (!mapAreFilled.get(Input.MIDDLE_NAME)) {
            Utility.setBorderColor(fullNamePanel.getBoxMiddleName(), "red");
        }
        if (!mapAreFilled.get(Input.LAST_NAME)) {
            Utility.setBorderColor(fullNamePanel.getBoxLastName(), "red");
        }
        if (!mapAreFilled.get(Input.CITY)) {
            Utility.setBorderColor(cityPanel.getListBox(), "red");
        }
    }

    /**
     * Set default state of inputs.
     */
    protected void setFieldsDefault() {
        fullNamePanel.getBoxFirstName().getElement().getStyle().clearBorderColor();
        fullNamePanel.getBoxMiddleName().getElement().getStyle().clearBorderColor();
        fullNamePanel.getBoxLastName().getElement().getStyle().clearBorderColor();
        cityPanel.getListBox().getElement().getStyle().clearBorderColor();
    }

    /**
     * UserAddForm and EditAddForm will override this method for manipulation with users table.
     */
    protected abstract void setClickHandler();

}
