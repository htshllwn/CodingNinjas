// Check if a given linked list is palindrome or not. Return true or false.
// Indexing starts from 0.
// Input format : Linked list elements (separated by space and terminated by -1)`

// Sample Input 1 :
// 9 2 3 3 2 9 -1
// Sample Output 1 :
// true
// Sample Input 2 :
// 0 2 3 2 5 -1
// Sample Output 2 :
// false

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
        System.out.println(isPalindrome_2(head));
    }

    public static boolean isPalindrome_2(LinkedListNode<Integer> head) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        // String s1 = "";
        // String s2 = "";

        while (head != null) {
            s1.append(head.data);
            // s1 = s1 + head.data;
            // s2 = head.data + s2;
            s2.insert(0, head.data);
            head = head.next;
        }

        return s1.toString().equals(s2.toString());
    }

}
