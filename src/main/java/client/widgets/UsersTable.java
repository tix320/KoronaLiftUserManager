package client.widgets;

import client.modules.User;
import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Create custom widget to keep the users.
 * Users will be added from UserAddForm or edited from EditAddForm.
 * */
public class UsersTable extends Composite {

    private final String DELETE_BUTTON_TEXT = "Удалить";

    @Setter
    private UserEditForm userEditForm;

    @Setter
    private UserAddForm userAddForm;

    @Getter
    private CellTable<User> usersCellTable;

    @Getter
    private ListDataProvider<User> userListDataProvider;

    @Getter
    private final SingleSelectionModel<User> selModel;

    @Getter
    private Button deleteButtonUser;

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
        selModel = new SingleSelectionModel<>();
        usersCellTable.setVisibleRange(0,100);

        deleteButtonUser = new Button(DELETE_BUTTON_TEXT);
        deleteButtonUser.getElement().getStyle().setMargin(20, Style.Unit.PX);
        deleteButtonUser.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);

        userListDataProvider.addDataDisplay(usersCellTable);

        usersCellTable.setSelectionModel(selModel);

        panelMain.add(usersCellTable);
        panelMain.add(deleteButtonUser);

        initColumns();
        addColumns();
        setDeleteClickHandler();
        setSelectedItemListener();

        initWidget(panelMain);
    }

    /**
     * Initialize columns for table.
     */
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
                return userAddForm.getCityPanel().getCityName(object.getCityNumber());
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

    /**
     * Add columns to table.
     */
    private void addColumns() {
        usersCellTable.setStyleName("users-table-general");
        usersCellTable.addColumn(columnFirstName, "Имя");
        usersCellTable.addColumn(columnMiddleName, "Отчество");
        usersCellTable.addColumn(columnLastName, "Фамилия");
        usersCellTable.addColumn(columnCity, "Город");
        usersCellTable.addColumn(columnSex, "Пол");
        usersCellTable.addColumn(columnDateOfBirthday, "Дата рождения");
    }

    /**
     * Set user's delete button click handler.
     */
    private void setDeleteClickHandler() {
        deleteButtonUser.addClickHandler(event -> {

            //Delete selected object.
            userListDataProvider.getList().remove(selModel.getSelectedObject());
            userListDataProvider.refresh();

            // Disable edit and delete buttons.
            deleteButtonUser.setEnabled(false);
            userEditForm.getButtonSubmit().setEnabled(false);

            // If table is empty, then hide the delete button.
            if (userListDataProvider.getList().isEmpty()) {
                deleteButtonUser.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
            }
        });
    }

    /**
     * Set listener for selected item of table.
     */
    private void setSelectedItemListener() {
        selModel.addSelectionChangeHandler(event -> {
            userEditForm.getButtonSubmit().setEnabled(true);
            deleteButtonUser.setEnabled(true);
            userAddForm.insertSelectedItem(selModel.getSelectedObject());
            userEditForm.insertSelectedItem(selModel.getSelectedObject());
        });
    }

    /**
     * Add new user to table.
     * @param user is the user, which will be added.
     */
    public void add(User user) {
        userListDataProvider.getList().add(user);
        userListDataProvider.refresh();
    }
}
