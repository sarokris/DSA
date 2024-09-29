package com.exercise.dsa.stack;

import com.exercise.dsa.DSATester;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CustomStackTester {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(10);
        testSizeAndTop(1,10,stack);
        stack.push(20);
        testSizeAndTop(2,20,stack);
        CustomStack.Node poppedNode = stack.pop();
        System.out.printf("popped value "+poppedNode.value+"? : %b \n",poppedNode.value == 20);
        testSizeAndTop(1,10,stack);
        CustomStack.Node poppedNode1 = stack.pop();
        System.out.printf("popped value "+poppedNode1.value+"? : %b \n",poppedNode.value == 20);
    }

    static void testSizeAndTop(int size,int top,CustomStack stack){
        Map<String, Predicate<CustomStack>> assertionMap = new HashMap<>();
        assertionMap.put("Is stack size " + size, x -> x.getHeight() == size);
        assertionMap.put("is Top is "+top,x->x.getTop().value == top);
        new DSATester<>(assertionMap).test(stack);
    }


}
