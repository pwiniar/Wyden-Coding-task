package wyden.coding.task.infrastructure.websocket;

import jakarta.websocket.*;
import jakarta.websocket.MessageHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MockedSession implements Session {

    private List<String> messages = new ArrayList<>();
    MessageHandler.Whole<String> messageHandler;


    @Override
    public WebSocketContainer getContainer() {
        return null;
    }

    @Override
    public void addMessageHandler(MessageHandler handler) throws IllegalStateException {
        this.messageHandler = ((MessageHandler.Whole<String>) handler);
    }

    @Override
    public Set<MessageHandler> getMessageHandlers() {
        return null;
    }

    @Override
    public void removeMessageHandler(MessageHandler listener) {

    }

    @Override
    public String getProtocolVersion() {
        return null;
    }

    @Override
    public String getNegotiatedSubprotocol() {
        return null;
    }

    @Override
    public List<Extension> getNegotiatedExtensions() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public long getMaxIdleTimeout() {
        return 0;
    }

    @Override
    public void setMaxIdleTimeout(long timeout) {

    }

    @Override
    public void setMaxBinaryMessageBufferSize(int max) {

    }

    @Override
    public int getMaxBinaryMessageBufferSize() {
        return 0;
    }

    @Override
    public void setMaxTextMessageBufferSize(int max) {

    }

    @Override
    public int getMaxTextMessageBufferSize() {
        return 0;
    }

    @Override
    public RemoteEndpoint.Async getAsyncRemote() {
        return null;
    }

    @Override
    public RemoteEndpoint.Basic getBasicRemote() {
        return new RemoteEndpoint.Basic() {
            @Override
            public void sendText(String text) throws IOException {
                messages.add(text);
            }

            @Override
            public void sendBinary(ByteBuffer data) throws IOException {

            }

            @Override
            public void sendText(String fragment, boolean isLast) throws IOException {

            }

            @Override
            public void sendBinary(ByteBuffer partialByte, boolean isLast) throws IOException {

            }

            @Override
            public OutputStream getSendStream() throws IOException {
                return null;
            }

            @Override
            public Writer getSendWriter() throws IOException {
                return null;
            }

            @Override
            public void sendObject(Object data) throws IOException, EncodeException {

            }

            @Override
            public void setBatchingAllowed(boolean batchingAllowed) throws IOException {

            }

            @Override
            public boolean getBatchingAllowed() {
                return false;
            }

            @Override
            public void flushBatch() throws IOException {

            }

            @Override
            public void sendPing(ByteBuffer applicationData) throws IOException, IllegalArgumentException {

            }

            @Override
            public void sendPong(ByteBuffer applicationData) throws IOException, IllegalArgumentException {

            }
        };
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void close(CloseReason closeReason) throws IOException {

    }

    @Override
    public URI getRequestURI() {
        return null;
    }

    @Override
    public Map<String, List<String>> getRequestParameterMap() {
        return null;
    }

    @Override
    public String getQueryString() {
        return null;
    }

    @Override
    public Map<String, String> getPathParameters() {
        return null;
    }

    @Override
    public Map<String, Object> getUserProperties() {
        return null;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public Set<Session> getOpenSessions() {
        return null;
    }

    @Override
    public <T> void addMessageHandler(Class<T> clazz, MessageHandler.Partial<T> handler) throws IllegalStateException {

    }

    @Override
    public <T> void addMessageHandler(Class<T> clazz, MessageHandler.Whole<T> handler) throws IllegalStateException {

    }
}
