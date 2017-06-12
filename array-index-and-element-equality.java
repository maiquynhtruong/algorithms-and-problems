import java.io.*;
import java.util.*;

class Solution {
  
  static int indexEqualsValueSearch(int[] arr) {
      int left = 0, right = arr.length-1;
      while( left < right) {
          int mid = left + (right - left) / 2;
          if (arr[mid] == mid) {
              return mid;
          } else if (arr[mid] > mid) {
              right = mid;
          } else {
              left = mid+1;
          }
      }
    return -1;
  }

  public static void main(String[] args) {
      int[] arr = {-1, 0, 2, 6, 7, 8, 9, 10};
      System.out.println(indexEqualsValueSearch(arr));
  }

}
