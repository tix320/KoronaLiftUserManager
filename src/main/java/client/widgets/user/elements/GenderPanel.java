package client.widgets.user.elements;

import client.widgets.user.HasValidation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import shared.models.Gender;

/**
 * Panel for selecting gender.
 */
public class GenderPanel extends Composite implements HasValidation {

    /** Style name for radio buttons. */
    private static final String RADIO_BUTTON_STYLE = "user-form-radio-radioGroup-sex";

    /** Group name of radio buttons. */
    private String radioGroup;

    /** Panel, where will radio buttons. */
    private HorizontalPanel panelGender;

    /** Radio button of male. */
    private RadioButton radioMale;

    /** Radio button of female. */
    private RadioButton radioFemale;

    /**
     * Create the gender selection panel.
     *
     * @param group is group of radio buttons.
     */
    public GenderPanel(final String group) {
        this.radioGroup = group;
        panelGender = new HorizontalPanel();
        radioMale = createRadioButton(Gender.MALE.getName());
        radioFemale = createRadioButton(Gender.FEMALE.getName());
        setDefaultStyles();

        panelGender.add(radioMale);
        panelGender.add(radioFemale);
        initWidget(panelGender);
    }

    /**
     * Create radio button for select gender male.
     *
     * @param name is a button name.
     * @return created radio button.
     */
    private RadioButton createRadioButton(final String name) {
        RadioButton radioButton = new RadioButton(radioGroup, name);
        radioButton.setStyleName(RADIO_BUTTON_STYLE);
        return radioButton;
    }

    /**
     * Set widgets style.
     */
    public void setDefaultStyles() {
        panelGender.setStyleName("user-form-sex-panel");
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
    public void setSelectedButton(final Gender gender) {
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
    public final boolean validate() {
        return getSelectedButton() != null;
    }

    @Override
    public final void showError() {
        panelGender.setStyleName("user-form-sex-panel-error");
    }
}
