package grid.group.column;

import grid.Slot;
import grid.group.Groups;

public class Columns extends Groups<Column> {
    public Columns() {
        super(Column.class);
    }

    @Override
    public Column getFor(Slot slot) {
        int index = slot.getKey() % 9;

        return get(index);
    }
}
