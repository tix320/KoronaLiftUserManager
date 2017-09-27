package client.widgets;
import client.Main;
import client.modules.User;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import java.util.Date;

public class UserAddForm extends Composite {

    private HorizontalPanel panelMain;
    private VerticalPanel panelSubmit;
    private VerticalPanel panelError;
    private HorizontalPanel panelSex;

    private TextBox textFirstName;
    private TextBox textMiddleName;
    private TextBox textLastName;
    private RadioButton radioMale;
    private RadioButton radioFemale;
    private ListBox listCity;
    private DateOfBirthdayCalendar dateOfBirthday;
    private Button buttonAddUser;
    private Label arrayShowErrors[];
    private boolean arrayAreFilled[];

    public UserAddForm() {
         initWidgets();
         setStyles();
         setErrorLabels();
         setPlaceHolders();
         setClickHandler();
         setItemsToCityList();

        panelSex.add(radioMale);
        panelSex.add(radioFemale);

        panelSubmit.add(textFirstName);
        panelSubmit.add(textMiddleName);
        panelSubmit.add(textLastName);
        panelSubmit.add(panelSex);
        panelSubmit.add(listCity);
        panelSubmit.add(dateOfBirthday);
        panelSubmit.add(buttonAddUser);

        panelMain.add(panelSubmit);
        panelMain.add(panelError);

        visibilityErrorLabels(Style.Visibility.HIDDEN);

        initWidget(panelMain);
    }

    private void initWidgets(){
         panelMain = new HorizontalPanel();
         panelSubmit = new VerticalPanel();
         panelError = new VerticalPanel();
         panelSex = new HorizontalPanel();

         dateOfBirthday = new DateOfBirthdayCalendar();
         radioFemale = new RadioButton("male", "женский");
         radioMale = new RadioButton("male", "мужский");
         textFirstName = new TextBox();
         textMiddleName = new TextBox();
         textLastName = new TextBox();
         listCity = new ListBox();
         buttonAddUser = new Button("Добавить");
         arrayShowErrors = new Label[5];
         arrayAreFilled = new boolean[5];
    }

    private void visibilityErrorLabels(Style.Visibility visibility) {
        for (Label label : arrayShowErrors) {
           label.getElement().getStyle().setVisibility(visibility);
        }
    }

    private void setPlaceHolders() {
        textFirstName.getElement().setAttribute("placeholder", "Имя");
        textMiddleName.getElement().setAttribute("placeholder", "Отчество");
        textLastName.getElement().setAttribute("placeholder", "Фамилия");
    }

    private void setItemsToCityList() {
        for (String city : CityList.getListCity()) {
            listCity.addItem(city);
        }
        listCity.setValue(0,"city");
    }

    private void setErrorLabels(){
        arrayShowErrors[0] = new Label("Введите Имя");
        arrayShowErrors[1] = new Label("Введите Отчество");
        arrayShowErrors[2] = new Label("Введите Фамилия");
        arrayShowErrors[3] = new Label("Выберите пол");
        arrayShowErrors[4] = new Label("Выберите город");

        for (Label label : arrayShowErrors) {
            panelError.add(label);
        }
    }

    private void setStyles() {
        panelSex.setStyleName("panelSex");
        listCity.setStyleName("listCity");
        dateOfBirthday.setStyleName("dateOfBirthday");
    }

    private void setClickHandler() {

        buttonAddUser.addClickHandler(event -> {
            for (int i = 0; i < 5 ; i++) {
                arrayAreFilled[i] = false;
            }

            String firstName = textFirstName.getText();
            String middleName = textLastName.getText();
            String lastName = textMiddleName.getText();
            boolean sex = radioMale.isAttached() ? radioMale.getValue() : radioFemale.getValue();
            String city = listCity.getSelectedItemText();
            Date date = dateOfBirthday.getDate();
           if(areFilled()){
                Main.getUsersTable().add(new User(firstName, middleName, lastName, city, sex, date));
                visibilityErrorLabels(Style.Visibility.HIDDEN);
            }
            else showErrors();
        });

    }

    private boolean areFilled() {
        if (!textFirstName.getText().equals("")) arrayAreFilled[0] = true;
        if (!textMiddleName.getText().equals("")) arrayAreFilled[1] = true;
        if (!textLastName.getText().equals("")) arrayAreFilled[2] = true;
        if (radioMale.getValue() || radioFemale.getValue()) arrayAreFilled[3] = true;
        if (!listCity.getSelectedValue().equals("city")) arrayAreFilled[4] = true;

        for (int i = 0; i < 5; i++) {
            if (!arrayAreFilled[i])
                return false;
        }

        return true;
    }

    private void showErrors() {
        for (int i = 0; i <5 ; i++) {
            if(!arrayAreFilled[i]) arrayShowErrors[i].getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
            else  arrayShowErrors[i].getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
        }
    }
}
