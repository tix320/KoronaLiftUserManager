package client.abstraction.userForm;

import client.UI.userForm.elements.CityPanel;
import client.UI.userForm.elements.DatePickerPanel;
import client.UI.userForm.elements.FullNamePanel;
import client.UI.userForm.elements.SexPanel;
import client.UI.userTable.UsersTableUpdater;
import client.modules.User;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Base form to create user add and edit forms.
 */
public abstract class BaseUserForm extends Composite implements UserForm {
    
    protected List<UsersTableUpdater> usersTableUpdaters;
    
    /** Full name inputs. */
    protected FullNamePanel fullNamePanel;
    
    /** Gender selection panel. */
    protected SexPanel sexPanel;
    
    /** City selection panel. */
    @Getter
    protected CityPanel cityPanel;
    
    /** Date selection panel. */
    protected DatePickerPanel datePickerPanel;
    
    /** Submit button - add new user or edit. */
    @Getter
    protected Button buttonSubmit;
    
    /** User, which is being edited. */
    protected User currentUser;
    
    /** Form main panel. */
    private FlowPanel panelSubmit;
    
    /**
     * Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     */
    public BaseUserForm() {
        usersTableUpdaters = new ArrayList<>();
        
        initWidgets();
        submitAction();
    
        Stream.of(fullNamePanel, sexPanel, cityPanel, datePickerPanel, buttonSubmit).forEach(panelSubmit::add);
        
        initWidget(panelSubmit);
    }
    
    /**
     * Initialize the widgets of user form.
     */
    private void initWidgets() {
        panelSubmit = new FlowPanel();
        fullNamePanel = new FullNamePanel();
        sexPanel = new SexPanel();
        cityPanel = new CityPanel();
        datePickerPanel = new DatePickerPanel();
        buttonSubmit = new Button();
    }
    
    /**
     * Check the correctness of inputs.
     *
     * @return correctness value.
     */
    protected boolean isCorrect() {
        
        // Set input fields to default state.
        setFieldsDefault();
        
        return validateWidgets(fullNamePanel, sexPanel, cityPanel);
    }
    
    private boolean validateWidgets(IsValid... widgetsForValidate) {
        return Arrays.stream(widgetsForValidate).filter(validateWidget -> !validateWidget.validate()).peek(IsValid::showError).count() == 0;
    }
    
    /**
     * Set default state of inputs.
     */
    private void setFieldsDefault() {
        Stream.of(fullNamePanel.getBoxFirstName(), fullNamePanel.getBoxMiddleName(), fullNamePanel.getBoxLastName())
                .forEach(validateBox -> validateBox.setStyleName("user-form-text-boxes-fio"));
        sexPanel.setStyleName("user-form-sex-panel");
        cityPanel.getListBoxCity().setStyleName("user-form-list-city");
    }
    
    /**
     * Get the selected user's attributes from table and insert their to user form for future editing.
     *
     * @param user is selected User in table.
     */
    @Override
    public void updateInputs(User user) {
        currentUser = user;
        fullNamePanel.setFirstName(user.getFirstName());
        fullNamePanel.setMiddleName(user.getMiddleName());
        fullNamePanel.setLastName(user.getLastName());
        sexPanel.setSelectedButton(user.getGender());
        cityPanel.setSelectedCity(user.getCity());
        datePickerPanel.setDate(user.getDateOfBirth());
    }
    
    @Override
    public void registerUsersTableUpdater(UsersTableUpdater usersTableUpdater) {
        usersTableUpdaters.add(usersTableUpdater);
    }
    
    @Override
    public void removeUsersTableUpdater(UsersTableUpdater usersTableUpdater) {
        usersTableUpdaters.remove(usersTableUpdater);
    }
}
