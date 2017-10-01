package client.abstraction;

import client.Utility;
import client.modules.User;
import client.widgets.CityList;
import client.widgets.DateOfBirthdayPicker;
import client.widgets.UsersTable;
import com.google.gwt.user.client.ui.*;
import lombok.Setter;

public abstract class AbstractUserForm extends Composite {

    private final String GROUP_SEX = "sex";

    @Setter protected UsersTable usersTable;

    private FlowPanel panelSubmit;
    private HorizontalPanel panelSex;

    protected TextBox textFirstName;
    protected TextBox textMiddleName;
    protected TextBox textLastName;
    protected RadioButton radioMale;
    protected RadioButton radioFemale;
    protected ListBox listCity;
    protected DateOfBirthdayPicker dateOfBirthdayPicker;
    protected Button buttonSubmit;
    protected boolean arrayAreFilled[];

    protected User currentUser;

    /** Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     * */
    public AbstractUserForm() {

        initWidgets();
        setPlaceHolders();
        setItemsToCityList();
        setStyles();
        setClickHandler();

        panelSex.add(radioMale);
        panelSex.add(radioFemale);

        panelSubmit.add(textFirstName);
        panelSubmit.add(textMiddleName);
        panelSubmit.add(textLastName);
        panelSubmit.add(panelSex);
        panelSubmit.add(listCity);
        panelSubmit.add(dateOfBirthdayPicker);
        panelSubmit.add(buttonSubmit);

        initWidget(panelSubmit);
    }
    /** initialize the widgets of user form.
     * */
    private void initWidgets() {
        panelSubmit = new FlowPanel();
        panelSex = new HorizontalPanel();

        dateOfBirthdayPicker = new DateOfBirthdayPicker();
        radioFemale = new RadioButton(GROUP_SEX, "женский");
        radioMale = new RadioButton(GROUP_SEX, "мужский");
        textFirstName = new TextBox();
        textMiddleName = new TextBox();
        textLastName = new TextBox();
        listCity = new ListBox();
        arrayAreFilled = new boolean[5];
        buttonSubmit = new Button();
    }
    /** set placeholders to text boxes
     * */
    private void setPlaceHolders() {
        Utility.setPlaceHolder(textFirstName, "Имя");
        Utility.setPlaceHolder(textMiddleName, "Отчество");
        Utility.setPlaceHolder(textLastName, "Фамилия");
    }
    /** Get the selected user's attributes from table and insert their to user form for future editing.
     * @param user is selected User in table.
     * */
    public void insertSelectedItem(User user) {
        currentUser = user;
        textFirstName.setText(user.getFirstName());
        textMiddleName.setText(user.getMiddleName());
        textLastName.setText(user.getLastName());
        if (user.isMale()) radioMale.setValue(true, true);
        else radioFemale.setValue(true, true);
        listCity.setSelectedIndex(user.getCityIndex());
        dateOfBirthdayPicker.setDate(user.getDateOfBirthday());

    }
    /** Get the list of cities and put their to list box.
     * */
    private void setItemsToCityList() {
        for (String city : CityList.getListCity()) {
            listCity.addItem(city);
        }
        //set value "city" to separate from others
        listCity.setValue(0, "city");
    }

    /** Set input's class names for styling .
     * */
    private void setStyles() {
        textFirstName.setStyleName("user-form-text-boxes-fio");
        textMiddleName.setStyleName("user-form-text-boxes-fio");
        textLastName.setStyleName("user-form-text-boxes-fio");
        radioMale.setStyleName("user-form-radio-group-sex");
        radioFemale.setStyleName("user-form-radio-group-sex");
        listCity.setStyleName("user-form-list-city");
        dateOfBirthdayPicker.setStyleName("user-form-date-of-birthday-picker");
    }

    /** Check the fillability and correctness of inputs.
     * */
    protected boolean areFilled() {
        //collect the correctness of the inputs in the array, true==correctly
        if (!textFirstName.getText().equals("")) arrayAreFilled[0] = true;
        if (!textMiddleName.getText().equals("")) arrayAreFilled[1] = true;
        if (!textLastName.getText().equals("")) arrayAreFilled[2] = true;
        if (radioMale.getValue() || radioFemale.getValue()) arrayAreFilled[3] = true;
        if (!(listCity.getSelectedIndex() == 0)) arrayAreFilled[4] = true;

        // if all the fields are filled correctly, return true.
        for (int i = 0; i < 5; i++) {
            if (!arrayAreFilled[i])
                return false;
        }
        return true;
    }

    /** If inputs are not filled, then show a hint on the fields where there is an error.
     * */
    protected void showErrors() {
        if (!arrayAreFilled[0]) {
            Utility.setPlaceHolder(textFirstName, "Введите Имя");
            textFirstName.setStyleName("user-form-text-boxes-fio-error");
        }
        if (!arrayAreFilled[1]) {
            Utility.setPlaceHolder(textMiddleName, "Введите Отчество");
            textMiddleName.setStyleName("user-form-text-boxes-fio-error");
        }
        if (!arrayAreFilled[2]) {
            Utility.setPlaceHolder(textLastName, "Введите Фамилия");
            textLastName.setStyleName("user-form-text-boxes-fio-error");
        }
        if (!arrayAreFilled[4]) {
            listCity.getElement().getStyle().setBorderColor("red");
        }

    }
    /** Set default state of inputs.
     * */
    protected void setFieldsDefault() {
        Utility.setPlaceHolder(textFirstName, "Имя");
        Utility.setPlaceHolder(textMiddleName, "Отчество");
        Utility.setPlaceHolder(textLastName, "Фамилия");
        textFirstName.setStyleName("user-form-text-boxes-fio");
        textMiddleName.setStyleName("user-form-text-boxes-fio");
        textLastName.setStyleName("user-form-text-boxes-fio");
        listCity.getElement().getStyle().setBorderColor("lightseagreen");
    }

    /** UserAddForm and EditAddForm will override this method for manipulation with users table.
     * */
    protected abstract void setClickHandler();
}
