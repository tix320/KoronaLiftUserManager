package client.UI.userForm;

import client.UI.userForm.elements.CityPanel;
import client.UI.userForm.elements.DatePickerPanel;
import client.UI.userForm.elements.FullNamePanel;
import client.UI.userForm.elements.SexPanel;
import client.UI.userTable.UserTable;
import client.UI.userTable.UserTableDataUpdater;
import client.abstraction.SendType;
import client.abstraction.dataUpdater.DataUpdater;
import client.abstraction.form.Form;
import client.abstraction.form.IsValid;
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
public class UserForm extends Composite implements Form<UserTableDataUpdater> {
    
    /** Id of the new user. */
    private static int nextID = 0;
    /** List of table updaters, which will transfer data. */
    private List<DataUpdater<User, UserForm, UserTable>> dataUpdaters;
    /** Full name inputs. */
    private FullNamePanel fullNamePanel;
    /** Gender selection panel. */
    private SexPanel sexPanel;
    /** City selection panel. */
    private CityPanel cityPanel;
    /** Date selection panel. */
    private DatePickerPanel datePickerPanel;
    /** Submit button - add new user or edit. */
    private Button buttonSubmit;
    /** User, which is being edited. */
    private User currentUser;
    /** Form main panel. */
    private FlowPanel panelSubmit;
    /** Type of submit. */
    @Getter
    private SendType sendType;
    
    /**
     * Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     */
    public UserForm(SendType sendType) {
        this.sendType = sendType;
    
        initialize();
        
        buttonSubmit.addClickHandler(event -> submitAction());
        
        Stream.of(fullNamePanel, sexPanel, cityPanel, datePickerPanel, buttonSubmit).forEach(panelSubmit::add);
        
        initWidget(panelSubmit);
    }
    
    /**
     * Initialize the widgets of user form.
     */
    private void initialize() {
        dataUpdaters = new ArrayList<>();
        panelSubmit = new FlowPanel();
        fullNamePanel = new FullNamePanel();
        sexPanel = new SexPanel();
        cityPanel = new CityPanel();
        datePickerPanel = new DatePickerPanel();
        buttonSubmit = new Button(sendType.getText());
    }
    
    @Override
    public void submitAction() {
        if (isCorrect()) {
            if (sendType == SendType.ADD) {
                sendNewUserData();
            }
            
            if (sendType == SendType.EDIT) {
                sendEditedUserData();
            }
        }
    }
    
    /**
     * Send new user data to data updater.
     */
    private void sendNewUserData() {
        dataUpdaters.forEach(dataUpdater -> dataUpdater.addNewObject(
                new User(++nextID, fullNamePanel.getFirstName(), fullNamePanel.getMiddleName(), fullNamePanel.getLastName(),
                         sexPanel.getSelectedGender(), cityPanel.getSelectedCity(), datePickerPanel.getDate())));
    }
    
    /**
     * Send new data of changeable user to data updater.
     */
    private void sendEditedUserData() {
        currentUser.setFirstName(fullNamePanel.getFirstName());
        currentUser.setMiddleName(fullNamePanel.getMiddleName());
        currentUser.setLastName(fullNamePanel.getLastName());
        currentUser.setGender(sexPanel.getSelectedGender());
        currentUser.setCity(cityPanel.getSelectedCity());
        currentUser.setDateOfBirth(datePickerPanel.getDate());
        dataUpdaters.forEach(dataUpdater -> dataUpdater.editThisObject(currentUser, new User(currentUser.getID(), fullNamePanel.getFirstName(),
                                                                                             fullNamePanel.getMiddleName(),
                                                                                             fullNamePanel.getLastName(),
                                                                                             sexPanel.getSelectedGender(),
                                                                                             cityPanel.getSelectedCity(),
                                                                                             datePickerPanel.getDate())));
    }
    
    /**
     * Check the correctness of inputs.
     *
     * @return correctness value.
     */
    private boolean isCorrect() {
        
        // Set input fields to default state.
        setInputDefaults();
        
        return validateWidgets(fullNamePanel, sexPanel, cityPanel);
    }
    
    /**
     * Validate the input widgets.
     *
     * @param widgetsForValidate is a widgets ,which will validate.
     * @return validate result.
     */
    private boolean validateWidgets(IsValid... widgetsForValidate) {
        return Arrays.stream(widgetsForValidate).filter(validateWidget -> !validateWidget.validate()).peek(IsValid::showError).count() == 0;
    }
    
    /**
     * Set default styles of inputs.
     */
    private void setInputDefaults() {
        fullNamePanel.setDefaultStyles();
        sexPanel.setDefaultStyles();
        cityPanel.setDefaultStyles();
    }
    
    /**
     * Update form data from some source.
     *
     * @param user is a owner of data.
     */
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
    public void registerDataUpdater(UserTableDataUpdater userTableDataUpdater) {
        userTableDataUpdater.addDataSource(this);
        dataUpdaters.add(userTableDataUpdater);
    }
    
    @Override
    public void removeDataUpdater(UserTableDataUpdater userTableDataUpdater) {
        dataUpdaters.remove(userTableDataUpdater);
    }
}