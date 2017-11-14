package server.converters;

import server.entity.City;
import shared.models.CityDto;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Converter to convert city objects.
 */
@Stateless
public class CityConverter implements DataConverter<CityDto, City>, Serializable {

    @Override
    public final CityDto convertToDto(final City city) {
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
    public final City convertToEntity(final CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        return city;
    }
}
