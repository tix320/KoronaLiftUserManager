package client.widgets.user;

import client.data.repositories.DataRepository;
import client.widgets.user.elements.CityPanel;
import client.widgets.user.elements.DatePickerPanel;
import client.widgets.user.elements.FullNamePanel;
import client.widgets.user.elements.GenderPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import shared.dto.UserDto;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Base form to create user add and edit forms.
 */
public abstract class BaseUserForm extends Composite implements Form<UserDto> {

    /** Full name inputs. */
    private FullNamePanel fullNamePanel;

    /** Gender selection panel. */
    private GenderPanel genderPanel;

    /** City selection panel. */
    private CityPanel cityPanel;

    /** Date selection panel. */
    private DatePickerPanel datePickerPanel;

    /** Submit button. */
    protected Button buttonSubmit;

    /** Current user. */
    protected UserDto currentUser;

    /**
     * Constructor is a main part for creating a user form.
     * All methods of its elements are called here.
     *
     * @param genderPanelGroup of gender panel.
     */
    protected BaseUserForm(final String genderPanelGroup) {
        DataRepository.getUsersRepository().registerSource(this);
        final FlowPanel panelSubmit = new FlowPanel();
        fullNamePanel = new FullNamePanel();
        genderPanel = new GenderPanel(genderPanelGroup);
        cityPanel = new CityPanel();
        datePickerPanel = new DatePickerPanel();
        initButtonSubmit();
        Stream.of(fullNamePanel, genderPanel, cityPanel, datePickerPanel, buttonSubmit)
                .forEach(panelSubmit::add);

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
     * Set user data from inputs.
     *
     * @param user is a using user.
     */
    protected void setUserDataFromInputs(final UserDto user) {
        user.setFirstName(fullNamePanel.getFirstName());
        user.setPatronymic(fullNamePanel.getPatronymic());
        user.setLastName(fullNamePanel.getLastName());
        user.setGender(genderPanel.getGender());
        user.setCity(cityPanel.getSelectedCity());
        user.setDateOfBirth(datePickerPanel.getDate());
    }

    /**
     * Check the correctness of inputs.
     *
     * @return correctness value.
     */
    private boolean isCorrect() {
        setInputDefaults();
        return validateWidgets(fullNamePanel, genderPanel, cityPanel);
    }

    /**
     * Validate the input widgets.
     *
     * @param widgetsForValidate is a widgets ,which will validate.
     * @return validate result.
     */
    private boolean validateWidgets(final HasValidation... widgetsForValidate) {
        return Arrays.stream(widgetsForValidate)
                .filter(validateWidget -> !validateWidget.validate())
                .peek(HasValidation::showError)
                .count() == 0;
    }

    /**
     * Set default styles of inputs.
     */
    private void setInputDefaults() {
        fullNamePanel.setDefaultStyles();
        genderPanel.setDefaultStyles();
        cityPanel.setDefaultStyles();
    }

    /**
     * Update form data from some source.
     */
    private void updateInputs() {
        fullNamePanel.setFirstName(currentUser.getFirstName());
        fullNamePanel.setPatronymic(currentUser.getPatronymic());
        fullNamePanel.setLastName(currentUser.getLastName());
        genderPanel.setSelectedButton(currentUser.getGender());
        cityPanel.setSelectedCity(currentUser.getCity());
        datePickerPanel.setDate(currentUser.getDateOfBirth());
    }

    @Override
    public final void response(final UserDto user) {
        currentUser = user;
        updateInputs();
    }
}
