import java.util.*;
import java.io.*;

public class Board {

    private final List<List<Character>> board;

    public Board(String fileName) throws FileNotFoundException {
        File boardFile = new File(fileName);
        board = BoardReaderFactory.getReader(fileName).boardRead(boardFile);

    }

    Board(List<List<Character>> board) {
        this.board = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < board.get(i).size(); j++) {
                this.board.get(i).add(board.get(i).get(j));
            }
        }
    }

    public ArrayList<Board> getNeighbors() {
        ArrayList<Board> neighbors = new ArrayList<>();
        for (int i = 0; i < this.getBoard().size(); i++) {
            for (int j = 0; j < this.getBoard().get(i).size(); j++) {
                if (this.getBoard().get(i).get(j) == '.') {
                    for (int k = 1; k <= 9; k++) {
                        Board neighbor = new Board(this.board);
                        neighbor.setCell(i, j, Character.forDigit(k, 10));

                        if (neighbor.isValid()) {
                            neighbors.add(neighbor);
                        }
                    }
                }
            }
        }
        return neighbors;
    }

    List<List<Character>> getBoard() {
        return board;
    }

    private void setCell(Integer row, Integer column, Character value) {
        this.board.get(row).set(column, value);
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i) || !checkColumn(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!(checkSquare(board, i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow(List<List<Character>> board, int row) {
        for (int i = 1; i < 10; i++) {
            if (Collections.frequency(board.get(row), Character.forDigit(i, 10)) > 1) {
                return false;
            }

        }
        return true;
    }

    private static boolean checkColumn(List<List<Character>> board, int col) {
        List<Character> tempList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            tempList.add(board.get(i).get(col));
        }
        for (int i = 1; i < 10; i++) {
            if (Collections.frequency(tempList, Character.forDigit(i, 10)) > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSquare(List<List<Character>> board, int row, int col) {
        List<Character> tempList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempList.add(board.get(row + i).get(col + j));
            }
        }
        for (int i = 0; i < 10; i++) {
            if (Collections.frequency(tempList, Character.forDigit(i, 10)) > 1) {
                return false;
            }
        }

        return true;
    }

    private int getNumBlanks() {
        int blanks = 0;
        for (List<Character> row : this.board) {
            for (Character cell : row) {
                if (cell == '.') {
                    blanks++;
                }
            }
        }
        return blanks;
    }

    public boolean isSolved() {
        return isValid() && getNumBlanks() == 0;
    }

    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        for (List<Character> val : board) {
            for (int i = 0; i < val.size(); i++) {
                toReturn.append(val.get(i) + " ");
            }
            toReturn.append("\n");
        }
        return toReturn.toString();
    }
}
