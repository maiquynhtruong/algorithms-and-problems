import java.io.*;
import java.util.*;

class Solution {
	
  static int findBusiestPeriod(int[][] data) {
      int maxTimestamp = 0;
      int currTime = data[0][0];
      int maxVisitors = -1;
      int currVisitors = data[0][2] == 1 ? data[0][1] : -data[0][1];
      for (int i = 1; i < data.length; i++) {
          if (data[i][0] == currTime) {
              currVisitors += data[i][2] == 1 ? data[i][1] : -data[i][1];
          } else {
              if (currVisitors > maxVisitors) {
                  maxVisitors = currVisitors;
                  maxTimestamp = currTime;
              }
              currVisitors += data[i][2] == 1 ? data[i][1] : -data[i][1];
              currTime = data[i][0];
          }
      }
        if (currVisitors > maxVisitors) {
                  maxVisitors = currVisitors;
                  maxTimestamp = currTime;
              }
      return maxTimestamp;
  }

  public static void main(String[] args) {
    
      int[][] data = new int[][]
                    {{1, 4, 1},
                     {2, 10, 1},
                     {2, 10, 0}};
/**      int[][] data = new int[][] 
                 {{1487799425, 14, 1}, 
                  {1487799425, 4,  0},
                  {1487799425, 2,  0},
                  {1487800378, 10, 1},
                  {1487801478, 18, 0},
                  {1487801478, 18, 1},
                  {1487901013, 1,  0},
                  {1487901211, 7,  1},
                  {1487901211, 7,  0} }; **/
    int res = findBusiestPeriod(data);
    System.out.println(res);
  }

}
