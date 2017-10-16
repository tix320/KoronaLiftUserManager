package client.data;

import client.data.repositories.CitiesRepository;
import client.data.repositories.UsersRepository;
import lombok.Getter;

/**
 * Get all of repositories.
 */
public class DataRepository {
    
    /** Repository of users. */
    @Getter
    private static UsersRepository usersRepository = UsersRepository.getInstance();
    
    /** Repository of cities. */
    @Getter
    private static CitiesRepository citiesRepository = CitiesRepository.getInstance();
}