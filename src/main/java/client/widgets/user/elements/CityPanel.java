package client.widgets.user.elements;

import client.data.repositories.DataRepository;
import client.widgets.user.HasValidation;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import shared.dto.CityDto;

/**
 * Panel for selection city.
 */
public class CityPanel extends Composite implements HasValidation, ChangeHandler {

    /** List box of cities. */
    private CityListBox listBoxCity;

    /**
     * Initialize cities and list box.
     */
    public CityPanel() {
        listBoxCity = new CityListBox();
        setDefaultStyles();
        initWidget(listBoxCity);
        DataRepository.getCitiesRepository().registerListener(this);
    }

    /**
     * Set default styles on widgets.
     */
    public void setDefaultStyles() {
        listBoxCity.setStyleName("user-form-list-city");
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
        listBoxCity.setStyleName("user-form-list-city-error");
    }

    @Override
    public void onChange(ChangeEvent event) {
        listBoxCity.setList(DataRepository.getCitiesRepository().getResultList());
    }
}
