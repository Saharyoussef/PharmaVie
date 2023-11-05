package com.example.pharmavie;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AdminChat {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public AdminChat(Socket socket) {

        try {
            this.socket=socket;
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


    public void SendMsgToServer(String MsgToServer)
    {
        try {
            bufferedWriter.write(MsgToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error sending message to server");
            close(socket,bufferedReader,bufferedWriter);
        }
    }

    public void close(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)
    {
        try {
            if (bufferedReader !=null){
                bufferedWriter.close();
            }
            //if we don't check on null it will generate a null pointer exception
            if(bufferedWriter !=null){
                bufferedWriter.close();
            }
            if(socket !=null){
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ReceiveMsgFromServer(VBox vbox) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected())
                {
                    try {
                        String MsgFromServer = bufferedReader.readLine();
                        AdminChatCL.AddLabel(MsgFromServer,vbox);

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error receiving message from Server");
                        close(socket,bufferedReader,bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

}
