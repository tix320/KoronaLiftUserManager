package client.widgets;

import client.modules.User;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.NoSelectionModel;

import java.util.ArrayList;
import java.util.List;

public class UsersTable extends Composite {

    private CellTable<User> usersTable = new CellTable<>();
    private List<User> usersList = new ArrayList<>();
    private final NoSelectionModel<User> selModel = new NoSelectionModel<>();
    private Button deleteButton = new Button("Удалить");
    private TextColumn<User> columnFirstName;
    private TextColumn<User> columnMiddleName;
    private TextColumn<User> columnLastName;
    private TextColumn<User> columnSex;
    private TextColumn<User> columnCity;
    private TextColumn<User> columnDateOfBirthday;



    public UsersTable() {
        VerticalPanel panelMain = new VerticalPanel();

        panelMain.add(usersTable);
        panelMain.add(deleteButton);

        initWidget(panelMain);

        usersTable.setSelectionModel(selModel);

        initColumns();
        addColumns();
        setClickHandler();
    }

    private void addColumns() {
        usersTable.setStyleName("users-table-general");
        usersTable.addColumn(columnFirstName,"Имя");
        usersTable.addColumn(columnMiddleName,"Отчество");
        usersTable.addColumn(columnLastName,"Фамилия");
        usersTable.addColumn(columnCity,"Город");
        usersTable.addColumn(columnSex,"Пол");
        usersTable.addColumn(columnDateOfBirthday,"Дата рождения");
    }

    private void initColumns() {
         columnFirstName = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getFirstName();
            }
        };
         columnMiddleName = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getMiddleName();
            }
        };
         columnLastName = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getLastName();
            }
        };
         columnCity = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getCity();
            }
        };
         columnSex = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getSex() ? "Мужской" : "Женский";

            }
        };
         columnDateOfBirthday = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                DateTimeFormat df = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT);
                return df.format(object.getDateOfBirthday());
            }

        };
    }

    private void setClickHandler() {
        deleteButton.addClickHandler(event -> {
           int selectedIndex = usersList.indexOf(selModel.getLastSelectedObject());
           usersList.remove(selectedIndex);
           usersTable.setRowData(usersList);
        });
    }

      void add(User user){

        usersList.add(user);
        usersTable.setRowData(usersList);

    }
}
