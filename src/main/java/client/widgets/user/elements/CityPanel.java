package client.widgets.user.elements;

import client.data.DataChangeEvent;
import client.data.DataChangeHandler;
import client.data.repositories.DataRepository;
import client.widgets.custom.CustomTextBox;
import client.widgets.user.HasValidation;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import shared.dto.CityDto;

/**
 * Panel for selection city.
 */
public class CityPanel extends Composite implements HasValidation, DataChangeHandler<CityDto> {

    /** Empty string text. */
    private static final String EMPTY_TEXT = "";

    /** List box of cities. */
    private CityListBox listBoxCity;

    /** Text box for the new city's name. */
    private CustomTextBox newCityTextBox;

    /** Button to add new city. */
    private Button addButton;

    /**
     * Initialize cities and list box.
     */
    public CityPanel() {
        VerticalPanel mainPanel = new VerticalPanel();
        mainPanel.setStyleName("user-form-city-panel");

        listBoxCity = new CityListBox();
        initTextBox();
        initAddButton();

        HorizontalPanel addCityPanel = new HorizontalPanel();
        addCityPanel.add(newCityTextBox);
        addCityPanel.add(addButton);

        mainPanel.add(listBoxCity);
        mainPanel.add(addCityPanel);

        setDefaultStyles();
        initWidget(mainPanel);

        DataRepository.getCitiesRepository().addChangeHandler(this);
    }

    /**
     * Set default styles on widgets.
     */
    public void setDefaultStyles() {
        listBoxCity.setStyleName("user-form-city-panel-box");
    }

    /**
     * Initialize text box for input name of city.
     */
    private void initTextBox() {
        newCityTextBox = new CustomTextBox();
        newCityTextBox.setPlaceHolder("Другой город");
        newCityTextBox.setStyleName("user-form-city-panel-box");
    }

    /**
     * Initialize button for adding new city.
     */
    private void initAddButton() {
        addButton = new Button("+");
        addButton.setStyleName("user-form-city-panel-add-button");
        addButton.addClickHandler(event -> {
            if (validateTextBox()) {
                addCity();
            }
        });
    }

    /**
     * Validate the city input.
     *
     * @return true, if is correct.
     */
    private boolean validateTextBox() {
        if (newCityTextBox.getText().isEmpty()) {
            newCityTextBox.setStyleName("user-form-city-panel-box-error");
            return false;
        }
        newCityTextBox.setStyleName("user-form-city-panel-box");
        return true;
    }

    /**
     * Send request to add new city.
     */
    private void addCity() {
        if (Window.confirm("Добавить новый город: " + newCityTextBox.getText() + " ?")) {
            CityDto cityDto = new CityDto();
            cityDto.setName(newCityTextBox.getText());
            DataRepository.getCitiesRepository().addCity(cityDto);
            newCityTextBox.setText(EMPTY_TEXT);
        }
    }

    /**
     * Get selected city.
     *
     * @return name of city.
     */
    public CityDto getSelectedCity() {
        return listBoxCity.getSelectedObject();
    }

    /**
     * Set selected city in list box.
     *
     * @param city is a selecting item.
     */
    public void setSelectedCity(final CityDto city) {
        listBoxCity.selectObject(city);
    }

    @Override
    public final boolean validate() {
        return listBoxCity.getSelectedIndex() != 0;
    }

    @Override
    public final void showError() {
        listBoxCity.setStyleName("user-form-city-panel-box-error");
    }

    @Override
    public void update(final DataChangeEvent<CityDto> event) {
        listBoxCity.setList(event.getDataList());
    }
}
