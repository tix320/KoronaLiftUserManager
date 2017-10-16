package client.data.repositories;

import client.data.Repository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for cities.
 */
public class CitiesRepository extends Repository<String> {
    
    /** Repository reference. */
    private static CitiesRepository citiesRepository;
    
    /** List of cities. */
    @Getter
    private List<String> cities;
    
    /**
     * Init repository.
     */
    private CitiesRepository() {
        addCities();
    }
    
    /**
     * Create the repository.
     */
    public static CitiesRepository getInstance() {
        if (citiesRepository == null) {
            citiesRepository = new CitiesRepository();
        }
        return citiesRepository;
    }
    
    /**
     * Add cities to list.
     */
    private void addCities() {
        cities = new ArrayList<>();
        cities.add("Город");
        cities.add("Абингдон");
        cities.add("Амстердам");
        cities.add("Антверпен");
        cities.add("Архангельск");
        cities.add("Астрахань");
        cities.add("Атланта");
        cities.add("Афины");
        cities.add("Баден");
        cities.add("Базель");
        cities.add("Бангалор");
        cities.add("Барселона");
        cities.add("Бендеры");
        cities.add("Берн");
        cities.add("Бонн");
        cities.add("Бостон");
        cities.add("Брайзах-на-Рейне");
        cities.add("Будённовск");
        cities.add("Буффало");
        cities.add("Буэнос-Айрес");
        cities.add("Варшава");
        cities.add("Вашингтон");
        cities.add("Веймар");
        cities.add("Вельс");
        cities.add("Венеция");
        cities.add("Винница");
        cities.add("Владивосток");
        cities.add("Вологда");
        cities.add("Волгоград");
        cities.add("Вормс");
        cities.add("Воронеж");
        cities.add("Гамбург");
        cities.add("Ганновер");
        cities.add("Гданьск");
        cities.add("Делфт");
        cities.add("Детройт");
        cities.add("Донецк");
        cities.add("Дорчестер");
        cities.add("Дрезден");
        cities.add("Дублин");
        cities.add("Дувр");
        cities.add("Дуйсбург");
        cities.add("Иваново");
    }
}