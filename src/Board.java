import java.util.*;
import java.io.*;

public class Board {

    public List<List<Character>> board;

    public Board(String fileName) throws FileNotFoundException {
        File boardFile = new File(fileName);
        board = BoardReaderFactory.getReader(fileName).boardRead(boardFile);
        board = solve(board);

    }

    public static List<List<Character>> solve(List<List<Character>> board) {
        return solveHelper(board);
    }

    //I know this doesn't work but I think I got 75% of the way there
    public static List<List<Character>> solveHelper(List<List<Character>> board) {
        for (List<List<Character>> option : getNeighbors(board)) {
            if (isSolved(option)) {
                return option;
            }
        }
        return null;
    }

    //This appears to correctly fill in a few spaces, but breaks if there are too many
    //I chose to pass board as a parameter so the function gets access to modify it
    public static List<List<List<Character>>> getNeighbors(List<List<Character>> board) {
        List<List<List<Character>>> options = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j <board.get(i).size(); j++) {
                List<List<Character>> possibleBoard = new ArrayList<>();
                for (int row = 0; row < board.size(); row++) {
                    possibleBoard.add(new ArrayList<>());
                    for (int col = 0; col < board.get(row).size(); col++) {
                        possibleBoard.get(row).add(board.get(row).get(col));
                    }
                }
                if (board.get(i).get(j).equals('.')) {
                    for (int k = 1; k < 10 ; k++) {
                        possibleBoard.get(i).set(j, Character.forDigit(k, 10));
                        //Loops 1-9, if the number added doesn't work, it undos the change
                        if (isValid(possibleBoard)) {
                            options.add(possibleBoard);
                        }
                    }

                }
            }

        }
        return options;
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
            /*
            for (int j = 0; j < 9; j++) {
                if (!board.get(i-1).get(j).equals('.')) {
                    return false;
                } else if (!Character.isDigit(board.get(i-1).get(j))) {
                    return false;
                }
            }
            */
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
