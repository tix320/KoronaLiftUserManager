package client.widgets.forms.elements;

import client.data.DataRepository;
import client.widgets.forms.Validator;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Panel for selection city.
 */
public class CityPanel extends Composite implements Validator {
    
    /** List box of cities. */
    private ListBox listBoxCity;
    
    /**
     * Initialize cities and list box.
     */
    public CityPanel() {
        listBoxCity = new ListBox();
        addItemsToListBox();
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
     * Add items to list box.
     */
    private void addItemsToListBox() {
        DataRepository.getCitiesRepository().getCities().forEach(listBoxCity::addItem);
    }
    
    /**
     * Get selected city.
     *
     * @return name of city.
     */
    public String getSelectedCity() {
        return listBoxCity.getSelectedItemText();
    }
    
    /**
     * Select city on list box.
     *
     * @param selectedCity is name of city.
     */
    public void setSelectedCity(String selectedCity) {
        listBoxCity.setSelectedIndex(DataRepository.getCitiesRepository().getCities().indexOf(selectedCity));
    }
    
    @Override
    public boolean validate() {
        return listBoxCity.getSelectedIndex() != 0;
    }
    
    @Override
    public void showError() {
        listBoxCity.setStyleName("user-form-list-city-error");
    }
}
