url: https://www.overstock.com/-/-/9076580/product.html
make a function that returns the price of a product given its id (9076580 above)

import urllib2
from bs4 import BeautifulSoup

def getPrice(url) {
  f = urllib2.open(url)
  text = f.read()
  soup = BeautifulSoup(text)
  price = soup.find('span', {'class':'monetary-price-value'}).text
  print price
}

-----

func(board)->board
if cell was alive:
  still alive if it has 2 or 3 living neighbors
  otherwise dead
if cell was dead:
  alive if it has 3 living neighbors
  otherwise dead
  
public static void main(String args[]) {
  int board[][] = new int[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      int aliveNeighbors = 0;
      if (insideBoard(i, j)) {
        for (int k = j-1; k < j++) {
          if (board[i-1][k]) aliveNeighbors++;
          if (board[i+1][k]) aliveNeighbors++;
        }
        if (board[i][j-1]) aliveNeighbors++;
        if (board[i][j+1]) aliveNeighbors++;
        if (board[i][j] == 1) {
         if (aliveNeigbhbors == 2 || aliveNeigbhbors == 3) 
          board[i][j] = 1;
        else
          board[i][j] = 0;
        } else {
        }
        else board[i][j] = 0;
      } else {
        if (i == 0 || i == n-1)
      }
        
    }
  }
}