package com.exercise.dsa.ll;

import java.util.StringJoiner;

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
     * @param value that will be appended at the tail node
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

    public void remove(int index){
        if(index < 0 || index > length)
            throw new IllegalArgumentException("Index out of bound");
        if(index == 0) {
            removeFirst();
        }else if(index == length - 1){
            removeLast();
        }else{
            Node prevNode = get(index - 1);
            Node temp = prevNode.next;
            prevNode.next = temp.next;
            length--;
        }

    }


    public void removeAll(){
        head = null;
        tail = null;
        length = 0;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }

    public void print(){
        if(length == 0)
            throw new UnsupportedOperationException("LinkedList is empty");
        Node temp = head;
        StringJoiner joiner = new StringJoiner(" -> ");
        while(temp != null){
            joiner.add(String.valueOf(temp.value));
            temp = temp.next;
        }
        System.out.println(joiner);
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

    /**
     * it finds the middle node without using the length
     * @return the middleNode
     *  When the linked list has an odd number of nodes, like 1 -> 2 -> 3 -> 4 -> 5, the function will find the exact middle node.
     *  In this case, it will return the node containing the value 3.
     *  For example, if the linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, the two middle nodes are 3 and 4.
     *  The function will return the node containing the value 4.
     *
     */
    public Node findMiddle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * find kth Node from the End without using the length from the LinkedList;
     * @param k
     * @return
     */
    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }

    public void partitionList(int x){
        if(head == null) return;
        Node current = head;
        Node lowerNodes = new Node(0);
        Node higherNodes = new Node(0);

        Node prev1 = lowerNodes;
        Node prev2 = higherNodes;

        while(current != null){
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            }else{
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
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
