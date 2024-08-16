package com.exercise.dsa.ll;

public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Method to append the values to the tail of the LinkedList
     * @param value
     */
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
        if(length == 0)
            throw new UnsupportedOperationException("LinkedList is empty");
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void removeLast(){
        if(length == 0)
            throw new UnsupportedOperationException("LinkedList is empty");
        if(length == 1){
            head = null;
            tail = null;
            length = 0;
        }else {
            Node temp = head;
            Node pre = head;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
            length--;
        }
    }

    /**
     * Add the value to the head of the LinkedList
     * @param value
     */
    public void addFirst(int value){
        Node newHead = new Node(value);
        if(length == 0){
            head = newHead;
            tail = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        length++;
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
