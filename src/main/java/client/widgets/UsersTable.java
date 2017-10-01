package client.widgets;

import client.modules.User;
import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.NoSelectionModel;
import lombok.Getter;
import lombok.Setter;

/** Create custom widget to keep the users.
 * Users will be added from UserAddForm or edited from EditAddForm.
 * */
public class UsersTable extends Composite {

    @Setter
    private UserEditForm userEditForm;
    @Setter
    private UserAddForm userAddForm;
    @Getter
    private CellTable<User> usersCellTable;
    @Getter
    private ListDataProvider<User> userListDataProvider;
    @Getter
    private final NoSelectionModel<User> selModel;
    @Getter private Button buttonDeleteUser;
    private TextColumn<User> columnFirstName;
    private TextColumn<User> columnMiddleName;
    private TextColumn<User> columnLastName;
    private TextColumn<User> columnSex;
    private TextColumn<User> columnCity;
    private TextColumn<User> columnDateOfBirthday;

    public UsersTable() {
        VerticalPanel panelMain = new VerticalPanel();
        usersCellTable = new CellTable<>();
        userListDataProvider = new ListDataProvider<>();
        selModel = new NoSelectionModel<>();

        buttonDeleteUser = new Button("Удалить");
        buttonDeleteUser.getElement().getStyle().setMargin(20, Style.Unit.PX);
        buttonDeleteUser.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);

        userListDataProvider.addDataDisplay(usersCellTable);

        usersCellTable.setSelectionModel(selModel);

        panelMain.add(usersCellTable);
        panelMain.add(buttonDeleteUser);

        initColumns();
        addColumns();
        setDeleteClickHandler();
        setSelectedItemListener();

        initWidget(panelMain);
    }

    /** initialize columns for table.
     * */
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
                return CityList.getItem(object.getCityIndex());
            }
        };
        columnSex = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.isMale() ? "Мужской" : "Женский";

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

    /** add columns to table.
     * */
    private void addColumns() {
        usersCellTable.setStyleName("users-table-general");
        usersCellTable.addColumn(columnFirstName, "Имя");
        usersCellTable.addColumn(columnMiddleName, "Отчество");
        usersCellTable.addColumn(columnLastName, "Фамилия");
        usersCellTable.addColumn(columnCity, "Город");
        usersCellTable.addColumn(columnSex, "Пол");
        usersCellTable.addColumn(columnDateOfBirthday, "Дата рождения");
    }

    /** set user's delete button click handler.
     * */
    private void setDeleteClickHandler() {
        buttonDeleteUser.addClickHandler(event -> {
            //delete selected object
            userListDataProvider.getList().remove(selModel.getLastSelectedObject());
            userListDataProvider.refresh();
            // if table is empty, then hide the delete button
            if(userListDataProvider.getList().isEmpty())
            {
                buttonDeleteUser.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
            }
        });
    }
    /** set listener for selected item of table.
     * */
    private void setSelectedItemListener() {
        selModel.addSelectionChangeHandler(event ->
        {
            //insert object attributes to user forms
            userAddForm.insertSelectedItem(selModel.getLastSelectedObject());
            userEditForm.insertSelectedItem(selModel.getLastSelectedObject());
        });
    }

    public void add(User user) {
        // add new user to table
        userListDataProvider.getList().add(user);
        userListDataProvider.refresh();


    }
}
