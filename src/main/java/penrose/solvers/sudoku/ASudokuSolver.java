package penrose.solvers.sudoku;

import penrose.puzzles.sudoku.SudokuPuzzle;

/**
 * This class abstracts the field initialization, construction, and iteration getting for all SudokuSolver implementations.
 */
public abstract class ASudokuSolver implements SudokuSolver {
    protected final SudokuPuzzle puzzle;
    protected final int gridSize, boxWidth, boxHeight;
    protected int iterations;

    protected ASudokuSolver(SudokuPuzzle puzzle) {
        this.puzzle = puzzle;
        this.gridSize = puzzle.getSize();
        this.boxWidth = puzzle.getBoxWidth();
        this.boxHeight = puzzle.getBoxHeight();
        iterations = 0;
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
