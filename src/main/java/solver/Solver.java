package solver;

import grid.Grid;
import grid.Slot;
import java.util.List;

public class Solver {
    private final Grid grid;

    public Solver(int[] gridValues) {
        grid = new Grid(gridValues);
    }

    public void solve() {
        List<Slot> slots = grid.getSlots();
        Slot slot1 = slots.get(27);
        slot1.getRow().relations();

        Slot slot2 = slots.get(36);
        slot2.getRow().relations();

        Slot slot3 = slots.get(45);
        slot3.getRow().relations();

        Slot slot4 = slots.get(54);
        slot4.getRow().relations();

    }
}
