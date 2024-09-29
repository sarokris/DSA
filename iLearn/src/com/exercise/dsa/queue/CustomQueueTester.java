package com.exercise.dsa.queue;

import com.exercise.dsa.DSATester;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public class CustomQueueTester {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(10);
        testSizeAndTop(1,10,queue);
        testLast(10,queue.getLast().value);
        testIsNextNodeNull(queue.getFirst());
        queue.enqueue(20);
        testSizeAndTop(2,10,queue);
        testLast(20,queue.getLast().value);
        testIsNextNodeNull(queue.getLast());
        queue.enqueue(30);
        testSizeAndTop(3,10,queue);
        testLast(30,queue.getLast().value);
        testIsNextNodeNull(queue.getLast());
        CustomQueue.Node dequeued = queue.dequeue();
        testSizeAndTop(2,20,queue);
        testLast(30,queue.getLast().value);
        testIsNextNodeNull(dequeued);
        CustomQueue.Node dequeued1 = queue.dequeue();
        testSizeAndTop(1,30,queue);
        testLast(30,queue.getLast().value);
        testIsNextNodeNull(dequeued1);
    }

    private static void testIsNextNodeNull(CustomQueue.Node first) {
        System.out.printf("is Next Node null: %b\n",first.next == null);
    }

    static void testSizeAndTop(int length, int first, CustomQueue queue){
        Map<String, Predicate<CustomQueue>> assertionMap = new HashMap<>();
        assertionMap.put("Is queue length " + length, x -> x.getLength() == length);
        assertionMap.put("is First is "+first,x->x.getFirst().value == first);
        new DSATester<>(assertionMap).test(queue);
    }

    static void testLast(int expectedValue,int actual){
        System.out.printf("is Last %d ? : %b\n",expectedValue,expectedValue == actual);
    }
}
