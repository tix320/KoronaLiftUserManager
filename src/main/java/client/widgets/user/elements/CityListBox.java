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
    public String getValue(CityDto object) {
        return object.getName();
    }

    /**
     * Set items to city list box.
     *
     * @param data is list of items.
     */
    void setItems(List<CityDto> data) {
        CityDto cityDto = new CityDto();
        cityDto.setName(CITY);
        data.set(0, cityDto);
        setList(data);
        this.getElement().getFirstChildElement().setAttribute(DISABLED, DISABLED);
    }
}
