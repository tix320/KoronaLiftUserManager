package client.widgets;

import java.util.ArrayList;

public class CityList {
   private static ArrayList<String> listCity;

/**
 * Create list of cities
 * @return ArrayList<String> of cities
* */
   public static ArrayList<String> getListCity(){
        listCity = new ArrayList<>();
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

        return listCity;
    }

    /**
     * Get the name of the city by index
     * @param index is a index of city
     * @return name of city
     */
    public static String getItem(int index){
      return listCity.get(index);
    }
}
