package penrose.puzzles.hitori;

import penrose.puzzles.Puzzle;

/**
 * Represents a Hitori (Japanese: "alone" or "one person"; literally "leave me alone") puzzle, a type of logic puzzle
 * published by Nikoli. It consists of a square grid of numbers ranging from 1 to the side length of the grid which must
 * be "blacked out" according to the following criteria:
 * - No row or column can have multiple of any given number.
 * - Black cells cannot be orthogonally adjacent to each other.
 * - All the remaining white cells must be orthogonally connected to each other.
 */
public interface HitoriPuzzle extends Puzzle {
    /**
     * Gets the side length of this puzzle's grid.
     * @return the grid size
     */
    int getSize();

    /**
     * Gets the contents of the cell at the given row and column coordinates, indexing from zero and the top left.
     * @param row the row of the desired cell
     * @param col the column of the desired cell
     * @return the integer contents of the desired cell
     */
    int getNumberAt(int row, int col);
}
