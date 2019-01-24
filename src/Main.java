import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        //board.sdk contains a fully solved, valid board
        //board2.sdk contains an invalid board;

        String pathName = "src/board.sdk";
        Board b = new Board(pathName);
        System.out.println(b);
    }
}
