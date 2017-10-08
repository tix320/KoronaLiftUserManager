package client.abstraction.userTable;

public interface TableDataUpdater {
    
    /**
     * Add table, who will follow this updater.
     *
     * @param table is adding table.
     */
    void registerTable(Table table);
    
    /**
     * Delete the table.
     *
     * @param table is removing table.
     */
    void removeTable(Table table);
}
