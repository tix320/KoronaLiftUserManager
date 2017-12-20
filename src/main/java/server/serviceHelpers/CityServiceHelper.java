package server.serviceHelpers;

import server.injection.ConverterManager;
import server.injection.DaoManager;
import shared.dto.CityDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Service helper for cities requests.
 */
@RequestScoped
public class CityServiceHelper {

    @Inject
    private DaoManager daoManager;

    @Inject
    private ConverterManager converterManager;

    /**
     * Add new city.
     *
     * @param cityDto is additional city.
     */
    public void addCity(CityDto cityDto) {
        daoManager.getCityController().add(converterManager.getCityConverter().convertToEntity(cityDto));
    }

    /**
     * Get list of cities from database.
     *
     * @return list of cities.
     */
    public List<CityDto> getCities() {
        return converterManager.getCityConverter().convertToDto(daoManager.getCityController().getAll());
    }
}
