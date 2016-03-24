package sudoku;

import sudoku.grid.Grid;
import sudoku.grid.Slot;

import java.util.ArrayList;

public class Handler {

    private Grid grid;

    public Handler() {
        grid = new Grid();
        grid.create(makeDefaults());
    }

    public static void main(String[] args) {
        Handler handler = new Handler();
        handler.run();
    }

    public void run() {
        ArrayList<Slot> slots = grid.getSlots();
        slots.get(0).setValue(7);

        System.out.println(grid);
    }

    private int[] makeDefaults() {
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
