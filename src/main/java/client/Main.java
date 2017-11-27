package client;

import client.widgets.main.UserControlPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main class, where the program is launched.
 */
public class Main implements EntryPoint {

    @Override
    public final void onModuleLoad() {
        RootPanel.get().add(new UserControlPanel());
    }
}
