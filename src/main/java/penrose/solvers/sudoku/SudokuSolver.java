package penrose.solvers.sudoku;

import penrose.puzzles.sudoku.SudokuPuzzle;
import penrose.solvers.Solver;

/**
 * Represents a solver of Sudoku puzzles. The best implementation is currently NaiveSudokuSolver.
 */
public interface SudokuSolver extends Solver {
    /**
     * Returns a solved version of the Sudoku currently in the solver.
     * @return the solved puzzle, if possible
     * @throws IllegalStateException if the puzzle has zero or multiple solutions
     */
    SudokuPuzzle solve();
}
