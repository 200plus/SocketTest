package com.study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
         //1、本机9999端口监听
        //细节：要求在本机没有其它服务在监听9999
        //细节：这个ServerSocket 可以通过accept（）返回多个Socket[多个客户端连接]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        //2、当没有客户端连接9999端口时，程序会阻塞,等待连接
        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket="+socket.getClass());

        //3、通过socket.getInputStream()读取 客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        //4、IO读取
        byte [] buff=new byte[1024];
        int readlen=0;
        while((readlen=inputStream.read(buff))!=-1){
            System.out.println(new String(buff,0,readlen));//根据读取的实际长度，显示内容
        }
        //5、关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
