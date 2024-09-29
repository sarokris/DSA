package com.exercise.dsa;

import java.util.Map;
import java.util.function.Predicate;

public class DSATester<T> {

    Map<String,Predicate<T>> assertionMap;

    public DSATester(Map<String,Predicate<T>> assertionMap){
        this.assertionMap = assertionMap;
    }

    public void test(T data){
        this.assertionMap.forEach((k,v) -> System.out.printf(k + "? : %b%n",v.test(data)));
    }

}
