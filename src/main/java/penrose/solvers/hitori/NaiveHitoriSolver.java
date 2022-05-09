package penrose.solvers.hitori;

import penrose.Ut;
import penrose.puzzles.hitori.HitoriPuzzle;
import penrose.puzzles.hitori.RegHitori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaiveHitoriSolver extends AHitoriSolver {
    public NaiveHitoriSolver(HitoriPuzzle puzzle) {
        super(puzzle);
    }

    @Override
    public HitoriPuzzle solve() {
        List<HitoriPuzzle> solutions = new ArrayList<>();
        int[][] currentBoard = new int[gridSize][gridSize];

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                currentBoard[row][col] = puzzle.getNumberAt(row, col);
            }
        }

        solveRecur(solutions, currentBoard, 0, 1);

        return Ut.getSingletonPuzzle(solutions);
    }

    private void solveRecur(List<HitoriPuzzle> solutions, int[][] currentBoard, int rowToCheck, int digitToCheck) {
        if (rowToCheck == gridSize) {
            if (validBoard(currentBoard)) {
                solutions.add(new RegHitori(Ut.copyGrid(currentBoard), gridSize)); // TODO: better creation
            }

            return;
        }

        List<Integer> indices = new ArrayList<>();
        for (int col = 0; col < gridSize; col++) {
            if (currentBoard[rowToCheck][col] == digitToCheck) {
                indices.add(col);
            }
        }

        stepSolveRecur(solutions, zeroSpacesAt(Ut.copyGrid(currentBoard), rowToCheck, indices), rowToCheck, digitToCheck);
        for (int safeCol : indices) {
            List<Integer> unsafeCols = new ArrayList<>(indices);
            unsafeCols.remove(Integer.valueOf(safeCol));
            stepSolveRecur(solutions, zeroSpacesAt(Ut.copyGrid(currentBoard), rowToCheck, unsafeCols), rowToCheck, digitToCheck);
        }
    }

    private void stepSolveRecur(List<HitoriPuzzle> solutions, int[][] currentBoard, int rowToCheck, int digitToCheck) {
        if (digitToCheck == gridSize) {
            solveRecur(solutions, currentBoard, ++rowToCheck, 1);
        } else {
            solveRecur(solutions, currentBoard, rowToCheck, ++digitToCheck);
        }
    }

    private int[][] zeroSpacesAt(int[][] currentBoard, int row, List<Integer> cols) {
        for (int col : cols) {
            currentBoard[row][col] = 0;
        }

        return currentBoard;
    }

    private boolean validBoard(int[][] currentBoard) {
        int totalUnshaded = 0;

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (row != gridSize - 1 && currentBoard[row][col] == 0 && currentBoard[row + 1][col] == 0) {
                    return false;
                }
                if (col != gridSize - 1 && currentBoard[row][col] == 0 && currentBoard[row][col + 1] == 0) {
                    return false;
                }

                if (currentBoard[row][col] != 0) {
                    totalUnshaded++;
                }
            }
        }

        for (int col = 0; col < gridSize; col++) {
            List<Integer> columnNumbers = new ArrayList<>();

            for (int row = 0; row < gridSize; row++) {
                if (currentBoard[row][col] != 0) {
                    columnNumbers.add(currentBoard[row][col]);
                }
            }

            if (!Ut.unique(columnNumbers)) {
                return false;
            }
        }

        return (dfsCount(new boolean[gridSize][gridSize], currentBoard, 0, currentBoard[0][0] != 0 ? 0 : 1)) == totalUnshaded;
    }

    private int dfsCount(boolean[][] found, int[][] currentBoard, int row, int col) {
        found[row][col] = true;
        int total = 1;

        if (row != 0 && !found[row - 1][col] && currentBoard[row - 1][col] != 0) {
            total += dfsCount(found, currentBoard, row - 1, col);
        }
        if (row != gridSize - 1 && !found[row + 1][col] && currentBoard[row + 1][col] != 0) {
            total += dfsCount(found, currentBoard, row + 1, col);
        }
        if (col != 0 && !found[row][col - 1] && currentBoard[row][col - 1] != 0) {
            total += dfsCount(found, currentBoard, row, col - 1);
        }
        if (col != gridSize - 1 && !found[row][col + 1] && currentBoard[row][col + 1] != 0) {
            total += dfsCount(found, currentBoard, row, col + 1);
        }

        return total;
    }
}
