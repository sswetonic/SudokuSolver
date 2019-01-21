import java.util.*;
import java.io.*;

public class Board {

    private List<List<Character>> board;

    public Board(String fileName) throws FileNotFoundException {
        File boardFile = new File(fileName);
        board = BoardReaderFactory.getReader(fileName).boardRead(boardFile);
    }

    public String toString() {
        String toReturn = "";
        for (List<Character> val : board) {
            for (int i = 0; i < val.size(); i++) {
                toReturn += val.get(i) + " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}
