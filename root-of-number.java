public class Solution {
    public static double exponent(int n, double num) {
        double res = 1;
        for (int i = 0; i < n; i++) res *= num;
    }
    public static double findNRoot(int x, int n) {
        double left = 0, right = x;
        double mid;
        while (right - left > 0.001) {
            mid = left + (right - left) / 2;
            double res = exponent(n, mid);
            if (res < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mid;
    }
    public static void main(String args[]) {
        int x = 7, n = 3;
        System.out.println(findNRoot(x, n));
    }
}
