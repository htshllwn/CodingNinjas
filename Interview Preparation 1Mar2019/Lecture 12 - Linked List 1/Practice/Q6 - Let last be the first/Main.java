
// Write a function that moves last element to front in a given singly Linked List.
// For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.
// You just need to return the head of new linked list, don't print the elements.
// Input format :
// Line 1 : Linked list elements of length n (separated by space and terminated by -1)
// Output format :
// Updated list elements (separated by space)
// Constraints :
// 1 <= n <= 10^4
// Sample Input :
//  1 2 3 4 5 6 -1
// Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 6.
// Sample Output :
//  6 1 2 3 4 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ListNode<t> {
    public t data;
    public ListNode<t> next;

    public ListNode(t data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        ListNode<Integer> head = null;
        ListNode<Integer> prev = head;
        for (int v : arr) {
            if (v == -1)
                break;
            ListNode<Integer> nextNode = new ListNode(v);
            if (prev != null)
                prev.next = nextNode;
            prev = nextNode;
            if (head == null)
                head = prev;
        }
        printLL(lastToFront(head));
    }

    public static void printLL(ListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode<Integer> lastToFront(ListNode<Integer> head) {
        ListNode<Integer> trav = head;
        ListNode<Integer> prev = null;
        while (trav.next != null) {
            prev = trav;
            trav = trav.next;
        }

        prev.next = null;
        trav.next = head;

        return trav;

    }
}
