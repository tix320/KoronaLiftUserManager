package client.widgets.forms;

import client.dataUpdaters.DataObserver;
import client.dataUpdaters.DataUpdater;
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
    
    /** Id of the new user. */
    protected static int currentID = 0;
    
    /** List of table updaters, which will transfer data. */
    protected DataUpdater<User, DataObserver> dataUpdater;
    
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
    
    /**
     * Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     */
    protected UserForm() {
        FlowPanel panelSubmit = new FlowPanel();
        initialize();
        Stream.of(fullNamePanel, sexPanel, cityPanel, datePickerPanel, buttonSubmit).forEach(panelSubmit::add);
        initWidget(panelSubmit);
    }
    
    /**
     * Initialize the widgets of user form.
     */
    private void initialize() {
        fullNamePanel = new FullNamePanel();
        sexPanel = new SexPanel();
        cityPanel = new CityPanel();
        datePickerPanel = new DatePickerPanel();
        buttonSubmit = new Button();
        setButtonSubmitHandler();
    }
    
    /**
     * Set click handler for submit button.
     */
    private void setButtonSubmitHandler() {
        buttonSubmit.addClickHandler(event -> {
            if (isCorrect()) {
                submitAction();
            }
        });
    }
    
    /**
     * Create new user taking data from inputs.
     *
     * @param ID of the new user.
     * @return created user.
     */
    protected User getUserFromInputs(int ID) {
        return new User(ID, fullNamePanel.getFirstName(), fullNamePanel.getMiddleName(), fullNamePanel.getLastName(), sexPanel.getSelectedGender(),
                        cityPanel.getSelectedCity(), datePickerPanel.getDate());
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
    private void updateInputs(User user) {
        fullNamePanel.setFirstName(user.getFirstName());
        fullNamePanel.setMiddleName(user.getMiddleName());
        fullNamePanel.setLastName(user.getLastName());
        sexPanel.setSelectedButton(user.getGender());
        cityPanel.setSelectedCity(user.getCity());
        datePickerPanel.setDate(user.getDateOfBirth());
    }
    
    @Override
    public void setDataUpdater(DataUpdater dataUpdater) {
        this.dataUpdater = dataUpdater;
    }
    
    @Override
    public void removeDataUpdater(DataUpdater dataUpdater) {
        this.dataUpdater = null;
    }
    
    @Override
    public void response(User data) {
        updateInputs(data);
    }
}