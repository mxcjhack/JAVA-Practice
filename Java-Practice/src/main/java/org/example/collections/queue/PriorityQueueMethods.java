package org.example.collections.queue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueMethods {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(List.of(1, 2, 4, 3));
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        queue.add(0);
        System.out.println(queue);
    }
}
