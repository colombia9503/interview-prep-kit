package com.sumana.neetcode250.myhashset;

public class MyHashSet<T> implements IMyHashSet<T> {
    //Notes: usually to create a new data structure, we use the others, it's not like you create it from scratch

    private ListNode<T>[] arr;

    public MyHashSet() {
        this.arr = new ListNode[10^4];
        initArray();
    }

    private void initArray() {
        for (int i = 0; i < this.arr.length; i++) {
            arr[i] = new ListNode<>(null);
        }
    }

    @Override
    public void add(T key) {
        int index = key.hashCode() % arr.length;
        ListNode<T> node = arr[index];

        while (node.next != null) {
            if (node.next.t.equals(key)) {
                System.out.println("collision");
                return;
            }
            node = node.next;
        }

        node.next = new ListNode<>(key);

    }

    @Override
    public void remove(T key) {
        int index = key.hashCode() % arr.length;
        ListNode<T> node = arr[index];

        while (node.next != null) {
            if (node.next.t.equals(key)) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    @Override
    public boolean contains(T key) {
        int index = key.hashCode() % arr.length;
        ListNode<T> node = arr[index];

        while (node.next != null) {
            if (node.next.t.equals(key)) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    public void print() {
        for (ListNode<T> tListNode : arr) {
            ListNode<T> node = tListNode;
            while (node.next != null) {
                System.out.println(node.next.t.toString());
                node = node.next;
            }
        }
    }
}

class ListNode<T> {
    T t;
    ListNode<T> next;
    ListNode(T t) {
        this.t = t;
        this.next = null;
    }
}
