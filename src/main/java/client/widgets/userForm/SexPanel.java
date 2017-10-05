package client.widgets.userForm;

import client.abstraction.userForm.IsValid;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

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
     * @param isMale checks, what button is selected.
     */
    public void setSelectedButton(boolean isMale) {
        if (isMale) {
            radioMale.setValue(true);
        } else {
            radioFemale.setValue(true);
        }
    }
    
    /**
     * isCorrect gender.
     *
     * @return the gender.
     */
    public boolean isMale() {
        return radioMale.getValue();
    }
    
    @Override
    public boolean validate() {
        if (getSelectedButton() == null) {
            showError(panelSex);
            return false;
        }
        return true;
    }
    
    @Override
    public void showError(Widget widget) {
        widget.setStyleName("user-form-sex-panel-error");
    }
}
