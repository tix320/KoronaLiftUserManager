package client.abstraction.userForm;

import client.modules.User;
import client.widgets.userForm.CityPanel;
import client.widgets.userForm.DatePickerPanel;
import client.widgets.userForm.FullNamePanel;
import client.widgets.userForm.SexPanel;
import client.widgets.userTable.UsersTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import lombok.Getter;
import lombok.Setter;

/**
 * Base form to create user add and edit forms.
 */
public abstract class BaseUserForm extends Composite {
    
    /** Table with which forms will work. */
    @Setter
    protected UsersTable usersTable;
    
    /** Full name inputs. */
    protected FullNamePanel fullNamePanel;
    
    /** Sex selection panel. */
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
        initWidgets();
        setClickHandler();
        
        panelSubmit.add(fullNamePanel);
        panelSubmit.add(sexPanel);
        panelSubmit.add(cityPanel);
        panelSubmit.add(datePickerPanel);
        panelSubmit.add(buttonSubmit);
        
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
     * Get the selected user's attributes from table and insert their to user form for future editing.
     *
     * @param user is selected User in table.
     */
    public void insertSelectedItem(User user) {
        currentUser = user;
        fullNamePanel.setFirstName(user.getFirstName());
        fullNamePanel.setMiddleName(user.getMiddleName());
        fullNamePanel.setLastName(user.getLastName());
        sexPanel.setSelectedButton(user.isMale());
        cityPanel.setSelectedCity(user.getCity());
        datePickerPanel.setDate(user.getDateOfBirth());
        
    }
    
    /**
     * Check the correctness of inputs.
     *
     * @return correctness value.
     */
    protected boolean isCorrect() {
        boolean isCorrect = true;
        if (!fullNamePanel.validate()) {
            isCorrect = false;
        }
        if (!sexPanel.validate()) {
            isCorrect = false;
        }
        if (!cityPanel.validate()) {
            isCorrect = false;
        }
        return isCorrect;
    }
    
    /**
     * Set default state of inputs.
     */
    protected void setFieldsDefault() {
        fullNamePanel.getBoxFirstName().setStyleName("user-form-text-boxes-fio");
        fullNamePanel.getBoxMiddleName().setStyleName("user-form-text-boxes-fio");
        fullNamePanel.getBoxLastName().setStyleName("user-form-text-boxes-fio");
        sexPanel.setStyleName("user-form-sex-panel");
        cityPanel.getListBoxCity().setStyleName("user-form-list-city");
    }
    
    /**
     * UserAddForm and EditAddForm will override this method for manipulation with users table.
     */
    protected abstract void setClickHandler();
}
