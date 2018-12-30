package grid.group.row;

import grid.Slot;
import grid.group.Groups;

public class Rows extends Groups<Row> {
    public Rows() {
        super(Row.class);
    }

    @Override
    public Row getFor(Slot slot) {
        int index = slot.getKey() / 9;

        return this.get(index);
    }
}
