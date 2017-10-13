package client.widgets.forms;

import client.objects.User;
import client.widgets.forms.elements.CityPanel;
import client.widgets.forms.elements.DatePickerPanel;
import client.widgets.forms.elements.FullNamePanel;
import client.widgets.forms.elements.SexPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Base form to create user add and edit forms.
 */
public abstract class UserForm extends Composite implements Form<User> {
    
    /** Full name inputs. */
    private FullNamePanel fullNamePanel;
    
    /** Gender selection panel. */
    private SexPanel sexPanel;
    
    /** City selection panel. */
    private CityPanel cityPanel;
    
    /** Date selection panel. */
    private DatePickerPanel datePickerPanel;
    
    /** Submit button - add new user or edit. */
    protected Button buttonSubmit;
    
    /** Current user's index. */
    protected int currentUserIndex;
    
    /**
     * Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     */
    protected UserForm() {
        FlowPanel panelSubmit = new FlowPanel();
        createFullNamePanel();
        createSexPanel();
        createCityPanel();
        createDatePickerPanel();
        createButtonSubmit();
        Stream.of(fullNamePanel, sexPanel, cityPanel, datePickerPanel, buttonSubmit).forEach(panelSubmit::add);
        initWidget(panelSubmit);
    }
    
    /**
     * Create panel for input full name.
     */
    private void createFullNamePanel() {
        fullNamePanel = new FullNamePanel();
    }
    
    /**
     * Create panel for select gender.
     */
    private void createSexPanel() {
        sexPanel = new SexPanel();
    }
    
    /**
     * Create panel for select city.
     */
    private void createCityPanel() {
        cityPanel = new CityPanel();
    }
    
    /**
     * Create panel for select dat of birth.
     */
    private void createDatePickerPanel() {
        datePickerPanel = new DatePickerPanel();
    }
    
    /**
     * Create submit button to send data.
     */
    private void createButtonSubmit() {
        buttonSubmit = new Button();
        buttonSubmit.addClickHandler(event -> {
            if (isCorrect()) {
                submitAction();
            }
        });
    }
    
    /**
     * Create new user taking data from inputs.
     *
     * @return created user.
     */
    protected User getUserFromInputs() {
        User newUser = new User();
        newUser.setFirstName(fullNamePanel.getFirstName());
        newUser.setMiddleName(fullNamePanel.getMiddleName());
        newUser.setLastName(fullNamePanel.getLastName());
        newUser.setGender(sexPanel.getGender());
        newUser.setCity(cityPanel.getSelectedCity());
        newUser.setDateOfBirth(datePickerPanel.getDate());
        return newUser;
    }
    
    /**
     * Check the correctness of inputs.
     *
     * @return correctness value.
     */
    private boolean isCorrect() {
        setInputDefaults();
        return validateWidgets(fullNamePanel, sexPanel, cityPanel);
    }
    
    /**
     * Validate the input widgets.
     *
     * @param widgetsForValidate is a widgets ,which will validate.
     * @return validate result.
     */
    private boolean validateWidgets(Validator... widgetsForValidate) {
        return Arrays.stream(widgetsForValidate).filter(validateWidget -> !validateWidget.validate()).peek(Validator::showError).count() == 0;
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
    private void updateInputs(User user) {
        fullNamePanel.setFirstName(user.getFirstName());
        fullNamePanel.setMiddleName(user.getMiddleName());
        fullNamePanel.setLastName(user.getLastName());
        sexPanel.setSelectedButton(user.getGender());
        cityPanel.setSelectedCity(user.getCity());
        datePickerPanel.setDate(user.getDateOfBirth());
    }
    
    @Override
    public void response(int index, User user) {
        currentUserIndex = index;
        updateInputs(user);
    }
}