package client.UI.userForm.elements;

import client.abstraction.form.IsValid;
import client.modules.Gender;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;

public class SexPanel extends Composite implements IsValid {
    
    /** Group name of radio buttons. */
    private static final String GROUP_SEX = "sex";
    
    /** Panel, where will radio buttons. */
    private HorizontalPanel panelSex;
    
    /** Radio button of male. */
    private RadioButton radioMale;
    
    /** Radio button of female. */
    private RadioButton radioFemale;
    
    public SexPanel() {
        initWidgets();
        setDefaultStyles();
        
        initWidget(panelSex);
    }
    
    /**
     * Initialize widgets.
     */
    private void initWidgets() {
        panelSex = new HorizontalPanel();
        radioFemale = new RadioButton(GROUP_SEX, "женский");
        radioMale = new RadioButton(GROUP_SEX, "мужский");
        
        panelSex.add(radioMale);
        panelSex.add(radioFemale);
    }
    
    /**
     * Set widgets style.
     */
    public void setDefaultStyles() {
        panelSex.setStyleName("user-form-sex-panel");
        radioMale.setStyleName("user-form-radio-group-sex");
        radioFemale.setStyleName("user-form-radio-group-sex");
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
     * Get selected gender.
     *
     * @return gender.
     */
    public Gender getSelectedGender() {
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
