package exp6;

import java.io.*;

class Process1 {
    public static void main(String[] args) throws IOException {
        // Creating a pipe
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader(writer);

        // Creating a new process (Process2) and passing the reader
        Process2 process2 = new Process2(reader);
        new Thread(process2).start();

        // Sending a message
        String message = "Hello from Process 1!";
        writer.write(message);
        writer.close();
        System.out.println("Process 1 sent: " + message);
    }
}

class Process2 implements Runnable {
    private PipedReader reader;

    public Process2(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String message = bufferedReader.readLine();
            System.out.println("Process 2 received: " + message);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class IPCExample {
    public static void main(String[] args) throws IOException {
        Process1.main(args);
    }
}
