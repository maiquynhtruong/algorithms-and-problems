public class Solution {
    public int hammingDistance(int x, int y) {
        int c = 0;
        for (int i = 0; i < 31; i++) {
            int cur = (1 << i);
            if ((x & cur) != (y & cur)) 
                c += 1;
        }
        return c;
    }
}
