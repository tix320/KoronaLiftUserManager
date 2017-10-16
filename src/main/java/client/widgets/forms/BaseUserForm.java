package client.widgets.forms;

import client.models.User;
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
public abstract class BaseUserForm extends Composite implements Form<User> {
    
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
    protected int currentUserID;
    
    /**
     * Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     */
    protected BaseUserForm() {
        FlowPanel panelSubmit = new FlowPanel();
        fullNamePanel = new FullNamePanel();
        sexPanel = new SexPanel();
        cityPanel = new CityPanel();
        datePickerPanel = new DatePickerPanel();
        initButtonSubmit();
        Stream.of(fullNamePanel, sexPanel, cityPanel, datePickerPanel, buttonSubmit).forEach(panelSubmit::add);
        initWidget(panelSubmit);
    }
    
    /**
     * Init submit button to send data.
     */
    private void initButtonSubmit() {
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
        newUser.setPatronymic(fullNamePanel.getPatronymic());
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
    private boolean validateWidgets(HasValidation... widgetsForValidate) {
        return Arrays.stream(widgetsForValidate).filter(validateWidget -> !validateWidget.validate()).peek(HasValidation::showError).count() == 0;
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
        fullNamePanel.setPatronymic(user.getPatronymic());
        fullNamePanel.setLastName(user.getLastName());
        sexPanel.setSelectedButton(user.getGender());
        cityPanel.setSelectedCity(user.getCity());
        datePickerPanel.setDate(user.getDateOfBirth());
    }
    
    @Override
    public void response(Integer ID, User user) {
        currentUserID = ID;
        updateInputs(user);
    }
}