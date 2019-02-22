import java.io.IOException;

public class DFSSolver extends SudokuSolver{
    public Board board;

    public DFSSolver(String filePath) throws IOException {
        super(filePath);
    }
    public Board solve() {
        while (board.isSolved()) {
            for (Board neighbor : board.getNeighbors()) {
                Board potentialSolution = neighbor;
                if (potentialSolution != null) {
                    return potentialSolution;
                }
            }

        }
        return board;
    }
}
