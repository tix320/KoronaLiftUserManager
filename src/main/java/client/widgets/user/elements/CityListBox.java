package client.widgets.user.elements;

import client.widgets.custom.CustomListBox;
import shared.dto.CityDto;

import java.util.List;

/**
 * List box for City.
 */
public class CityListBox extends CustomListBox<CityDto> {

    /** City text. */
    private static final String CITY = "Город";

    /** HTML attribute. */
    private static final String DISABLED = "disabled";

    @Override
    public String getValue(final CityDto object) {
        return object.getName();
    }

    @Override
    public void setList(final List<CityDto> list) {
        CityDto cityDto = new CityDto();
        cityDto.setName(CITY);
        list.add(0, cityDto);
        super.setList(list);
        this.getElement().getFirstChildElement().setAttribute(DISABLED, DISABLED);
    }
}
