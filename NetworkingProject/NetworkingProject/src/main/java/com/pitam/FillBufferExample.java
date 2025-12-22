package com.pitam;

import java.nio.CharBuffer;

public class FillBufferExample {
    public static void main(String[] args) {
            CharBuffer charBuffer = CharBuffer.allocate(10);
            charBuffer.put("H");
            charBuffer.put("E");
            charBuffer.put("L");
            charBuffer.put("L");
            charBuffer.put("O");
            System.out.println("After filling: ");
            System.out.println("Position: " + charBuffer.position());
            System.out.println("Limit: " + charBuffer.limit());
            System.out.println("Capacity: " + charBuffer.capacity());


    }
}
