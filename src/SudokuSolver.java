import java.io.IOException;

public abstract class SudokuSolver {
    private Board board;

    public SudokuSolver(String filePath) throws IOException {
        this.board = new Board(filePath);
    }

    protected Board getBoard() {
        return this.board;
    }
    public abstract Board solve();
}
