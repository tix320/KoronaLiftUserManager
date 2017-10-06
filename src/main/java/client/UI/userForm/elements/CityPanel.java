package client.UI.userForm.elements;

import client.abstraction.userForm.IsValid;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Panel for selection city.
 */
public class CityPanel extends Composite implements IsValid {
    
    /** List box of cities. */
    @Getter
    private ListBox listBoxCity;
    
    private List<String> listCity;
    
    
    /**
     * Create an object.
     * Initialize list box.
     * Set list box style.
     */
    public CityPanel() {
        listBoxCity = new ListBox();
        listCity = new ArrayList<>();
        addItemsToListBox();
        listBoxCity.setStyleName("user-form-list-city");
        
        initWidget(listBoxCity);
    }
    
    /**
     * Add items to list box.
     */
    private void addItemsToListBox() {
        listCity.add("Город");
        listCity.add("Абингдон");
        listCity.add("Амстердам");
        listCity.add("Антверпен");
        listCity.add("Архангельск");
        listCity.add("Астрахань");
        listCity.add("Атланта");
        listCity.add("Афины");
        listCity.add("Баден");
        listCity.add("Базель");
        listCity.add("Бангалор");
        listCity.add("Барселона");
        listCity.add("Бендеры");
        listCity.add("Берн");
        listCity.add("Бонн");
        listCity.add("Бостон");
        listCity.add("Брайзах-на-Рейне");
        listCity.add("Будённовск");
        listCity.add("Буффало");
        listCity.add("Буэнос-Айрес");
        listCity.add("Варшава");
        listCity.add("Вашингтон");
        listCity.add("Веймар");
        listCity.add("Вельс");
        listCity.add("Венеция");
        listCity.add("Винница");
        listCity.add("Владивосток");
        listCity.add("Вологда");
        listCity.add("Волгоград");
        listCity.add("Вормс");
        listCity.add("Воронеж");
        listCity.add("Гамбург");
        listCity.add("Ганновер");
        listCity.add("Гданьск");
        listCity.add("Делфт");
        listCity.add("Детройт");
        listCity.add("Донецк");
        listCity.add("Дорчестер");
        listCity.add("Дрезден");
        listCity.add("Дублин");
        listCity.add("Дувр");
        listCity.add("Дуйсбург");
        listCity.add("Иваново");
        
        for (String city : listCity) {
            listBoxCity.addItem(city);
        }
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
        listBoxCity.setSelectedIndex(listCity.indexOf(selectedCity));
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
