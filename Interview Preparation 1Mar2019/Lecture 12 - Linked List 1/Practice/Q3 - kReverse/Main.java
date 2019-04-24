// Implement kReverse( int k ) in a linked list i.e. you need to reverse first K elements then reverse next k elements and join the linked list and so on.
// Indexing starts from 0. If less than k elements left in the last, you need to reverse them as well. If k is greater than length of LL, reverse the complete LL.
// You don't need to print the elements, just return the head of updated LL.
// Input format :

// Line 1 : Linked list elements (separated by space and terminated by -1)

// Line 2 : k

// Sample Input 1 :
// 1 2 3 4 5 6 7 8 9 10 -1
// 4
// Sample Output 1 :
// 4 3 2 1 8 7 6 5 10 9
// Sample Input 2 :
// 1 2 3 4 5 -1
// 2
// Sample Output 2 :
// 2 1 4 3 5 
// Sample Input 3 :
// 1 2 3 4 5 6 7 -1
// 3
// Sample Output 3 :
// 3 2 1 6 5 4 7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(reader.readLine());
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> prev = head;
        for (int v : arr) {
            if (v == -1)
                break;
            LinkedListNode<Integer> nextNode = new LinkedListNode(v);
            if (prev != null)
                prev.next = nextNode;
            prev = nextNode;
            if (head == null)
                head = prev;
        }
        printLL(kReverse(head, k));
    }

    public static void printLL(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> tempHead = null;
        LinkedListNode<Integer> tempTail = null;
        LinkedListNode<Integer> prevTail = null;
        LinkedListNode<Integer> res = null;
        LinkedListNode<Integer> trav = head;

        while (trav != null) {
            for (int i = 0; i < k; i++) {
                if (trav == null)
                    break;
                if (tempHead == null) {
                    tempHead = new LinkedListNode<Integer>(trav.data);
                    tempTail = tempHead;
                } else {
                    LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(trav.data);
                    newNode.next = tempHead;
                    tempHead = newNode;
                }
                trav = trav.next;
            }
            if (res == null)
                res = tempHead;
            if (prevTail != null)
                prevTail.next = tempHead;
            tempHead = null;
            prevTail = tempTail;
        }

        return res;

    }
}