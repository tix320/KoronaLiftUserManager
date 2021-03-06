package server;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Server endpoint to notify clients for any updates.
 */
@ServerEndpoint(value = "/users")
public class ClientUpdater {

    /**
     * Set of sessions.
     */
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(final Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(final Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(final String s, final Session session) {
        sessions.forEach(ses -> ses.getAsyncRemote().sendText("Hello clients!"));
    }
}
