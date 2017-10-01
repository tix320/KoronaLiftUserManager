package client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

/**
* @Creat customWidget - datePicker with year and month selection
 */
 public class DateOfBirthdayPicker extends Composite {
    private DatePicker datePicker;

     public DateOfBirthdayPicker() {
        datePicker= new DatePicker();

        /* @set starting value of Date - current date  */
        datePicker.setValue(new Date());

        /*  @set year an month selection*/
        datePicker.setYearAndMonthDropdownVisible(true);
        datePicker.setYearArrowsVisible(true);
        datePicker.setVisibleYearCount(50);

         /*  @initialize datePicker -> widget */
        initWidget(datePicker);
    }

    /**
     *  Get selected date on date picker
     *  @return value of Date*/
     public Date getDate(){
        return datePicker.getValue();
    }

    /** Set date on date picker
     * @param date is a value of date */
    public void setDate(Date date) {
         datePicker.setValue(date);
     }

}
