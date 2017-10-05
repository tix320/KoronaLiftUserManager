package client.widgets.userTable;

import client.modules.User;
import client.widgets.userForm.UserAddForm;
import client.widgets.userForm.UserEditForm;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import lombok.Getter;
import lombok.Setter;

/**
 * Create custom widget to keep the users.
 * Users will be added from UserAddForm or edited from EditAddForm.
 */
public class UsersTable extends Composite {
    private final String DELETE_BUTTON_TEXT = "Удалить";
    @Getter
    private final SingleSelectionModel<User> selModel;
    @Setter
    private UserEditForm userEditForm;
    @Setter
    private UserAddForm userAddForm;
    @Getter
    private CellTable<User> usersCellTable;
    @Getter
    private ListDataProvider<User> userListDataProvider;
    @Getter
    private Button deleteButtonUser;
    
    private ColumnFirstName columnFirstName;
    private ColumnMiddleName columnMiddleName;
    private ColumnLastName columnLastName;
    private ColumnSex columnSex;
    private ColumnCity columnCity;
    private ColumnDateOfBirth columnDateOfBirth;
    
    public UsersTable() {
        VerticalPanel panelMain = new VerticalPanel();
        usersCellTable = new CellTable<>();
        userListDataProvider = new ListDataProvider<>();
        selModel = new SingleSelectionModel<>();
        usersCellTable.setVisibleRange(0, 100);
        
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
        
        columnFirstName = new ColumnFirstName();
        columnMiddleName = new ColumnMiddleName();
        columnLastName = new ColumnLastName();
        columnSex = new ColumnSex();
        columnCity = new ColumnCity();
        columnDateOfBirth = new ColumnDateOfBirth();
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
        usersCellTable.addColumn(columnDateOfBirth, "Дата рождения");
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
     *
     * @param user is the user, which will be added.
     */
    public void add(User user) {
        userListDataProvider.getList().add(user);
    }
    
    /**
     * Edit user to table.
     *
     * @param user is the user, which will be edited.
     */
    public void edit(User user) {
        int index = getUserListDataProvider().getList().indexOf(selModel.getSelectedObject());
        getUserListDataProvider().getList().set(index, user);
    }
    
}
