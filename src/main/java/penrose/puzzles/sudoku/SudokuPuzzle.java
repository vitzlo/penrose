package penrose.puzzles.sudoku;

import penrose.puzzles.Puzzle;

/**
 * Represents a Sudoku (Japanese: "digit-single") puzzle, a logic-based number-placement puzzle. It consists of a square
 * grid of numbers ranging from 1 to the side length of the grid with some cells blank. The blank cells must be filled in
 * so that the following criteria are met:
 * - Each row and column contains exactly one of each in-range number.
 * - Each subgrid (usually a square) contains exactly one of each in-range number.
 */
public interface SudokuPuzzle extends Puzzle {
    /**
     * Gets the side length of this puzzle's grid.
     * @return the grid size
     */
    int getSize();

    /**
     * Gets the horizontal side length of one subgrid in this puzzle.
     * @return the width of the subgrids
     */
    int getBoxWidth();

    /**
     * Gets the vertical side length of one subgrid in this puzzle.
     * @return the height of the subgrids
     */
    int getBoxHeight();

    /**
     * Gets the contents of the cell at the given row and column coordinates, indexing from zero and the top left.
     * @param row the row of the desired cell
     * @param col the column of the desired cell
     * @return the integer contents of the desired cell
     */
    int getNumberAt(int row, int col);
}
