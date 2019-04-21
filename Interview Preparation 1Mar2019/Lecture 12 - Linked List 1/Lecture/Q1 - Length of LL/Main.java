// Given a linked list, find and return the length of input LL. Do it iteratively.
// Input format :
// Linked list elements (separated by space and terminated by -1)
// Output format :
// Length of LL
// Sample Input :
// 3 4 5 2 6 1 9 -1
// Sample Output :
// 7

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
        System.out.println(length(head));
    }

    public static int length(LinkedListNode<Integer> head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
