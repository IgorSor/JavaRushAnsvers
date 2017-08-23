package com.javarush.task.task30.task3008;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String name;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message msg = connection.receive();
                name = msg.getData();
                if(msg.getType().equals(MessageType.USER_NAME) && !name.isEmpty() && name != null && !connectionMap.containsKey(name)){
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    connectionMap.put(name,connection);
                    ConsoleHelper.writeMessage("Name accepted.");
                    break;
                }
            }
            return name;
        }
        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                String clientName = map.getKey();
                if (!clientName.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
                }
            }

        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message msg = connection.receive();
                if (msg.getType() == MessageType.TEXT)
                    sendBroadcastMessage(new Message(msg.getType(),userName+": "+msg.getData()));
                else ConsoleHelper.writeMessage("Error!");
            }

        }
        public void run(){
            ConsoleHelper.writeMessage("Connection success with socker: "+socket.getRemoteSocketAddress());
            try {
                Connection connection = new Connection(socket);
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error!");
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Error!");

            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        try{
            for (Map.Entry<String, Connection> map : connectionMap.entrySet()){
                map.getValue().send(message);
            }
        }catch (IOException e){
            ConsoleHelper.writeMessage("Cannot send a message.");
        }
    }
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("write port please");
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Server is run");
        while (true){
            try{
                new Handler(serverSocket.accept()).start();
            }catch (Exception e){
                serverSocket.close();
                ConsoleHelper.writeMessage("error ServerSocket"+e);
                break;
            }
        }
    }
}
