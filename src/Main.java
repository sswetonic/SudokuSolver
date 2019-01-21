import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        String pathName = "src/board.ss";
        Board b = new Board(pathName);
        System.out.println(b);
    }
}
