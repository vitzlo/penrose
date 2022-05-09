package penrose.puzzles;

/**
 * Represents a puzzle in a currently legal state. Internal representations of a puzzle (typically via a two-dimensional
 * array) are sub-interface-specific.
 */
public interface Puzzle {
    /**
     * Represents a cleanly formatted and unambiguous text version of this puzzle.
     * @return the text output of the puzzle
     */
    String toString();
}

// TODO: prune contents of puzzles
