// Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same until end of the linked list. That is, in the given linked list you need to delete N nodes after every M nodes.
// Input format :

// Line 1 : Linked list elements (separated by space and terminated by -1)

// Line 2 : M

// Line 3 : N

// Sample Input 1 :
// 1 2 3 4 5 6 7 8 -1
// 2
// 2
// Sample Output 1 :
// 1 2 5 6
// Sample Input 2 :
// 1 2 3 4 5 6 7 8 -1
// 2
// 3
// Sample Output 2 :
// 1 2 6 7

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
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
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
        printLL(skipMdeleteN(head, m, n));
    }

    public static void printLL(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        LinkedListNode<Integer> trav = head;

        while (trav != null) {
            for (int i = 0; i < M - 1; i++) {
                if (trav == null)
                    break;
                trav = trav.next;
            }
            LinkedListNode<Integer> prevM = trav;

            if (prevM == null)
                return head;

            for (int i = 0; i < N; i++) {
                if (trav == null)
                    break;
                trav = trav.next;
            }

            if (trav != null)
                prevM.next = trav.next;
            else
                prevM.next = null;

            if (prevM.next == null)
                return head;
            trav = trav.next;
        }

        return head;
    }

}
