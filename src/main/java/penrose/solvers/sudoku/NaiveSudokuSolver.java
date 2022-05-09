package penrose.solvers.sudoku;

import penrose.Ut;
import penrose.puzzles.sudoku.RegSudoku;
import penrose.puzzles.sudoku.SudokuPuzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * This solver solves given Sudoku puzzles via a recursive and entirely naive approach, iterating through all valid
 * possibilities in each blank and retaining no information.
 */
public class NaiveSudokuSolver extends ASudokuSolver {
    public NaiveSudokuSolver(SudokuPuzzle puzzle) {
        super(puzzle);
    }

    @Override
    public SudokuPuzzle solve() {
        List<SudokuPuzzle> solutions = new ArrayList<>();
        int[][] currentBoard = new int[gridSize][gridSize];

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                currentBoard[row][col] = puzzle.getNumberAt(row, col);
            }
        }

        solveRecur(solutions, currentBoard);

        return Ut.getSingletonPuzzle(solutions);
    }

    private void solveRecur(List<SudokuPuzzle> solutions, int[][] currentBoard) {
        iterations++;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (currentBoard[i][j] == 0) {
                    for (int k = 1; k <= gridSize; k++) {
                        if (!isInRow(currentBoard, k, i) && !isInCol(currentBoard, k, j)
                                && !isInBox(currentBoard, k, i, j)) {
                            currentBoard[i][j] = k;
                            solveRecur(solutions, currentBoard);
                            currentBoard[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }

        solutions.add(new RegSudoku(Ut.copyGrid(currentBoard), gridSize, boxWidth, boxHeight)); // TODO: better creation
    }

    protected boolean isInRow(int[][] currentBoard, int n, int row) {
        for (int i = 0; i < gridSize; i++) {
            if (currentBoard[row][i] == n)
                return true;
        }
        return false;
    }

    protected boolean isInCol(int[][] currentBoard, int n, int col) {
        for (int i = 0; i < gridSize; i++) {
            if (currentBoard[i][col] == n)
                return true;
        }
        return false;
    }

    protected boolean isInBox(int[][] currentBoard, int n, int row, int col) {
        for (int i = row - row % boxHeight; i < row + (boxHeight - row % boxHeight); i++) {
            for (int j = col - col % boxWidth; j < col + (boxWidth - col % boxWidth); j++) {
                if (currentBoard[i][j] == n)
                    return true;
            }
        }
        return false;
    }
}
