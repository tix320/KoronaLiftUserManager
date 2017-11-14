package client.widgets.tables;

import client.widgets.tables.columns.*;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import shared.data.DataObserver;
import shared.data.repositories.DataRepository;
import shared.models.UserDto;

import java.util.List;

/**
 * Create custom widget to keep the users.
 * Users will be added from UserAddForm or edited from EditAddForm.
 */
public class UserTable extends Composite implements DataObserver<UserDto> {

    /** List of users. */
    private ListDataProvider<UserDto> users;

    /** Cell table to show users. */
    private CellTable<UserDto> cellTable;

    /**
     * Constructor for creating user table.
     */
    public UserTable() {
        DataRepository.getUsersRepository().registerObserver(this);
        SingleSelectionModel<UserDto> selModel = new SingleSelectionModel<>();

        cellTable = new CellTable<>();
        cellTable.setSelectionModel(selModel);
        selModel.addSelectionChangeHandler(e ->
                sendSelectedObject(selModel.getSelectedObject()));

        users = new ListDataProvider<>();
        users.addDataDisplay(cellTable);

        addColumns();

        initWidget(cellTable);
    }

    /**
     * Add columns to table.
     */
    private void addColumns() {
        cellTable.setStyleName("users-table-general");
        cellTable.addColumn(new ColumnFirstName(), "Имя");
        cellTable.addColumn(new ColumnPatronymic(), "Отчество");
        cellTable.addColumn(new ColumnLastName(), "Фамилия");
        cellTable.addColumn(new ColumnSex(), "Пол");
        cellTable.addColumn(new ColumnCity(), "Город");
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
        columnDelete.setFieldUpdater((index, object, value) ->
                deleteButtonAction(object));
        return columnDelete;
    }

    /**
     * Action of delete column button.
     * Send info to delete user from registered tables.
     *
     * @param removingUser is a removing object.
     */
    private void deleteButtonAction(final UserDto removingUser) {
        DataRepository.getUsersRepository().removeUser(removingUser);
    }

    /**
     * Send selected object to somewhere.
     *
     * @param selectedUser is a selected object in table.
     */
    private void sendSelectedObject(final UserDto selectedUser) {
        DataRepository.getUsersRepository().responseFromObserver(selectedUser);
    }

    @Override
    public final void update(final List<UserDto> data) {
        users.setList(data);
    }
}
