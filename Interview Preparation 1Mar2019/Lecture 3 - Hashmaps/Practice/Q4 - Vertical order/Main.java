// Given a binary tree, print that binary tree in vertical order. Vertical order is -

// Print the nodes which are at same vertical order in same line separated by space. Print different levels in different lines.
// Order of different levels in different lines is not important. But in one level, print the element in pre-order format.
// Input Format :
// Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place
// Output Format :
// Required output in given format
// Sample Input :
// 1 2 3 4 5 6 7 -1 8 -1 -1 -1 -1 -1 -1 -1 -1
// Sample Output :
// 7 
// 3 
// 4 
// 2 8 
// 1 5 6 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int []processedArr = processInput(arr);
        BinaryTreeNode<Integer> root = formTree(processedArr, 0);
        // System.out.println("Level Order Traversal:");
        // levelOrderTraversal(root);
        // System.out.println();
        printBinaryTreeVerticalOrder(root);
    }

    public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> visited = new HashMap<>();
        int leftMost = 0, rightMost = 0, mid = 0;
        BinaryTreeNode<Integer> curr = root;
        BinaryTreeNode<Integer> par = null;
        BinaryTreeNode<Integer> tempChild = null;

        while (curr != null) {

            if (visited.containsKey(curr)) {
                if ((curr.left != null && visited.containsKey(curr.left)) || curr.left == null) {
                    // Left Already Visited or not present. Go to right.
                    if ((curr.right != null && visited.containsKey(curr.right)) || curr.right == null) {
                        // Right Already Visited or not present. Go to parent.
                        tempChild = curr;
                        curr = visited.get(curr);
                        if (curr != null) {
                            if (curr.left == tempChild) {
                                mid++;
                            } else if (curr.right == tempChild) {
                                mid--;
                            }
                            par = visited.get(curr);
                        }
                    } else {
                        par = curr;
                        curr = curr.right;
                        mid++;
                        continue;
                    }
                } else {
                    par = curr;
                    curr = curr.left;
                    mid--;
                    continue;
                }
            } else {
                if (map.containsKey(mid)) {
                    map.get(mid).add(curr.data);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(curr.data);
                    map.put(mid, temp);
                }
                if (leftMost > mid) {
                    leftMost = mid;
                }
                if (rightMost < mid) {
                    rightMost = mid;
                }
                visited.put(curr, par);
            }

        }

        for (int i = leftMost; i <= rightMost; i++) {
            for (int v : map.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static BinaryTreeNode<Integer> formTree(int[] arr, int i) {
        if (i >= arr.length)
            return null;
        if (arr[i] < 0)
            return null;
        BinaryTreeNode<Integer> node = new BinaryTreeNode(arr[i]);
        node.left = formTree(arr, 2 * i + 1);
        node.right = formTree(arr, 2 * i + 2);
        // System.out.println(node);
        return node;
    }

    public static int[] processInput(int[] arr) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int v : arr) {
            arrayList.add(v);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) < 0) {
                if (2 * i + 1 < arrayList.size()) {
                    arrayList.add(2 * i + 1, -2);
                }
                if (2 * i + 2 < arrayList.size()) {
                    arrayList.add(2 * i + 2, -2);
                }
            }
        }
        int[] newArr = new int[arrayList.size()];
        return arrayList.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }

    public static void levelOrderTraversal(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /* Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /* Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String res = "";
        res += "node: " + data;
        if (left != null) {
            res += ", left: " + left.data;
        } else {
            res += ", left: -1";
        }
        if (right != null) {
            res += ", right: " + right.data;
        } else {
            res += ", right: -1";
        }
        return res;
    }
}
