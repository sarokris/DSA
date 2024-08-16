package com.exercise.dsa.ll;

public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public void add(int value) {
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
        }else{
            //append the new node to end/next of the current tail
            tail.next = newNode;
        }
        // replace the current tail with new one
        tail = newNode;
        length++;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    class Node {

        Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
