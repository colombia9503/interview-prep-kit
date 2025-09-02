package com.sumana.coderbyte;

public class MyLinkedList {
    private static Integer sumList(Node<Integer> head) {
        if (head == null) {
            return 0;
        }

        return head.t + sumList(head.next);
    }

    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();

        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");

        System.out.println(myList);
        System.out.println("--- reversed ---");
        myList.reverse();
        System.out.println(myList);

        System.out.println(myList.contains("a"));
        System.out.println(myList.contains("c"));
        System.out.println(myList.contains("43"));

        LinkedList<Integer> myIntList = new LinkedList<>();
        myIntList.add(1);
        myIntList.add(2);
        myIntList.add(10);
        myIntList.add(3);
        System.out.println(myIntList);

        System.out.println(sumList(myIntList.head));

        myIntList.delete(11);
        System.out.println(myIntList);
        System.out.println(myIntList.head.t);
    }
}

class Node<T> {
    T t;
    Node<T> next;

    public Node(T t) {
        this.t = t;
        this.next = null;
    }
}

class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        head = null;
    }

    void add(T t) {
        if (head == null) {
            head = new Node<>(t);
            return;
        }

        addRecursiveHelper(this.head, t);
    }

    private void addRecursiveHelper(Node<T> node, T t) {
        if (node.next == null) {
            node.next = new Node<>(t);
            return;
        }

        addRecursiveHelper(node.next, t);
    }

    boolean contains(T t) {
        return containsRecursiveHelper(this.head, t);
    }

    private boolean containsRecursiveHelper(Node<T> node, T t) {
        if (node == null) {
            return false;
        }

        if (node.t.equals(t)) {
            return true;
        }

        return containsRecursiveHelper(node.next, t);
    }

    @Override
    public String toString() {
        return toStringHelper(this.head);
    }

    private String toStringHelper(Node<T> node) {
        if (node == null) {
            return "";
        }

        return node.t.toString() + " -> " + toStringHelper(node.next);
    }

    // iterative solution
//    public boolean delete(T t) {
//        Node<T> curr = this.head;
//        Node<T> prev = null;
//
//        while (curr != null) {
//            if (curr.t.equals(t)) {
//                if (prev != null) {
//                    prev.next = curr.next;
//                } else {
//                    this.head = curr.next;
//                }
//                return true;
//            }
//            prev = curr;
//            curr = curr.next;
//        }
//
//        return false;
//    }

    // recursive solution
    boolean delete(T t) {
        return deleteHelper(t, null, this.head);
    }

    private boolean deleteHelper(T t, Node<T> previous, Node<T> current) {
        if (current == null) {
            return false;
        }

        if (current.t.equals(t)) {
            if (previous == null) {
                this.head = current.next;
            } else {
                previous.next = current.next;
            }
            return true;
        }

        return deleteHelper(t, current, current.next);
    }

    //iterative solution
//    void reverse() {
//        Node<T> current = head;
//        Node<T> prev = null;
//
//        while (current != null) {
//            Node<T> next = current.next;
//            current.next = prev;
//
//            prev = current;
//            current = next;
//        }
//
//        this.head = prev;
//    }

    //recursive solution
    void reverse() {
        this.head = reverseHelper(this.head, null);
    }

    Node<T> reverseHelper(Node<T> curr, Node<T> prev) {
        if (curr == null) {
            return prev;
        }

        Node<T> next = curr.next;
        curr.next = prev;

        return reverseHelper(next, curr);
    }
}
