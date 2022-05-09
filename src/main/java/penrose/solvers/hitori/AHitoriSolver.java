package penrose.solvers.hitori;

import penrose.puzzles.hitori.HitoriPuzzle;

public abstract class AHitoriSolver implements HitoriSolver {
    protected final HitoriPuzzle puzzle;
    protected final int gridSize;
    protected int iterations;

    protected AHitoriSolver(HitoriPuzzle puzzle) {
        this.puzzle = puzzle;
        this.gridSize = puzzle.getSize();
        this.iterations = 0;
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
