package grid.group.box;

import grid.Slot;
import grid.group.Groups;

public class Boxes extends Groups<Box> {
    public Boxes() {
        super(Box.class);
    }

    @Override
    public Box getFor(Slot slot) {
        int row = slot.getKey() / 9;
        int column = slot.getKey() % 9;

        return get(((((row / 3) + 1) * 3) - 2) + (column / 3) - 1);
    }
}
