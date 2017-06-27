/** Stack of n boxes, widths w[i], heights h[i], and depths d[i]. The boxes can be stacked on top of another if each box in the stack is 
strictly larger than the box above it in width, height, and depth. Implement a method to compute the height of the tallest
possible stack. Height of a stack is the sum of the heights of each box */

public class Solution {
    public void stackBoxes(int[][] boxes) {
        Arrays.sort(boxes, new Comparator<Integer>() {
            public int compare(int[] box1, int[] box2) {
                return box1[1] - box2[1];
            }
        });
        int heightMap[] = new int[boxes.length];
        int h = 0;
        for (int i = 0; i < boxes.length; i++) {
            int h = createStacks(boxes, i);
            maxH = Math.max(maxH, h);
        }
        return maxH;
    }
    public int createStacks(int[][] boxes, int index, int[] heightMap) {
        if (heightMap[index] > 0 && index < boxes.length) return heightMap[index];
        int[] bottom = boxes[index];
        int maxH = 0;
        for (int i = index, i < boxes.length; i++) {
            if (canBeAbove(boxes, index, i)) {
                int h = createStacks(boxes, i, heightMap);
                maxH = Math.max(maxH, h);
            }
        }
        maxH = maxH + bottom[1];
        heightMap[index] = maxH;
        return maxH;
    }
    public static void main (String args[]) {
        
    }
}
