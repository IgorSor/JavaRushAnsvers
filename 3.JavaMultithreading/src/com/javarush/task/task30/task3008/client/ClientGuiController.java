package com.javarush.task.task30.task3008.client;
public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view ;
    public ClientGuiController() {
        this.view = new ClientGuiView(this);
    }
    public class GuiSocketThread extends SocketThread{
        @Override
        public void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }
        @Override
        public void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }
        @Override
        public void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }
        @Override
        public void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }
    @Override
    public void run() {
        getSocketThread().run();
    }
    protected SocketThread getSocketThread(){
        return new GuiSocketThread();
    }
    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }
    @Override
    protected String getUserName() {
        return view.getUserName();
    }
    public ClientGuiModel getModel(){
        return model;
    }
    public static void main(String[] args){
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }
}
