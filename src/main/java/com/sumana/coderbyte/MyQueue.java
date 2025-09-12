package com.sumana.coderbyte;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class MyQueue {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();

        queue.add("a");
        queue.add("b");
        queue.add("c");

        System.out.println(queue);

        queue.poll();

        System.out.println(queue);
    }
}
