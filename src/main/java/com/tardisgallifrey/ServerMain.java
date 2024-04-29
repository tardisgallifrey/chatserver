package com.tardisgallifrey;

public class ServerMain {



    public static void main(String[] args) {
        Runnable server1 = new ChatServer("Server One", 6100);
        Runnable server2 = new ChatServer("Server Two", 6200);

        Thread t1 = new Thread(server1);

        Thread t2 = new Thread(server2);

        t1.start();

        System.out.println("Inside "+Thread.currentThread().getName());

        t2.start();

        System.out.println("Inside "+Thread.currentThread().getName());







    }
}