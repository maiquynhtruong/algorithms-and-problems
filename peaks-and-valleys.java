public class Solution {
    5, 6, 3, 1, 2, 4, 6, 7, 8, 5
    5, 6, 1, 3, 2, 6, 4, 8, 5, 7
    5
    public static int[] peaksAndValleys(int[] a) {
        for (int i = 1; i < a.length; i += 2) {
            if (a[i-1] > a[i]) {
                swap(arr, i-1, i);   
            } 
        }
    }
    public static void main(String args[]) {
        
    }
}
