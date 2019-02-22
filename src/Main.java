import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        RecursiveSolver solver1 = new RecursiveSolver("src/board2.sdk");
        //SudokuSolver solver2 = new DFSSolver("src/board2.sdk");

        System.out.println(solver1.board);
        System.out.println(solver1.solve());

    }
    /*
    I actually had my recursive solution working until I tried to split it up into an abstract class with
    two implementations. It appears to be a problem with calling the super() constructor; I kept getting an error
    saying "there is no default constructor in SudokuSolver" and adding super() made that go away. Since I don't have a
    this working in its current state, I can't analyze the runtime of the solutions. I'll continue trying to get this
    working.
     */
}
