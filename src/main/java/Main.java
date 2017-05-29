import solver.Solver;

public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver(defaultValues());
        solver.solve();

        System.out.println("Diff test");
    }

    private static int[] defaultValues() {
        return new int[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                9, 1, 2, 3, 4, 5, 6, 7, 8,
                8, 9, 1, 2, 3, 4, 5, 6, 7,
                7, 8, 9, 1, 2, 3, 4, 5, 6,
                6, 7, 8, 9, 1, 2, 3, 4, 5,
                5, 6, 7, 8, 9, 1, 2, 3, 4,
                4, 5, 6, 7, 8, 9, 1, 2, 3,
                3, 4, 5, 6, 7, 8, 9, 1, 2,
                2, 3, 4, 5, 6, 7, 8, 9, 1
        };
    }
}
