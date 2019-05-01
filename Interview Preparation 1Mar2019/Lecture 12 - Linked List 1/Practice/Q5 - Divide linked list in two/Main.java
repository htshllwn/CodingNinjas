
// Write a function that takes one list and divides up its nodes to create two smaller lists A and B. The sub lists should be made from alternating elements in the original list.
// Nodes should be in the reverse order of which they occurred in the source list.
// Print both linked lists in different lines.
// Input format :
// Line 1 : Linked list elements of length n (separated by space and terminated by -1)
// Output format :
// Line 1 : Output Linked List 1 elements (separated by space)
// Line 2 : Output Linked List 2 elements (separated by space)
// Constraints :
// 1 <= n <= 10^4
// Sample Input :
//  8 2 5 9 1 4 3 7 -1
// Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 8.
// Sample Output :
//  3 1 5 8
//  7 4 9 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ListNode<t> {
	public t data;
	 public ListNode<t> next;
	 public ListNode(t data)
	 {
		 this.data=data;
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
        make2List(head);
    }

    public static void make2List(ListNode<Integer> head) {
        ListNode<Integer> list1HEAD = null;
        ListNode<Integer> list2HEAD = null;

        ListNode<Integer> temp = head;

        while (temp != null) {
            ListNode<Integer> tempNode = new ListNode<Integer>(temp.data);
            tempNode.next = list1HEAD;
            list1HEAD = tempNode;

            temp = temp.next;
            if (temp == null)
                break;

            tempNode = new ListNode<Integer>(temp.data);
            tempNode.next = list2HEAD;
            list2HEAD = tempNode;

            temp = temp.next;
        }
        printLL(list1HEAD);
        printLL(list2HEAD);
    }

    public static void printLL(ListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

}
