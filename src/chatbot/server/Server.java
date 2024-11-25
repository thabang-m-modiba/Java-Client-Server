package chatbot.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
private static int port = 2024;

    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(port)){
            System.out.println("The server is running on port " + port);
            boolean running = true;
            while(running){
                Socket socket = ss.accept();
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
