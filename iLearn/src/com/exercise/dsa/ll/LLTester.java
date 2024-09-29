package com.exercise.dsa.ll;

public class LLTester {
    public static void main(String[] args) {
        var customLL = new CustomLinkedList();
        customLL.add(1);
        customLL.add(3);
        customLL.add(2);
        customLL.print();
        System.out.println(" Length " + customLL.getLength());
        System.out.println("Removing the last one");
        customLL.removeLast();
        System.out.println(" Length " + customLL.getLength());
        customLL.print();
        System.out.println("Removing the last one");
        customLL.removeLast();
        customLL.print();
        customLL.addFirst(1);
        customLL.print();
        customLL.addFirst(2);
        System.out.println("Printing after addFirst");
        customLL.print();
        System.out.println(" head " + customLL.getHead().getValue());
        System.out.println(" Tail " + customLL.getTail().getValue());
        System.out.println(" Length " + customLL.getLength());
        customLL.removeFirst();
        System.out.println(" head " + customLL.getHead().getValue());
        System.out.println(customLL.get(customLL.getLength()-1).getValue());
        customLL.set(customLL.getLength() -1, 5);
        System.out.println("printing after setting");
        customLL.insert(customLL.getLength(), 8);
        customLL.print();
        customLL.insert(1,2);
        customLL.set(customLL.getLength()-1, 6);
        System.out.println("printing favourite number");
        customLL.print();

        customLL.removeAll();
        System.out.println("Adding new elements");

        customLL.add(1);
        customLL.add(2);
        customLL.add(3);
        customLL.add(4);
        customLL.print();
        System.out.println("reversing");
        customLL.reverse();
        customLL.print();

        System.out.println("middle node :"+customLL.findMiddle().getValue());
        customLL.removeLast();
        System.out.println("middle node :"+customLL.findMiddle().getValue());
        customLL.removeLast();
        System.out.println("middle node :"+customLL.findMiddle().getValue());

        customLL.add(2);
        customLL.add(1);
        customLL.print();
        //edge case when finding the tail
        if(customLL.findKthFromEnd(1).getValue() == 1){
            System.out.println("success");
        }

        //edge case when finding the head
        if(customLL.getHead().getValue() == customLL.findKthFromEnd(customLL.getLength()).getValue()){
            System.out.println("Finding the head node success");
        }

        customLL.removeAll();

//        Example 1:
//
//        Input:
//
//        Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5
//
//        Process:
//
//        Values less than 5: 3, 2, 1
//
//        Values greater than or equal to 5: 8, 5, 10
//
//        Output:
//
//        Linked List: 3 -> 2 -> 1 -> 8 -> 5 -> 10  // relative path should be maintained thats why 8 still previous for 5




        customLL.add(3);
        customLL.add(8);
        customLL.add(5);
        customLL.add(10);
        customLL.add(2);
        customLL.add(1);

        customLL.partitionList(5);
        customLL.print();

    }
}
