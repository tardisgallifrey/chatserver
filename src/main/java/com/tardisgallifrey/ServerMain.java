package com.tardisgallifrey;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {



    public static void main(String[] args) {

        //TODO: name the client thread by the name received from client

        //TODO: add current client to list of open clients

        //TODO: add message out from server client when connected

        //TODO: add unique names for each server thread and send as name to client in messages.

        
        
        System.out.println("Type ctrl-C to quit\n");

        Runnable server1 = new ChatServer("ChatServer",6100);
        ExecutorService servers = Executors.newFixedThreadPool(5);
        servers.submit(server1);












    }
}