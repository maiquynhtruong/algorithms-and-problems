public class Solution {
    public class Cell {
        public CellType type;
        public boolean flagged;
    }
    public class Player {
        int score;
    }
    public class Game {
        int row, col;
        char[][] cells = new char[row][col];
        /**
        * Using some random method to select a cell to place bomb. Two cases: Either the cell is available 
        * and we can place the bomb or it is taken and we need to place somewhere else
        * Shuffling method: Place k bombs in the first k cells and shuffle all the cells around
        * Shuffling an array operates by iterating through the array from i = 0 through N-1. For each i, we
        * pick a random index between i and N-1 and sawp i with that index.
        * For a grid, we just have to convert index into rows and columns
        */
        public void placeBombs() {
            int numCells = row*col;
            Random random = new Random();
            for (int index1 = 0; index1 < numCells; index1++) {
                int index2 = index1 + random.nextInt(numCells - index1);
                if (index2 != index1) {
                    int row1 = index1 / col;
                    int col1 = numCells - row1*col;
                    
                    int row2 = index2 / col;
                    int col2 = numCells - row2*col;
                    
                    //swap them
                }
            }
        }
        public void initCells() {
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++) {
                    if (cells[i][j] == '*') {
                        if (checkValidCell(i-1, j-1)) cells[i-1][j-1]++;   
                        if (checkValidCell(i-1, j)) cells[i-1][j]++;
                        if (checkValidCell(i-1, j+1)) cells[i-1][j+1]++;
                        if (checkValidCell(i, j-1)) cells[i][j-1]++;
                        if (checkValidCell(i, j+1)) cells[i][j+1]++;
                        if (checkValidCell(i+1, j-1)) cells[i+1][j-1]++;
                        if (checkValidCell(i+1, j)) cells[i+1][j]++;
                        if (checkValidCell(i+1, j+1)) cells[i+1][j+1]++;
                    } 
                }
        }
        public boolean checkValidCell(int i, int j) {
            return i <= row -1 && i >= 0 && j <= col-1 && j >= 0;
        }
        public void exposeCell(int row, int col) {
            char c = cells[row][col];
            if (c == '*') {
                endGame();
                return;
            } else if (Charcter.isDigit(c)) {
                display.expose(i, j);           
            } else if (Character.isSpaceChar(c)) {
                exposeBlankNeighbors(i, j);
            }
        }
        public void exposeNeighbors(int i, int j) {
            Queue q = ArrayList<Character>();
            q.add(new int[] {i, j});
            while (!q.empty()) {
                int[] pairs = p.remove();
                int row = pairs[0], col = pairs[1];
                if (checkValidCell(row-1, col)) 
                    if (Character.isSpaceChar(row-1, col)) {
                        display.expose(row-1, col);
                        q.add(new int[] {row-1, col});
                    } else { display.expose(row-1, col); }
                if (checkValidCell(row, col-1)) 
                    if (Character.isSpaceChar(row, col-1)) {
                        display.expose(row, col-1);
                        q.add(new int[] {row, col-1});
                    } else { display.expose(row, col-1); }
                if (checkValidCell(row, col+1)) 
                    if (Character.isSpaceChar(row, col+1)) {
                        display.expose(row, col+1);
                        q.add(new int[] {row, col+1});
                    } else { display.expose(row, col+1); }
                if (checkValidCell(row+1, col)) 
                    if (Character.isSpaceChar(row+1, col)) {
                        display.expose(row+1, col);
                        q.add(new int[] {row+1, col});
                    } else { display.expose(row+1, col); }
            }
        }
        
    }
    public class Display {
        public void expose(int row, int col) {
            
        }
    }
    public static void main(String args[]) {}
}
