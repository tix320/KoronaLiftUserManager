package server.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import server.entity.City;
import shared.models.CityDto;

/**
 * Converter to convert city objects.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CityConverter implements DataConverter<CityDto, City> {

    /** Instance of city converter. */
    private static CityConverter cityConverter;

    /**
     * Get instance of city converter.
     *
     * @return city converter.
     */
    public static CityConverter getConverter() {
        if (cityConverter == null) {
            cityConverter = new CityConverter();
        }
        return cityConverter;
    }

    @Override
    public final CityDto convertToDto(final City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        return cityDto;
    }

    @Override
    public final City convertToEntity(final CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        return city;
    }
}
