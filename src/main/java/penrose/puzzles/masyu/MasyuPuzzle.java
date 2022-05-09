package penrose.puzzles.masyu;

public interface MasyuPuzzle {
    int getSize();

    boolean isWhite(int row, int col);

    boolean isBlack(int row, int col);

    boolean isEmpty(int row, int col);

    void drawLine(int row1, int col1, int row2, int col2);
}
