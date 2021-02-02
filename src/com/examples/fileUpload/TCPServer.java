package com.examples.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("DemoCopy.jpg");
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = is.read(bytes)) != -1){
            fos.write(bytes, 0 , len);
        }
        OutputStream os = socket.getOutputStream();
        os.write("upload successful".getBytes());
        socket.shutdownOutput();

        fos.close();
        socket.close();
        serverSocket.close();
    }
}
