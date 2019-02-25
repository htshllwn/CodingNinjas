// Given an unsorted array of numbers, 
// write a function that returns true 
// if complete array consists of consecutive numbers. 
// That means if we sort the array, 
// all the elements are consecutive. 
// Array contains only positive numbers.
// Try doing it in O(n), 
// where n is the size of given array.
// Input Format :
// Line 1 : An Integer N i.e. size of array
// Line 2 : N integers which are elements of 
// the array, separated by spaces
// Output Format :
// true or false
// Constraints :
// 1 <= N <= 10^6
// Sample Input 1 :
// 6
// 3 7 2 5 4 6
// Sample Output 1 :
// true
// Sample Input 2 :
// 6
// 1 9 2 4 0 3
// Sample Output 2 :
// false

class Main {
    public static void main(String[] args) {
        int[] arr1 = { 3, 7, 2, 5, 4, 6 };
        int[] arr2 = { 1, 9, 2, 4, 0, 3 };

        System.out.println(containsConsecutiveNumbers(arr1));
        System.out.println(containsConsecutiveNumbers(arr2));
    }

    public static boolean containsConsecutiveNumbers(int[] input) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : input) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        int[] counts = new int[max - min + 1];
        for (int num : input) {
            counts[num - min]++;
        }
        for (int c : counts) {
            if (c != 1) return false;
        }
        return true;
    }
}
