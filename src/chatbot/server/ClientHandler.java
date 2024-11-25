package chatbot.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String clientMsg = in.readLine();
                while(clientMsg != null){
                    if(clientMsg.equalsIgnoreCase("Hello")){
                        out.println("Hey, How are you today?");
                    }else if(clientMsg.equalsIgnoreCase("Bye")){
                        out.println("Okay, We will chat later!");
                        break;
                    }else{
                        out.println("I didn't Understand that.");
                    }
                }
                socket.close();
                in.close();
                out.close();
            
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
    
}
