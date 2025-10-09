package com.sumana.neetcode250.myhashmap;


public class MyHashMap<K, V> {

    private final ListNode<K, V>[] arr;

    public MyHashMap() {
        arr = new ListNode[10^3];
        initArray();
    }

    private void initArray() {
        for (int i = 0; i < this.arr.length; i++) {
            arr[i] = new ListNode<>(null, null);
        }
    }

    public void put(K key, V value) {
        int hashIndex = key.hashCode() % arr.length;
        ListNode<K, V> node = arr[hashIndex];

        while (node.next != null) {
            if (node.next.k.equals(key)) {
                node.next.v = value;
                return;
            }
            node = node.next;
        }

        node.next = new ListNode<>(key, value);
    }

    public V get(K key) {
        int hashIndex = key.hashCode() % arr.length;
        ListNode<K, V> node = arr[hashIndex];

        while (node != null) {
            if (node.k.equals(key)) {
                return node.v;
            }

            node = node.next;
        }

        return null;
    }

    public void remove(K key) {
        int hashIndex = key.hashCode() % arr.length;
        ListNode<K, V> node = arr[hashIndex];

        while (node != null && node.next != null) {
            if (node.next.k.equals(key)) {
                node.next = node.next.next;
                return;
            }

            node = node.next;
        }
    }
}

class ListNode<K, V> {
    K k;
    V v;
    ListNode<K, V> next;
    ListNode(K k, V v) {
        this.k = k;
        this.v = v;
        this.next = null;
    }
}