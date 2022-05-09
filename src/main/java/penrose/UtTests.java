package penrose;

public class UtTests {
    public static final int[][] SUD422A = new int[][] {
            {2, 0, 0, 0},
            {0, 1, 0, 2},
            {0, 0, 3, 0},
            {0, 0, 0, 4}
    }, SUD632A = new int[][] {
            {0, 4, 3, 0, 1, 0},
            {1, 0, 0, 0, 0, 3},
            {0, 3, 0, 4, 0, 5},
            {0, 0, 5, 0, 2, 0},
            {3, 1, 0, 0, 0, 6},
            {0, 2, 0, 1, 3, 0}
    }, SUD933_ = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    }, SUD933A = new int[][] {
            {3, 0, 0, 4, 1, 5, 2, 0, 0},
            {4, 0, 9, 7, 6, 0, 0, 0, 1},
            {0, 6, 0, 0, 2, 8, 4, 0, 0},
            {1, 0, 0, 0, 8, 0, 0, 5, 7},
            {0, 4, 5, 3, 0, 0, 0, 0, 0},
            {8, 0, 2, 1, 0, 0, 6, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 6},
            {9, 0, 4, 0, 0, 0, 1, 3, 5},
            {6, 1, 0, 5, 0, 0, 7, 2, 8},
    }, SUD933B = new int[][] {
            {0, 4, 0, 0, 0, 0, 9, 6, 0},
            {1, 9, 0, 7, 4, 0, 0, 2, 0},
            {0, 0, 0, 6, 9, 0, 0, 0, 0},
            {6, 0, 0, 5, 8, 0, 0, 7, 9},
            {0, 0, 0, 0, 6, 3, 2, 0, 5},
            {4, 8, 0, 2, 0, 9, 6, 3, 1},
            {8, 0, 4, 0, 0, 0, 3, 0, 0},
            {0, 3, 0, 0, 1, 0, 0, 9, 6},
            {0, 5, 0, 0, 2, 0, 0, 0, 0},
    }, SUD933C = new int[][] { // listed on wikipedia as a puzzle designed to work against brute-force algorithms
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 8, 5},
            {0, 0, 1, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 7, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 1, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 0, 0, 0, 7, 3},
            {0, 0, 2, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 9},
    };

    public static String HIT4A = """
            1244
            1123
            2124
            2312
            """,
            HIT5A = """
            41311
            31524
            12233
            54334
            33451
            """,
            HIT5B = """
            34313
            54341
            15131
            21453
            41155
            """,
            HIT5C = """
            15213
            14212
            51354
            52335
            23452""",
            HIT6A = """
            155443
            346212
            524631
            235235
            213144
            422356""";
}
