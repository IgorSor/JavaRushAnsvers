package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by MadHarry on 02.07.2017.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;
    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" is connected to chat!");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" is abandon chat!");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException,ClassNotFoundException{
                while (true){
                        Message msg = connection.receive();
                        if(msg.getType() == MessageType.NAME_REQUEST){
                            connection.send(new Message(MessageType.USER_NAME,getUserName()));
                        }else if(msg.getType() == MessageType.NAME_ACCEPTED) {
                            notifyConnectionStatusChanged(true);break;
                        }else {
                            throw new IOException("Unexpected MessageType");
                        }
                    }
        }
        protected void clientMainLoop() throws IOException,ClassNotFoundException{
                while (true) {
                    Message msg = connection.receive();
                    if (msg.getType() == MessageType.TEXT){
                        processIncomingMessage(msg.getData());
                    }else if(msg.getType() == MessageType.USER_ADDED){
                        informAboutAddingNewUser(msg.getData());
                    }else if(msg.getType() == MessageType.USER_REMOVED){
                        informAboutDeletingNewUser(msg.getData());
                    }else {
                        throw new IOException("Unexpected MessageType");
                    }
                }
        }
        public void run(){
            try {
                String serverName = getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(serverName,port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e){
                notifyConnectionStatusChanged(false);
            }
        }
    }
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Please, input the name of server:");
        String address = ConsoleHelper.readString();
        return address;
    }
    protected int getServerPort(){
        return ConsoleHelper.readInt();
    }
    protected String getUserName(){
        String userName = ConsoleHelper.readString();
        return userName;
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try{
            connection.send(new Message(MessageType.TEXT, text));
        }catch (IOException e){
            ConsoleHelper.writeMessage("Error while sending a message" + e);
            clientConnected = false;
        }
    }
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Wait error");
            return;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        String message;
        while (clientConnected) {
            if (!(message = ConsoleHelper.readString()).equals("exit")) {
                if (shouldSendTextFromConsole()) sendTextMessage(message);
            } else
                break;
        }
    }
    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }
}
