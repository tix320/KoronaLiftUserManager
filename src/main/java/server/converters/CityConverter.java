package server.converters;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import server.entity.City;
import shared.models.CityDto;

/**
 * Converter to convert city objects.
 */
@Stateless
public class CityConverter implements DataConverter<CityDto, City> {

    @Override
    public CityDto convertToDto(final City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        return cityDto;
    }

    @Override
    public List<CityDto> convertToDto(final List<City> list) {
        List<CityDto> listDto = new ArrayList<>();
        for (City city : list) {
            listDto.add(convertToDto(city));
        }
        return listDto;
    }

    @Override
    public City convertToEntity(final CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        return city;
    }
}
