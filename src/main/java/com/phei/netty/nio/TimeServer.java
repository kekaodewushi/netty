package com.phei.netty.nio;

import java.net.ServerSocket;

/**
 * Created by zangyaoyi on 2018/1/16.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        ServerSocket serverSocket = null;
    }
}
