package client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;

public class SexPanel extends Composite{

    private static final String GROUP_SEX = "sex";

    private HorizontalPanel panelSex;
    private RadioButton radioMale;
    private RadioButton radioFemale;

    public SexPanel(){
        initWidgets();
        setStyles();

        initWidget(panelSex);
    }

    private void initWidgets(){
        panelSex = new HorizontalPanel();
        radioFemale = new RadioButton(GROUP_SEX, "женский");
        radioMale = new RadioButton(GROUP_SEX, "мужский");

        panelSex.add(radioMale);
        panelSex.add(radioFemale);
    }

    private void setStyles(){
        radioMale.setStyleName("user-form-radio-group-sex");
        radioFemale.setStyleName("user-form-radio-group-sex");
    }

    /**
     * Get button,which is selected.
     * @return selected button.
     */
    public RadioButton getSelectedButton(){
        if(radioMale.getValue()) return radioMale;
        if(radioFemale.getValue()) return radioFemale;
        return null;
    }

    /**
     * Select button.
     * @param isMale checks, what button is selected.
     */
    public void setSelectedButton(boolean isMale){
      if(isMale) radioMale.setValue(true);
      else radioFemale.setValue(true);
    }

    public boolean isMale(){
        if(radioMale.getValue()) return true;
        else return false;
    }
}
