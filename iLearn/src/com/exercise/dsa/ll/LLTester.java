package com.exercise.dsa.ll;

public class LLTester {
    public static void main(String[] args) {
        var customLL = new CustomLinkedList();
        customLL.add(1);
        customLL.add(3);
        customLL.add(2);
        customLL.print();
        System.out.println("Removing the last one");
        customLL.removeLast();
        customLL.print();
        System.out.println("Removing the last one");
        customLL.removeLast();
        customLL.print();
        customLL.addFirst(1);
        customLL.print();
        customLL.addFirst(2);
        System.out.println(" head " + customLL.getHead().getValue());
        System.out.println(" Tail " + customLL.getTail().getValue());
        System.out.println(" Length " + customLL.getLength());

    }
}
