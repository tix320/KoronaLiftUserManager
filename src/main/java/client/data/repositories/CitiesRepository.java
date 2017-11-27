package client.data.repositories;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import shared.dto.CityDto;

import java.util.List;

/**
 * Repository for cities.
 */
public final class CitiesRepository extends Repository<CityDto> {

    /** Repository reference. */
    private static CitiesRepository citiesRepository;

    /**
     * Private constructor for singleton.
     */
    private CitiesRepository() {
        getCitiesFromDB();
    }

    /**
     * Create the repository.
     *
     * @return instance of cities repository.
     */
    static CitiesRepository getInstance() {
        if (citiesRepository == null) {
            citiesRepository = new CitiesRepository();
        }
        return citiesRepository;
    }

    /**
     * Get cities from database.
     */
    private void getCitiesFromDB() {
        SERVER_SERVICE.getCities(new AsyncCallback<List<CityDto>>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed while loading cities.");
            }

            @Override
            public void onSuccess(final List<CityDto> cities) {
                updateObservers(cities);
            }
        });
    }
}
