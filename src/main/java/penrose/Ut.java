package penrose;

import penrose.puzzles.Puzzle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Offers various static methods potentially useful in the calculations of more than one class.
 */
public class Ut {
    public static boolean inRange(int value, int minInclusive, int maxExclusive) {
        if (minInclusive > maxExclusive) {
            throw new IllegalArgumentException("Minimum is greater than maximum");
        }

        return value == minInclusive || (value >= minInclusive && value < maxExclusive);
    }

    public static <T> boolean unique(List<T> items) {
        Set<T> processed = new HashSet<>();

        for (T item : items) {
            if (processed.contains(item)) {
                return false;
            } else {
                processed.add(item);
            }
        }

        return true;
    }

    public static <T extends Puzzle> T getSingletonPuzzle(List<T> puzzles) {
        if (puzzles.isEmpty()) {
            throw new IllegalStateException("Contained puzzle has no solutions");
        } else if (puzzles.size() > 1) {
            throw new IllegalStateException("Contained puzzle has multiple solutions (" + puzzles.size() + ")");
        } else {
            return puzzles.get(0);
        }
    }

    public static boolean isBoxedGrid(int[][] grid, int width, int height) {
        return isBoxedGrid(grid) && grid.length == height && grid[0].length == width;
    }

    public static boolean isBoxedGrid(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return false;
        }

        int rowLength = grid[0].length;
        for (int[] row : grid) {
            if (row.length != rowLength) {
                return false;
            }
        }

        return true;
    }

    public static int[][] boxedGrid(String grid) {
        String[] rows = grid.split("\n");
        int gridSize = rows.length;

        int[][] board = new int[gridSize][gridSize];
        for (int r = 0; r < gridSize; r++) {
            String row = rows[r];
            if (row.length() != gridSize) {
                throw new IllegalArgumentException("Row is of invalid length");
            }

            for (int c = 0; c < gridSize; c++) {
                int cell = row.charAt(c) - '0';
                if (cell < 1 || cell > gridSize) {
                    throw new IllegalArgumentException("Invalid cell value for grid size");
                }

                board[r][c] = cell;
            }
        }

        return board;
    }

    public static int[][] copyGrid(int[][] grid) {
        if (!isBoxedGrid(grid)) {
            throw new IllegalArgumentException("Arrays are not a valid grid");
        }

        int rows = grid.length, cols = grid[0].length;
        int[][] newGrid = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            System.arraycopy(grid[row], 0, newGrid[row], 0, cols);
        }

        return newGrid;
    }
}
