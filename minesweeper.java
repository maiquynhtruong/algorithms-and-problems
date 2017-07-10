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
