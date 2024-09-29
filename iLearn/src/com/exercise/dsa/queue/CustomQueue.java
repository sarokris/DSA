package com.exercise.dsa.queue;

public class CustomQueue {

    Node first;
    Node last;

    int length;

    public CustomQueue(int value){
        Node newNode = new Node(value);
        first = last = newNode;
        length = 1;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0){
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if(length == 0) return null;
        Node temp = first;
        first = first.next;
        temp.next = null;
        length--;
        return temp;
    }


    class Node {
        int value;
       Node next;

        public Node(int value){
            this.value = value;
        }

    }
}
