package client.widgets.tables;

import client.data.DataObserver;
import client.data.DataRepository;
import client.data.UpdateType;
import client.models.User;
import client.widgets.tables.columns.ColumnCity;
import client.widgets.tables.columns.ColumnDateOfBirth;
import client.widgets.tables.columns.ColumnDelete;
import client.widgets.tables.columns.ColumnFirstName;
import client.widgets.tables.columns.ColumnLastName;
import client.widgets.tables.columns.ColumnPatronymic;
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
        DataRepository.getUsersRepository().registerObserver(this);
        SingleSelectionModel<User> selModel = new SingleSelectionModel<>();
        
        cellTable = new CellTable<>();
        cellTable.setSelectionModel(selModel);
        selModel.addSelectionChangeHandler(e -> selectAction(selModel.getSelectedObject()));
        
        users = new ListDataProvider<>();
        users.addDataDisplay(cellTable);
    
        addColumns();
        
        initWidget(cellTable);
    }
    
    /**
     * Action of item selection in table.
     */
    private void selectAction(User selectedUser) {
        selectedUserIndex = users.getList().indexOf(selectedUser);
        sendSelectedObject(selectedUser);
    }
    
    /**
     * Add columns to table.
     */
    private void addColumns() {
        cellTable.setStyleName("users-table-general");
        cellTable.addColumn(new ColumnFirstName(), "Имя");
        cellTable.addColumn(new ColumnPatronymic(), "Отчество");
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
     * @param removingUser is a removing object.
     */
    private void deleteButtonAction(User removingUser) {
        DataRepository.getUsersRepository().removeUser(removingUser.getID());
    }
    
    /**
     * Send selected object to somewhere.
     *
     * @param selectedUser is a selected object in table.
     */
    private void sendSelectedObject(User selectedUser) {
        DataRepository.getUsersRepository().responseFromObserver(selectedUser.getID(), selectedUser);
    }
    
    @Override
    public void update(User user, UpdateType updateType) {
        switch (updateType) {
            case ADD:
                users.getList().add(user);
                break;
            case EDIT:
                users.getList().set(selectedUserIndex, user);
                break;
            case REMOVE:
                users.getList().remove(user);
        }
    }
}