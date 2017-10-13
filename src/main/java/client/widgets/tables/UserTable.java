package client.widgets.tables;

import client.data.DataObserver;
import client.objects.User;
import client.objects.UsersRepository;
import client.widgets.tables.columns.ColumnCity;
import client.widgets.tables.columns.ColumnDateOfBirth;
import client.widgets.tables.columns.ColumnDelete;
import client.widgets.tables.columns.ColumnFirstName;
import client.widgets.tables.columns.ColumnLastName;
import client.widgets.tables.columns.ColumnMiddleName;
import client.widgets.tables.columns.ColumnSex;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * Create custom widget to keep the users.
 * Users will be added from UserAddForm or edited from EditAddForm.
 */
public class UserTable extends Composite implements DataObserver<User> {
    
    /** Model for table object selection. */
    private SingleSelectionModel<User> selModel;
    
    /** Current selected user's index. */
    private int selectedUserIndex;
    
    /** List of users. */
    private ListDataProvider<User> users;
    
    /** Cell table to show users. */
    private CellTable<User> cellTable;
    
    /**
     * Constructor for creating user table.
     */
    public UserTable() {
        cellTable = new CellTable<>();
        selModel = new SingleSelectionModel<>();
        users = new ListDataProvider<>();
        
        users.addDataDisplay(cellTable);
        cellTable.setSelectionModel(selModel);
        
        initColumns();
        setSelectedItemListener();
        
        initWidget(cellTable);
    }
    
    /**
     * Initialize columns for table.
     */
    private void initColumns() {
        cellTable.setStyleName("users-table-general");
        cellTable.addColumn(new ColumnFirstName(), "Имя");
        cellTable.addColumn(new ColumnMiddleName(), "Отчество");
        cellTable.addColumn(new ColumnLastName(), "Фамилия");
        cellTable.addColumn(new ColumnSex(), "Город");
        cellTable.addColumn(new ColumnCity(), "Пол");
        cellTable.addColumn(new ColumnDateOfBirth(), "Дата рождения");
        cellTable.addColumn(createColumnDelete(), "Удалить");
    }
    
    /**
     * Create delete column for removing users.
     *
     * @return created column.
     */
    private ColumnDelete createColumnDelete() {
        ColumnDelete columnDelete = new ColumnDelete(new ButtonCell());
        columnDelete.setFieldUpdater((index, object, value) -> deleteButtonAction(object));
        return columnDelete;
    }
    
    /**
     * Action of delete column button.
     * Send info to delete user from registered tables.
     *
     * @param user is a removing object.
     */
    private void deleteButtonAction(User user) {
        UsersRepository.getRepository().removeUser(user);
    }
    
    /**
     * Set listener for selected item of table.
     */
    private void setSelectedItemListener() {
        selModel.addSelectionChangeHandler(event -> {
            selectedUserIndex = users.getList().indexOf(selModel.getSelectedObject());
            sendSelectedObject(selModel.getSelectedObject());
        });
    }
    
    /**
     * Send selected object to somewhere.
     *
     * @param selectedUser is a selected object in table.
     */
    private void sendSelectedObject(User selectedUser) {
        UsersRepository.getRepository().responseFromObserver(selectedUser);
    }
    
    @Override
    public void update(User user, UpdateType updateType) {
        if (updateType == UpdateType.ADD) {
            users.getList().add(user);
        } else if (updateType == UpdateType.REMOVE) {
            users.getList().remove(user);
        } else if (updateType == UpdateType.EDIT) {
            users.getList().set(selectedUserIndex, user);
        }
    }
}

    
  
