class Solution {
  
  static int bracketMatch(String text) {
    int open = 0, close = 0;
    int res = 0;
    for (int i = 0; i < text.length(); i++) {
        if (text.charAt(i) == '(') {
          if (close > open) {
            res += close - open;
            close = 0;
            open = 0;
          }
          open++;
        } else {
          close++;
        }
    }
    res += Math.abs(close - open);
    return res;
  }

  public static void main(String[] args) {
    String text = "(((";
    System.out.println(bracketMatch(text));
  }

}
