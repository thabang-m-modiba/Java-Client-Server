package chatbot.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    private static int port = 2024;

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))) {

                boolean running = true;
                while(running){
                    System.out.print("Enter: ");
                    String userMsg = userIn.readLine();
                    out.println(userMsg);
                    System.out.println("Server/ Bot: " + in.readLine());
                    running = false;
                }
            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}