import java.io.*;
import java.util.*;

class Solution {

  static int deletionDistance(String str1, String str2) {
    int[] charSet1 = new int[27]; // for 26 charcters
      for (int i = 0; i < str1.length(); i++) {
          charSet1[str1.charAt(i) - 'a']++;
      }
    System.out.println(Arrays.toString(charSet1));
    int uniqueTo2 = 0;
    StringBuilder s2 = new StringBuilder(str2);
      for (int i = 0; i < str2.length(); i++) {
          if (charSet1[str2.charAt(i) - 'a'] > 0) {
            charSet1[str2.charAt(i) - 'a']--;
            if (charSet1[str2.charAt(i) - 'a'] == 0){
                uniqueTo2++;
                System.out.print(str2.charAt(i) + " ");
            } 
          }
      }
    System.out.println();
    int[] charSet2 = new int[27];
    for (int i = 0; i < s2.length(); i++) {
          charSet2[str2.charAt(i) - 'a']++;
      }
    int uniqueTo1 = 0;
    StringBuilder s1 = new StringBuilder(str1);
    for (int i = 0; i < str1.length(); i++) {
          if (charSet2[str1.charAt(i) - 'a'] > 0) {
            charSet2[str1.charAt(i) - 'a']--;
            if (charSet2[str1.charAt(i) - 'a'] == 0) {
              uniqueTo1++;
              System.out.print(str1.charAt(i) + " ");
            }
          }
      }
    return str1.length() + str2.length() - uniqueTo1 - uniqueTo2;
}
  

  public static void main(String[] args) {
      String str1 = "some", str2 = "thing";
      System.out.println(deletionDistance(str1, str2));
  }

}
