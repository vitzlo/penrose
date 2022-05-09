package penrose;

import penrose.puzzles.PuzzleFactory;
import penrose.puzzles.hitori.HitoriPuzzle;
import penrose.puzzles.hitori.RegHitori;
import penrose.puzzles.sudoku.RegSudoku;
import penrose.puzzles.sudoku.SudokuPuzzle;
import penrose.solvers.hitori.HitoriSolver;
import penrose.solvers.hitori.NaiveHitoriSolver;
import penrose.solvers.sudoku.NaiveSudokuSolver;
import penrose.solvers.sudoku.SudokuSolver;

public class PenroseMain {
    public static void main(String[] args) {
        SudokuPuzzle puzzle = new RegSudoku(UtTests.SUD933C, 9);
        System.out.println(puzzle);
        SudokuSolver solver = new NaiveSudokuSolver(puzzle);
        SudokuPuzzle solvedPuzzle = solver.solve();
        System.out.println(solvedPuzzle);

//        HitoriPuzzle puzzle = PuzzleFactory.hitori(UtTests.HIT5C);
//        System.out.println(puzzle);
//        HitoriSolver solver = new NaiveHitoriSolver(puzzle);
//        HitoriPuzzle solvedPuzzle = solver.solve();
//        System.out.println(solvedPuzzle);
    }
}

// TODO: null checks (whatever tho)
// TODO: exception signatures
// TODO: sudoku factory method
// TODO: run controlled iteration tests on the solvers
// TODO: finish javadoc
