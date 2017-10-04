package client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

/**
 * Create customWidget - datePicker with year and month selection.
 */
public class DatePickerPanel extends Composite {
    private final int VISIBLE_YEAR_COUNT = 50;
    private DatePicker datePicker;

    public DatePickerPanel() {
        datePicker = new DatePicker();

        datePicker.setStyleName("user-form-date-of-birthday-picker");

        // Set starting value of Date - current date.
        datePicker.setValue(new Date());

        // Set year an month selection.
        datePicker.setYearAndMonthDropdownVisible(true);
        datePicker.setYearArrowsVisible(true);
        datePicker.setVisibleYearCount(VISIBLE_YEAR_COUNT);

        // Initialize datePicker -> widget.
        initWidget(datePicker);
    }

    /**
     * Get selected date on date picker.
     *
     * @return value of Date.
     */
    public Date getDate() {
        return datePicker.getValue();
    }

    /**
     * Set date on date picker.
     *
     * @param date is a value of date.
     */
    public void setDate(Date date) {
        datePicker.setValue(date);
    }

}
