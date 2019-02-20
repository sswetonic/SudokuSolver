import jdk.jshell.spi.ExecutionControl;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionControl.NotImplementedException {
        //board.sdk contains a fully solved, valid board
        //board2.sdk contains an invalid board;
        //If you change a few on the numbers in board.sdk to blanks, it will correctly fill them in

        String pathName = "src/board2.sdk";
        Board b = new Board(pathName);
        System.out.println(b);
    }
}
