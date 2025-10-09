package com.sumana.neetcode250.myhashset;

public class HashSetMain {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "a";

        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add(a);
        myHashSet.add(b);
        myHashSet.add(c);

        myHashSet.remove(b);

        System.out.println(myHashSet.contains(a));
        System.out.println(myHashSet.contains(b));
        System.out.println(myHashSet.contains(c));

        myHashSet.print();
    }
}
