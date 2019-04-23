// Given a linked list, i & j, swap the nodes that are present at i & j position in the LL. You need to swap the entire nodes, not just the data.
// Indexing starts from 0. You don't need to print the elements, just swap and return the head of updated LL.
// Assume i & j given will be within limits. And i can be greater than j also.
// Input format :

// Line 1 : Linked list elements (separated by space and terminated by -1)

// Line 2 : i and j (separated by space)

// Sample Input 1 :
// 3 4 5 2 6 1 9 -1
// 3 4
// Sample Output 1 :
// 3 4 5 6 2 1 9
// Sample Input 2 :
// 3 4 5 2 6 1 9 -1
// 2 4
// Sample Output 2 :
// 3 4 6 2 5 1 9

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
        int[] IJ = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int i = IJ[0];
        int j = IJ[1];
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
        printLL(swap_nodes(head, i, j));
    }

    public static void printLL(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head, int i, int j) {
        LinkedListNode<Integer> prev1 = getPrevNode(head, i - 1);
        LinkedListNode<Integer> prev2 = getPrevNode(head, j - 1);
        LinkedListNode<Integer> temp1 = prev1 == null ? head : prev1.next;
        LinkedListNode<Integer> temp2 = prev2 == null ? head : prev2.next;
        // System.out.println("temp1 : " + temp1.data + ", temp2 : " + temp2.data);

        if (prev1 != null)
            prev1.next = temp2;
        if (prev2 != null)
            prev2.next = temp1;

        LinkedListNode<Integer> temp = temp1.next;
        temp1.next = temp2.next;
        temp2.next = temp;

        if (temp1 == head)
            head = temp2;
        else if (temp2 == head)
            head = temp1;

        return head;
    }

    public static LinkedListNode<Integer> getPrevNode(LinkedListNode<Integer> head, int i) {
        if (i == -1)
            return null;
        LinkedListNode<Integer> head1 = head;

        for (int x = 0; x < i; x++) {
            head1 = head1.next;
        }

        return head1;
    }
}
