public class Solution {
    ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
    public void generateSubset(String binary, ArrayList<Integer> set, int index, ArrayList<Integer> curSet) {
        if (index == binary.length()) {
            powerSet.add(curSet);
        } else {
            curSet.add(set.get(index));
            generateSubset(binary, set, index+1, curSet);
            binary.charAt(index) = '1';
            curSet.add(set.get(index));
            generateSubset(binary, set, index+1, curSet);
        }
    }
    public static void main(String args[]) {
        
    }
}
