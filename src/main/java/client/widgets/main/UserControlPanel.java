package client.widgets.main;

import client.widgets.tables.Table;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Main panel of UI.
 */
public class UserControlPanel extends Composite {

    /**
     * Create and initialize the main panel of UI.
     */
    public UserControlPanel() {
        FlowPanel mainPanel = new FlowPanel();
        mainPanel.add(new UserFormTabPanel());
        mainPanel.add(new Table());

        initWidget(mainPanel);
    }
}
