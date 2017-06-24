public class Solution {
    5, 6, 3, 1, 2, 4, 6, 7, 8, 5
    5, 6, 1, 3, 2, 6, 4, 8, 5, 7
    5
    public static int[] peaksAndValleys(int[] a) {
        for (int i = 1; i < a.length; i += 2) {
            int maxIndex = findMaxIndex(a, i-1, i, i+1);
            if (i != maxIndex) {
                swap(a, i, maxIndex);
            }
        }
    }
    
    public static int findMaxIndex(int[] a, int i, int j, int k) {
        int len = a.length;
        int iVal, jVal, kVal;
        if (0 <= i && i < len) iVal = a[i] else iVal = Integer.MIN_VALUE;
        if (0 <= j && j < len) jVal = a[j] else jVal = Integer.MIN_VALUE;
        if (0 <= k && k < len) kVal = a[k] else kVal = Integer.MIN_VALUE;
        int max = Math.max(iVal, Math.max(jVal, kVal));
        if (max == iVal) return i;
        else if (max == jVal) return j;
        else return k;
    }
    public static void main(String args[]) {
        
    }
}
