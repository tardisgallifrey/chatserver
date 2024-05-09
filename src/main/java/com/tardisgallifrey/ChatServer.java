package com.tardisgallifrey;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

        System.out.println("...starting...");

        while(true) {
            try {
                s = new ServerSocket(serverPort);
                this.setThreadName(String.valueOf(s.getInetAddress() + " port: " +
                        String.valueOf(s.getLocalPort())));

                s.getReuseAddress();
                Socket msgClient = s.accept();

                System.out.println("Conn from: "+ msgClient.getInetAddress().getHostAddress());
                MsgHandler handler = new MsgHandler(msgClient);
                new Thread(handler).start();

            } catch (IOException e) {

                System.out.println(e.getLocalizedMessage());
            } finally {

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
