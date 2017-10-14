package client.data;

import client.objects.UsersRepository;
import client.widgets.forms.elements.CitiesRepository;
import lombok.Getter;

public class DataRepository {
    
    /** Repository of users. */
    @Getter
    private static UsersRepository usersRepository = UsersRepository.createRepository();
    
    /** Repository of cities. */
    @Getter
    private static CitiesRepository citiesRepository = CitiesRepository.createRepository();
}
