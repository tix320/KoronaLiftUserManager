package client.widgets.forms.elements;

import client.models.Gender;
import client.widgets.forms.HasValidation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;

public class SexPanel extends Composite implements HasValidation {
    
    /** Group name of radio buttons. */
    private static final String GROUP_SEX = "sex";
    
    /** Style name for radio buttons. */
    private static final String RADIO_BUTTON_STYLE = "user-form-radio-group-sex";
    
    /** Panel, where will radio buttons. */
    private HorizontalPanel panelSex;
    
    /** Radio button of male. */
    private RadioButton radioMale;
    
    /** Radio button of female. */
    private RadioButton radioFemale;
    
    /**
     * Create the gender selection panel.
     */
    public SexPanel() {
        panelSex = new HorizontalPanel();
        radioMale = createRadioButton(Gender.MALE.getName());
        radioFemale = createRadioButton(Gender.FEMALE.getName());
        setDefaultStyles();
    
        panelSex.add(radioMale);
        panelSex.add(radioFemale);
        initWidget(panelSex);
    }
    
    /**
     * Create radio button for select gender male.
     */
    private RadioButton createRadioButton(String name) {
        RadioButton radioButton = new RadioButton(GROUP_SEX, name);
        radioButton.setStyleName(RADIO_BUTTON_STYLE);
        return radioButton;
    }
    
    /**
     * Set widgets style.
     */
    public void setDefaultStyles() {
        panelSex.setStyleName("user-form-sex-panel");
    }
    
    /**
     * Get button,which is selected.
     *
     * @return selected button.
     */
    private RadioButton getSelectedButton() {
        if (radioMale.getValue()) {
            return radioMale;
        }
        if (radioFemale.getValue()) {
            return radioFemale;
        }
        return null;
    }
    
    /**
     * Select button.
     *
     * @param gender checks, what button is selected.
     */
    public void setSelectedButton(Gender gender) {
        if (gender == Gender.MALE) {
            radioMale.setValue(true);
        } else {
            radioFemale.setValue(true);
        }
    }
    
    /**
     * Get selected userGender.
     *
     * @return userGender.
     */
    public Gender getGender() {
        if (getSelectedButton() == radioMale) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }
    
    @Override
    public boolean validate() {
        return getSelectedButton() != null;
    }
    
    @Override
    public void showError() {
        panelSex.setStyleName("user-form-sex-panel-error");
    }
}