package com.pitam.lab;

import java.nio.ByteBuffer;

public class Lab9_CompactingBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte)1);
        buffer.put((byte)2);
        buffer.put((byte)3);
        buffer.put((byte)4);
        buffer.put((byte)5);

        buffer.flip();

        System.out.println(buffer.get());
        System.out.println(buffer.get());

        buffer.compact();

        buffer.put((byte)6);
        buffer.put((byte)7);

        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
