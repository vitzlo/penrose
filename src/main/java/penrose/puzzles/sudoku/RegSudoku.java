package penrose.puzzles.sudoku;

import penrose.Ut;

/**
 * Represents the base implementation of a Sudoku Puzzle.
 */
public class RegSudoku implements SudokuPuzzle {
    private final int[][] grid;
    private final int gridSize, boxWidth, boxHeight;

    public RegSudoku(int[][] grid, int gridSize, int boxWidth, int boxHeight) {
        if (gridSize <= 0 || boxWidth <= 0 || boxHeight <= 0) {
            throw new IllegalArgumentException("Negative dimension given");
        } else if (boxWidth * boxHeight != gridSize) {
            throw new IllegalArgumentException("Box dimensions do not match with the grid length");
        } else if (!Ut.isBoxedGrid(grid, gridSize, gridSize)) {
            throw new IllegalArgumentException("Grid does not match the given dimensions");
        }

        this.grid = grid;
        this.gridSize = gridSize;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
    }

    public RegSudoku(int[][] grid, int gridSize) {
        double boxSize = Math.sqrt(gridSize);
        if (boxSize != Math.floor(boxSize)) {
            throw new IllegalArgumentException("Box dimensions cannot be assumed from the grid size");
        }

        this.grid = grid;
        this.gridSize = gridSize;
        this.boxWidth = (int) boxSize;
        this.boxHeight = (int) boxSize;
    }

    @Override
    public int getSize() {
        return gridSize;
    }

    @Override
    public int getBoxWidth() {
        return boxWidth;
    }

    @Override
    public int getBoxHeight() {
        return boxHeight;
    }

    @Override
    public int getNumberAt(int row, int col) {
        if (!Ut.inRange(row, 0, gridSize) || !Ut.inRange(col, 0, gridSize)) {
            throw new IllegalArgumentException("Coordinate out of bounds");
        }

        return grid[row][col];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < gridSize; i++) {
            if (i != 0 && i % boxHeight == 0) {
                for (int j = 0; j < boxHeight; j++) {
                    result.append("-".repeat(boxWidth));
                    if (j < boxHeight - 1)
                        result.append('+');
                }
                result.append('\n');
            }
            for (int j = 0; j < gridSize; j++) {
                if (j != 0 && j % boxWidth == 0)
                    result.append('|');
                result.append(grid[i][j] == 0 ? "." : (char) ('0' + grid[i][j]));
            }
            result.append('\n');
        }
        return result.toString();
    }
}
