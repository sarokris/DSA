package com.exercise.dsa.ll;

public class CustomDoubleLinkedList {
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

    public void print() {
        if (length == 0) System.out.println("Empty list");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        length++;
    }

    public void addFirst(int value){
        Node newHead = new Node(value);
        if(length == 0){
            head = newHead;
            tail = newHead;
        }else{
            newHead.next = head;
            head.previous = newHead;
            head = newHead;
        }
        length++;
    }

    public Node removeFirst(){
        if(head == null) return null;
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            Node newHead = head.next;
            head.next = null;
            head = newHead;
        }
        length--;
        return temp;
    }

    public Node removeLast(){
        if(length == 0) return null;
        Node toBeRemoved = tail;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            Node newTail = toBeRemoved.previous;
            toBeRemoved.next = null;
            newTail.next = null;
            tail = newTail;
        }
        length--;
        return toBeRemoved;
    }

    public Node get(int index){
        if(index < 0 || index >=length) return null;
        if(index == 0) return head;
        if(index == length -1) return tail;
        Node temp = head;
        if(index < length/2){
            for (int i = 0; i < index; i++) {
                temp= temp.next;
            }
        }else{
            temp = tail;
            for (int i = length - 1 ; i > index ; i--) {
                temp=temp.previous;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index,int value){
        if(index < 0 || index >length) return false;
        if(index == 0){
            addFirst(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node prevNode = get(index - 1);
        Node nextNode = prevNode.next;

        newNode.previous = prevNode;
        newNode.next = nextNode;

        prevNode.next = newNode;
        nextNode.previous = newNode;
        length++;
        return true;

    }

    class Node {
        private Node next;
        private Node previous;

        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
