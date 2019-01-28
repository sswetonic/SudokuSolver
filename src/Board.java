import java.util.*;
import java.io.*;

public class Board {

    public List<List<Character>> board;

    public Board(String fileName) throws FileNotFoundException {
        File boardFile = new File(fileName);
        board = BoardReaderFactory.getReader(fileName).boardRead(boardFile);
    }

    public static boolean isSolved(List<List<Character>> board) {
        for (int i = 0; i < 9; i++) {
            if (Collections.frequency(board.get(i), '.') > 0) {
                return false;
            }
        }
        if (!isValid(board)) {
            return false;
        }
        return true;
    }

    public static boolean isValid(List<List<Character>> board) {
        for (int i = 0; i < 9; i++) {
            if (!(checkRow(board, i) || checkColumn(board, i))) {
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
