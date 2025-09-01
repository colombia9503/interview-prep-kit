package com.sumana.leetcode;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode last = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                last.next = list1;
                list1 = list1.next;
            } else  {
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }

        if (list1 != null) last.next = list1;
        if (list2 != null) last.next = list2;


        return head.next;
    }

    public static void main(String[] args) {

    }
}
