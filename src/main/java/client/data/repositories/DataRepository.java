package client.data.repositories;

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
