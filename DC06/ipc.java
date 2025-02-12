package DC06;

import java.io.*;
import java.net.*;

public class ipc{
	public static void main (String args[]) throws IOException{
    	try(ServerSocket server = new ServerSocket(5000) ){
        	System.out.println("Server is listening");
        	Socket socket = server.accept();

        	BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

        	String recievedmessage;

        	while((recievedmessage = input.readLine()) != null){
            	System.out.println("Client says: " + recievedmessage);
            	output.println("Server says " + recievedmessage);
        	}

        	socket.close();
    	} catch(IOException e){
        	System.out.println("Error: " + e.getMessage());
    	}
	}
}
