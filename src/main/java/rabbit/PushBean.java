package rabbit;

import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PushBean {

    @Inject
    @Push(channel = "websocket")
    private PushContext pushContext;

    public void sendMessage(String message) {
        pushContext.send(message);
    }
}
