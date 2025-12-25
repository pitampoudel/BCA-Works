package com.pitam;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class ChannelClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 5000));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("Hello".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        buffer.clear();

        socketChannel.read(buffer);
        buffer.flip();

        System.out.println("Server says: " + new String(buffer.array(), 0, buffer.limit()));
        socketChannel.close();

    }
}


class ChannelServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(5000));
        System.out.println("Server started at : " + 5000);

        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.read(buffer);

        buffer.flip();
        String str = new String(buffer.array(), 0, buffer.limit());
        System.out.println("Client says: " + str);
        socketChannel.close();
        serverSocketChannel.close();



    }

}