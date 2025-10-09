package com.sumana.neetcode250.myhashmap;

public class MyHashMapMain {

    public static void main(String[] args) {
        MyHashMap<String, Integer> obj = new MyHashMap<>();
        obj.put("a", 1);
        obj.put("b", 1);
        obj.put("c", 1);

        Integer res = obj.get("a");
        System.out.println(res);

        obj.remove("a");

        Integer res1 = obj.get("a");
        System.out.println(res1);



    }
}
