package client.widgets.userForm.elements;

import client.abstraction.userForm.IsValid;
import client.modules.Gender;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;

public class SexPanel extends Composite implements IsValid {
    
    private static final String GROUP_SEX = "sex";
    
    private HorizontalPanel panelSex;
    private RadioButton radioMale;
    private RadioButton radioFemale;
    
    public SexPanel() {
        initWidgets();
        setStyles();
        
        initWidget(panelSex);
    }
    
    private void initWidgets() {
        panelSex = new HorizontalPanel();
        radioFemale = new RadioButton(GROUP_SEX, "женский");
        radioMale = new RadioButton(GROUP_SEX, "мужский");
        
        panelSex.add(radioMale);
        panelSex.add(radioFemale);
    }
    
    private void setStyles() {
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
