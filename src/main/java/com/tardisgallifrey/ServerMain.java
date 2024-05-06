package com.tardisgallifrey;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {



    public static void main(String[] args) {
        System.out.println("Type ctrl-C to quit\n");
        Runnable server1 = new ChatServer("ChatServer",6100);
        ExecutorService servers = Executors.newFixedThreadPool(15);
        servers.submit(server1);










    }
}