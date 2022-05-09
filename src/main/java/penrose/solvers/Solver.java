package penrose.solvers;

/**
 * Represents a solver of puzzles. Solvers take in serialized puzzles of their respective types and return a completed
 * version of the puzzle, if possible.
 */
public interface Solver {
    /**
     * Returns the number of "steps" taken to completely analyze the solver's puzzle. While potential discrepancies in the
     * definition can arise between sub-interfaces, noting the number of iterations for multiple implementations of the
     * same sub-interface can provide insight into their relative efficiencies.
     * @return 0 if the solver is not run yet, otherwise the number of iterations ran by this solver
     */
    int getIterations();
}
