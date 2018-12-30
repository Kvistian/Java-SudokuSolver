import grid.Grid;
import solver.Solver;

public class Main {
    private static final Grid DEFAULT = new Grid(new int[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9,
            9, 1, 2, 3, 4, 5, 6, 7, 8,
            8, 9, 1, 2, 3, 4, 5, 6, 7,
            7, 8, 9, 1, 2, 3, 4, 5, 6,
            6, 7, 8, 9, 1, 2, 3, 4, 5,
            5, 6, 7, 8, 9, 1, 2, 3, 4,
            4, 5, 6, 7, 8, 9, 1, 2, 3,
            3, 4, 5, 6, 7, 8, 9, 1, 2,
            2, 3, 4, 5, 6, 7, 8, 9, 1
    });

    private static final Grid SIMPLE = new Grid(new int[] {
            1, 0, 3, 0, 0, 0, 0, 0, 8,
            0, 4, 0, 2, 6, 0, 1, 5, 0,
            6, 9, 0, 1, 8, 0, 0, 0, 4,
            8, 0, 0, 0, 1, 0, 0, 6, 0,
            0, 5, 0, 0, 9, 0, 0, 1, 0,
            0, 7, 0, 0, 2, 0, 0, 0, 5,
            5, 0, 0, 0, 7, 1, 0, 3, 6,
            0, 6, 7, 0, 5, 8, 0, 9, 0,
            4, 0, 0, 0, 0, 0, 5, 0, 7
    });

    public static void main(String[] args) {
        Solver solver = new Solver(SIMPLE);
        solver.solve();
    }
}
