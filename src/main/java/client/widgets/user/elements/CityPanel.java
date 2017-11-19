package client.widgets.user.elements;

import client.data.DataObserver;
import client.data.repositories.DataRepository;
import client.widgets.custom.CustomListBox;
import client.widgets.user.HasValidation;
import com.google.gwt.user.client.ui.Composite;
import java.util.List;
import shared.models.CityDto;

/**
 * Panel for selection city.
 */
public class CityPanel extends Composite implements HasValidation, DataObserver<CityDto> {

    /** List box of cities. */
    private CustomListBox<CityDto> listBoxCity;

    /**
     * Initialize cities and list box.
     */
    public CityPanel() {
        DataRepository.getCitiesRepository().registerObserver(this);
        listBoxCity = new CustomListBox<>();
        setDefaultStyles();
        initWidget(listBoxCity);
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
    public final void update(final List<CityDto> data) {
        listBoxCity.setList(data);
    }
}
