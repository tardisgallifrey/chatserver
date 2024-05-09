package com.tardisgallifrey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MsgHandler implements Runnable {
    private final Scanner input = new Scanner(System.in);
    private final Socket clientConn;
    private PrintWriter out;
    private BufferedReader in;


    public MsgHandler(Socket serverConn){
        this.clientConn = serverConn;
    }


    @Override
    public void run() {

        try {
            out = new PrintWriter(clientConn.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientConn.getInputStream()));


            String message = "";
            String clientName = in.readLine();

            while ((message = in.readLine()) != null) {

                // writing the received message from
                // client
                System.out.println(clientName+message);
                out.println("From Server"+message);
                out.flush();
            }

        }

        catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    clientConn.close();
                }
                input.close();
            }
            catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }

        }
}
}
