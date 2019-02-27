import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class DFSSolver extends SudokuSolver{
    public Board board;

    public DFSSolver(String filePath) throws IOException {
        super(filePath);
    }
    public Board solve() {
        Stack<Board> solutionStack = new Stack<>();
        solutionStack.add(this.getBoard());

        while (!solutionStack.isEmpty()) {
            Board node = solutionStack.pop();
            if (node.isSolved()) {
                return node;
            } else {
                ArrayList<Board> neighbors = node.getNeighbors();

                for (Board neighbor : neighbors) {
                    if (solutionStack.search(neighbor.toString()) < 0) {
                        solutionStack.push(neighbor);
                    }
                }
            }
        }

        return null;
    }
}
