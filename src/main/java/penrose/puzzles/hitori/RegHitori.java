package penrose.puzzles.hitori;

import penrose.Ut;

/**
 * Represents the base implementation of a Hitori Puzzle.
 */
public class RegHitori implements HitoriPuzzle {
    private final int[][] board;
    private final int gridSize;

    public RegHitori(int[][] board, int gridSize) {
        if (gridSize <= 0) {
            throw new IllegalArgumentException("Negative dimension given");
        } else if (!Ut.isBoxedGrid(board, gridSize, gridSize)) {
            throw new IllegalArgumentException("Grid does not match the given dimensions");
        }

        this.board = board;
        this.gridSize = gridSize;
    }

    @Override
    public int getSize() {
        return gridSize;
    }

    @Override
    public int getNumberAt(int row, int col) {
        if (!Ut.inRange(row, 0, gridSize) || !Ut.inRange(col, 0, gridSize)) {
            throw new IllegalArgumentException("Coordinate out of bounds");
        }

        return board[row][col];
    } // TODO: factor out grid access into utility method

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                result.append(board[row][col] == 0 ? "X" : (char) ('0' + board[row][col]));
            }
            result.append('\n');
        }

        return result.toString();
    }
}
