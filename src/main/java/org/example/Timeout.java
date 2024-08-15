package org.example;

public class Timeout {
    public Timeout() {
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep((long)(sec * 1000L));
        } catch (InterruptedException ignored) {
        }

    }
}
