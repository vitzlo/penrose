package penrose.puzzles;

import penrose.Ut;
import penrose.puzzles.hitori.HitoriPuzzle;
import penrose.puzzles.hitori.RegHitori;

/**
 * Offers static creator methods to instantiate serialized puzzles in more convenient ways, such as in string notation.
 */
public class PuzzleFactory {
    public static HitoriPuzzle hitori(String seed) {
        int[][] board = Ut.boxedGrid(seed);
        return new RegHitori(board, board.length);
    }
}
