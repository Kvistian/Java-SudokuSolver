package sudoku.grid;

import java.util.ArrayList;

public class BoxList<Box> extends ArrayList<Box> {
    public BoxList() {
        super();
    }

    public Box getFor(Slot slot) {
        int row = slot.getKey() / 9;
        int column = slot.getKey() % 9;

        return get(((((row / 3) + 1) * 3) - 2) + (column / 3) - 1);
    }
}
