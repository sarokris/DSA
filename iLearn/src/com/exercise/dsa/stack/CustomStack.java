package com.exercise.dsa.stack;

public class CustomStack {
    private Node top;
    private int height;

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public CustomStack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if(height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
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
