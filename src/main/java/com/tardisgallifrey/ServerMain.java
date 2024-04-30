package com.tardisgallifrey;

public class ServerMain {



    public static void main(String[] args) {
        Runnable server1 = new ChatServer("Server One", 6100);

        Thread t1 = new Thread(server1);

        t1.start();









    }
}