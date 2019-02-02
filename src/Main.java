import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        //board.sdk contains a fully solved, valid board
        //board2.sdk contains an invalid board;
        //If you change a few on the numbers in board.sdk to blanks, it will fill them in

        String pathName = "src/board2.sdk";
        Board b = new Board(pathName);
        System.out.println(b);
    }
}
