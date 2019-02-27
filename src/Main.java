import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        RecursiveSolver solver1 = new RecursiveSolver("src/board.sdk");
        SudokuSolver solver2 = new DFSSolver("src/board.sdk");

        long t1 = System.nanoTime();
        System.out.println(solver2.solve());
        long t2 = System.nanoTime();
        System.out.println("Time: " + (t2 - t1));

        t1 = System.nanoTime();
        System.out.println(solver1.solve());
        t2 = System.nanoTime();
        System.out.println("Time: " + (t2 - t1));
    }
    /*
    The iterative solution takes significantly more time regardless of whether or not it runs first or second.
    It took 106889363 ns while the recursive solution took 2072025 ns. I had to prune down the puzzle to just a few
    missing numbers because it was taking too long the first time I ran the program. I don't have any idea why this
    is happening, because my initial guess was that the recursive solution would take longer. Maybe recursion is
    faster because, in the process of making recursive calls, work is suspended on other functions calls but the
    iterative solution does every operation until a solution is found.
     */
}
