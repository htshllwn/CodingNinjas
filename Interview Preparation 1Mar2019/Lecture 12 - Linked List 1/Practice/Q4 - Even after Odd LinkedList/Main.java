// Arrange elements in a given Linked List such that, all even numbers are placed after odd numbers. Respective order of elements should remain same.
// You don't need to print the elements, instead return the head of updated LL.
// Input format : Linked list elements (separated by space and terminated by -1)`

// Sample Input 1 :
// 1 4 5 2 -1
// Sample Output 1 :
// 1 5 4 2 
// Sample Input 2 :
// 1 11 3 6 8 0 9 -1
// Sample Output 2 :
// 1 11 3 9 6 8 0

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
        LinkedListNode<Integer> res = sortEvenOdd(head);
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
        System.out.println();
    }

    public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> evenLL = null;
        LinkedListNode<Integer> oddLL = null;
        LinkedListNode<Integer> evenLLtrav = null;
        LinkedListNode<Integer> oddLLtrav = null;
        while (temp != null) {
            int tempData = temp.data;
            if (tempData % 2 == 0) {
                if (evenLL == null) {
                    evenLL = new LinkedListNode(tempData);
                    evenLLtrav = evenLL;
                } else {
                    evenLLtrav.next = new LinkedListNode(tempData);
                    evenLLtrav = evenLLtrav.next;
                }
            } else {
                if (oddLL == null) {
                    oddLL = new LinkedListNode(tempData);
                    oddLLtrav = oddLL;
                } else {
                    oddLLtrav.next = new LinkedListNode(tempData);
                    oddLLtrav = oddLLtrav.next;
                }
            }
            temp = temp.next;
        }

        if (evenLL == null)
            return oddLL;
        if (oddLL == null)
            return evenLL;

        temp = oddLL;
        while (temp.next != null)
            temp = temp.next;
        temp.next = evenLL;
        return oddLL;
    }
}
