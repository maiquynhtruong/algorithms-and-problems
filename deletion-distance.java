import java.io.*;
import java.util.*;

class Solution {
    
    static int deletionDistance(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) dp[i][0] = i;
        for (int j = 0; j < str2.length(); j++) dp[0][j] = j;
        for (int i = 0; i < str1.length(); i++)
            for (int j = 0; j < str2.length(); j++)
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j]);
                }
        return dp[str1.length()][str2.length()];
    }
}
  

  public static void main(String[] args) {
      String str1 = "some", str2 = "thing";
      System.out.println(deletionDistance(str1, str2));
  }

}
