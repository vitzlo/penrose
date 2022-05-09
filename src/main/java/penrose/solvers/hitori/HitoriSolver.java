package penrose.solvers.hitori;

import penrose.puzzles.hitori.HitoriPuzzle;
import penrose.solvers.Solver;

public interface HitoriSolver extends Solver {
    HitoriPuzzle solve();
}
