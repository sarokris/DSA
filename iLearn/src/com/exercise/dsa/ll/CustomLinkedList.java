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

    public Node get(int index){
        if(index < 0 || index >= length)
            throw new IllegalArgumentException("Index out of bound");
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Method to set value at given index
     * @param index at  which value to be updated
     * @param value that assigned to the Node at given index
     */
    public void set(int index,int value){
        Node node = get(index);
        node.value = value;
    }

    /**
     * Insert a new Node at a given index, it will move the Node if we are adding in the middle of the list
     * @param index at which Node to be inserted if index == length it will be appended at the end
     * @param value to be assigned to the newly inserted Node
     */
    public void insert(int index, int value){
        if(index < 0 || index > length)
            throw new IllegalArgumentException("Index out of bound");
        if(index == 0) {
            addFirst(value);
        }else if(index == length) { // appending at the end
            add(value);
        }else{
            Node newNode = new Node(value);
            // finding previous Node of the intended index
            Node preNode = get(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
            length++;
        }
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

    public void removeFirst(){
        if(length == 0)
            throw new UnsupportedOperationException("LinkedList is empty");
        if(length == 1){
            head = null;
            tail = null;
            length = 0;
        }else {
            head = head.next;
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
