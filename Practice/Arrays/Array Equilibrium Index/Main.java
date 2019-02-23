// Find and return the equilibrium index of an array. 
// Equilibrium index of an array is an index i 
// such that the sum of elements at indices less 
// than i is equal to the sum of elements at 
// indices greater than i.
// Element at index i is not included in either part.
// If more than one equilibrium index is present, 
// you need to return the first one. 
// And return -1 if no equilibrium index is present.
// Input format :
// Line 1 : Size of input array
// Line 2 : Array elements (separated by space)
// Sample Input :
// 7
// -7 1 5 2 -4 3 0
// Sample Output :
// 3

class Main {
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(arrayEquilibrium(arr));
    }

    // arr is the given array in which you need to find the equilibrium index
    public static int arrayEquilibrium(int[] arr) {
        // write your code here
        int[] countArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            countArr[i] = arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        int fullSum = countArr[countArr.length - 1];
        for (int i = 1; i < arr.length - 1; i++) {
            int leftSum = countArr[i - 1];
            int rightSum = fullSum - countArr[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}
