package client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

 class DateOfBirthdayPicker extends Composite {
    private DatePicker datePicker = new DatePicker();

     DateOfBirthdayPicker() {

        datePicker.setValue(new Date());
        datePicker.setYearAndMonthDropdownVisible(true);
        datePicker.setYearArrowsVisible(true);
        datePicker.setVisibleYearCount(50);

        initWidget(datePicker);
    }

     Date getDate(){
        return datePicker.getValue();
    }

}
