package com.study.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketTCP01client {
    public static void main(String[] args) throws IOException {
        //思路
        //1、连接服务端(ip,端口)
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端 socket返回="+socket.getClass());

        //2、连接上后 生成Socket，通过Socket。getOutputStream（）
        //得到饿socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3、通过输出流，写入数据到数据通道
        outputStream.write("hello, server".getBytes(StandardCharsets.UTF_8));
        //4、关闭流对象和socket必须关闭

        outputStream.close();
        socket.close();
        System.out.println("客户端退出......");
    }
}
