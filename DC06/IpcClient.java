package exp6;
import java.io.*;
import java.net.*;

public class IpcClient {
	public static void main(String args[]){
    	try(Socket socket = new Socket("192.168.3.41",5000);
    	PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
    	BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))){
        	System.out.println("Connected to server. Type message to send");
        	String message;

        	while((message = userInput.readLine()) !=null){
            	output.println(message);
            	System.out.println("Server message "+ input.readLine());
        	}
    	} catch (IOException e){
        	System.out.println("Error " + e.getMessage());
    	}
	}
}

