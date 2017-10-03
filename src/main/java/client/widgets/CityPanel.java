package client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Panel for selection cityNumber.
 * */
public class CityPanel extends Composite {
     private ListBox listCity;

     public CityPanel() {
          listCity = new ListBox();
          listCity.setStyleName("user-form-list-city");
          addItemsToListBox();

          initWidget(listCity);
     }

     /**
      * Add items to list box.
      */
     private void addItemsToListBox() {
          listCity.addItem("Город");
          listCity.addItem("Абингдон");
          listCity.addItem("Амстердам");
          listCity.addItem("Антверпен");
          listCity.addItem("Архангельск");
          listCity.addItem("Астрахань");
          listCity.addItem("Атланта");
          listCity.addItem("Афины");
          listCity.addItem("Баден");
          listCity.addItem("Базель");
          listCity.addItem("Бангалор");
          listCity.addItem("Барселона");
          listCity.addItem("Бендеры");
          listCity.addItem("Берн");
          listCity.addItem("Бонн");
          listCity.addItem("Бостон");
          listCity.addItem("Брайзах-на-Рейне");
          listCity.addItem("Будённовск");
          listCity.addItem("Буффало");
          listCity.addItem("Буэнос-Айрес");
          listCity.addItem("Варшава");
          listCity.addItem("Вашингтон");
          listCity.addItem("Веймар");
          listCity.addItem("Вельс");
          listCity.addItem("Венеция");
          listCity.addItem("Винница");
          listCity.addItem("Владивосток");
          listCity.addItem("Вологда");
          listCity.addItem("Волгоград");
          listCity.addItem("Вормс");
          listCity.addItem("Воронеж");
          listCity.addItem("Гамбург");
          listCity.addItem("Ганновер");
          listCity.addItem("Гданьск");
          listCity.addItem("Делфт");
          listCity.addItem("Детройт");
          listCity.addItem("Донецк");
          listCity.addItem("Дорчестер");
          listCity.addItem("Дрезден");
          listCity.addItem("Дублин");
          listCity.addItem("Дувр");
          listCity.addItem("Дуйсбург");
          listCity.addItem("Иваново");
     }

     /**
      * Get index of selected city.
      * @return index.
      */
     public int getIndexOfSelectedCity(){
          return listCity.getSelectedIndex();

     }

     /**
      * Select city on list box by index.
      * @param cityNumber is index of city.
      */
     public void setSelectedCity(int cityNumber){
          listCity.setSelectedIndex(cityNumber);
     }

     /**
      * Get city name by index.
      * @param cityNumber is a index of city.
      * @return city name.
      */
     public String getCityName(int cityNumber){
          return listCity.getItemText(cityNumber);
     }

     /**
      * Get list box of city.
      */
     public ListBox getListBox(){
          return listCity;
     }


}
