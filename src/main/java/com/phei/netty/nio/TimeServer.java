package com.phei.netty.nio;

import com.phei.netty.bio.TimeServerHandler;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zangyaoyi on 2018/1/16.
 */
public class TimeServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            Socket socket = null;
            TimeServerHandlerExecutePool timeServerHandlerExecutePool = new TimeServerHandlerExecutePool(50,10000);
            while (true) {
                socket = serverSocket.accept();
                timeServerHandlerExecutePool.executorService(new TimeServerHandler(socket));
            }
        } finally {
            if (serverSocket != null) {
                System.out.println("The Time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
