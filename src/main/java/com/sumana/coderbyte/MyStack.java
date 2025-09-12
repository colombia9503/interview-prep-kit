package com.sumana.coderbyte;


import java.util.StringJoiner;

public class MyStack {
    public static void main(String[] args) {
        Stack<String>  stack = new Stack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);
    }
}

class StackNode<T> {
    T t;
    StackNode<T> next;

    public StackNode(T t) {
        this.t = t;
        this.next = null;
    }
}

class Stack<T> {
    StackNode<T> top;
    int size;

    Stack() {
        this.top = null;
        this.size = 0;
    }

    void push(T t) {
        if (this.size == 0) {
            this.top = new StackNode<>(t);
        } else {
            StackNode<T> pushedNode = new StackNode<>(t);
            pushedNode.next = top;
            this.top = pushedNode;
        }

        ++this.size;
    }

    T pop() {
        if (size == 0) {
            return null;
        }

        StackNode<T> poppedNode = top;

        this.top = poppedNode.next;
        --this.size;

        return poppedNode.t;
    }

    T peek() {
        if (size == 0) {
            return null;
        }

        return top.t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StackNode<T> curr = this.top;

        while (curr != null) {
            sb.append(curr.t.toString()).append(" ");
            curr = curr.next;
        }

        return sb.reverse().toString();
    }
}