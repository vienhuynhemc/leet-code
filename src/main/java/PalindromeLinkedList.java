package src.main.java;

import src.main.java.model.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        int[] dp = new int[100000];

        int index = 0;
        while (head != null) {
            dp[index++] = head.val;
            head = head.next;
        }

        int mid = index / 2;
        for (int i = 0; i < mid; i++) {
            if (dp[i] != dp[--index]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList handler = new PalindromeLinkedList();
        System.out.println(handler.isPalindrome(new ListNode(4)));
    }

}
