package com.pitam.lab;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

// Lab 8: Create a buffer of 18 bytes, fill with character data,
//        and display position, limit, and capacity.
public class Lab8_BufferCreation {
    public static void main(String[] args) {
        // Create a buffer of 18 bytes
        ByteBuffer buffer = ByteBuffer.allocate(18);

        System.out.println("=== After Allocation ===");
        System.out.println("Position : " + buffer.position());
        System.out.println("Limit    : " + buffer.limit());
        System.out.println("Capacity : " + buffer.capacity());

        // Fill with character data (18 characters = 18 bytes in ASCII)
        String data = "Hello, ByteBuffer!";
        byte[] bytes = data.getBytes(StandardCharsets.US_ASCII);
        buffer.put(bytes);

        System.out.println("\n=== After Filling with \"" + data + "\" ===");
        System.out.println("Position : " + buffer.position());
        System.out.println("Limit    : " + buffer.limit());
        System.out.println("Capacity : " + buffer.capacity());

        // Flip to read mode
        buffer.flip();

        System.out.println("\n=== After flip() (ready to read) ===");
        System.out.println("Position : " + buffer.position());
        System.out.println("Limit    : " + buffer.limit());
        System.out.println("Capacity : " + buffer.capacity());

        // Read back the data
        byte[] readBack = new byte[buffer.limit()];
        buffer.get(readBack);
        System.out.println("\nData read from buffer: " + new String(readBack, StandardCharsets.US_ASCII));
    }
}