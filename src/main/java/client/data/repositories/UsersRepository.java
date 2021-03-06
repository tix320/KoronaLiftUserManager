package client.data.repositories;

import client.data.DataSource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import lombok.Getter;
import org.realityforge.gwt.websockets.client.WebSocket;
import org.realityforge.gwt.websockets.client.WebSocketListener;
import shared.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for usersList.
 */
public final class UsersRepository extends Repository<UserDto> {

    /** Repository reference. */
    private static UsersRepository usersRepository;

    /** Web socket instance. */
    private final WebSocket webSocket = WebSocket.newWebSocketIfSupported();

    /** List of data sources. */
    @Getter
    private List<DataSource<UserDto>> sources = new ArrayList<>();


    /**
     * Private constructor for singleton.
     */
    private UsersRepository() {
        connectWebSocket();
        getUsersFromDB();
    }

    /**
     * Connect to web socket protocol.
     */
    private void connectWebSocket() {
        webSocket.setListener(new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket) {
            }

            @Override
            public void onClose(WebSocket webSocket, boolean b, int i, String s) {
            }

            @Override
            public void onMessage(WebSocket webSocket, String s) {
                getUsersFromDB();
            }

            @Override
            public void onMessage(WebSocket webSocket, ArrayBuffer arrayBuffer) {
                getUsersFromDB();
            }

            @Override
            public void onError(WebSocket webSocket) {
                Window.alert("WebSocket error.");
            }
        });
        webSocket.connect(GWT.getHostPageBaseURL().replaceFirst("^http:", "ws:") + "users");
    }

    /**
     * Create the repository.
     *
     * @return created repository.
     */
    static UsersRepository getInstance() {
        if (usersRepository == null) {
            usersRepository = new UsersRepository();
        }
        return usersRepository;
    }

    /**
     * Add new user.
     *
     * @param user is adding user.
     */
    public void addUser(final UserDto user) {
        SERVER_SERVICE.addUser(user, new AsyncCallback<Long>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed while adding user.");
            }

            @Override
            public void onSuccess(final Long quantity) {
                webSocket.send("Hello Server");
                Window.alert("Ползователи из города " + user.getCity().getName() + ": " + quantity);
            }
        });
    }

    /**
     * Edit the user.
     *
     * @param user is a new data of user.
     */
    public void editUser(final UserDto user) {
        SERVER_SERVICE.editUser(user, new AsyncCallback<Long>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed while editing user.");
            }

            @Override
            public void onSuccess(final Long quantity) {
                webSocket.send("Hello Server");
                Window.alert("Ползователи из города " + user.getCity().getName() + ": " + quantity);
            }
        });
    }

    /**
     * Remove the user.
     *
     * @param user is a removing user.
     */
    public void removeUser(final UserDto user) {
        SERVER_SERVICE.removeUser(user, new AsyncCallback<Long>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed while removing user.");
            }

            @Override
            public void onSuccess(final Long quantity) {
                webSocket.send("Hello Server");
                Window.alert("Ползователи из города " + user.getCity().getName() + ": " + quantity);
            }
        });
    }

    /**
     * Get users from Database.
     */
    private void getUsersFromDB() {
        SERVER_SERVICE.getUsers(new AsyncCallback<List<UserDto>>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed while loading users list.");
            }

            @Override
            public void onSuccess(final List<UserDto> users) {
                handleEvent(users);
            }
        });
    }

    /**
     * Add data source.
     *
     * @param source is a data source.
     */
    public void registerSource(final DataSource<UserDto> source) {
        sources.add(source);
    }

    /**
     * Send any data from observers to sources.
     *
     * @param user is a data owner.
     */
    public void responseFromObserver(final UserDto user) {
        getSources().forEach(source -> source.response(user));
    }
}
