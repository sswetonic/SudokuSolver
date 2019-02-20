import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SdkBoardReader implements BoardReader {
    public List<List<Character>> boardRead(File fileName) throws FileNotFoundException {
        List<List<Character>> board = new ArrayList<>();
        Scanner sc = new Scanner(fileName);
        while (sc.hasNextLine()) {
            ArrayList<Character> row = new ArrayList<>();
            String line1 = sc.nextLine();
            for(int i = 0; i < line1.length(); i++) {
                row.add(line1.charAt(i));
            }
            board.add(row);
        }
        return board;
    }
}