package com.tardisgallifrey;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer implements Runnable {
    private final String threadName;
    private final int serverPort;
    private ServerSocket s;

    ChatServer(String name, int port){
        this.threadName = name;
        this.serverPort = port;
        System.out.println("creating thread "+this.threadName);
    }

    public String getThreadName(){
        return this.threadName;
    }

    public void setThreadName(String name){
        Thread.currentThread().setName(name);
    }

    // run() method contains the code that is executed by the thread.
    @Override
    public void run() {


        while(true) {
            try {
                s = new ServerSocket(serverPort);
                this.setThreadName(String.valueOf(s.getInetAddress() + " port: " +
                        String.valueOf(s.getLocalPort())));
                System.out.println(this.threadName + " starting...");
                s.getReuseAddress();
                s.accept();
                System.out.println("client connected...");

            } catch (IOException e) {

                System.out.println(e.getLocalizedMessage());
            } finally {
                System.out.println("connection with: " + Thread.currentThread().getName());
                if (s != null) {
                    try {
                        s.close();
                    } catch (IOException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }
            }



        }
    }
}
