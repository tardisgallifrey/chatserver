package com.tardisgallifrey;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {



    public static void main(String[] args) {
        System.out.println("Type ctrl-C to quit\n");
<<<<<<< HEAD
        Runnable server1 = new ChatServer("ChatServer",6100);
        ExecutorService servers = Executors.newFixedThreadPool(15);
        servers.submit(server1);
=======
        Runnable server1 = new ChatServer("Server One", 6100);
>>>>>>> 2e07996 (unsupported commit)










    }
}