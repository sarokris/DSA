package com.exercise.dsa.ll;

public class DLLTester {
    public static void main(String[] args) {
        CustomDoubleLinkedList cDll = new CustomDoubleLinkedList();
        //print empty list
        cDll.print();
        // append value
        cDll.append(1);
        cDll.append(2);
        cDll.append(3);
        //printing the element after appending
        cDll.print();
        //printing tail and head
        System.out.format("Head : %d, Tail : %d, Length:%d",cDll.getHead().getValue(),cDll.getTail().getValue(),cDll.getLength());
    }
}
