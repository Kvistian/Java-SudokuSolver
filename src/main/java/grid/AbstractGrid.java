package grid;

import com.google.common.collect.Lists;
import grid.group.box.Box;
import grid.group.box.Boxes;
import grid.group.column.Column;
import grid.group.column.Columns;
import grid.group.row.Row;
import grid.group.row.Rows;
import java.util.List;

public abstract class AbstractGrid {
    protected final List<Slot> slots;
    protected final Rows rows;
    protected final Columns columns;
    protected final Boxes boxes;

    public AbstractGrid(int[] initialValues) {
        slots = Lists.newArrayList();
        rows = new Rows();
        columns = new Columns();
        boxes = new Boxes();

        init(initialValues);
    }

    private void init(int[] defaults) {
        int key = 0;

        for (int value : defaults) {
            Slot slot = new Slot(key, value);

            Row row = rows.getFor(slot);
            Column column = columns.getFor(slot);
            Box box = boxes.getFor(slot);

            slot.setRelations(row, column, box);

            slots.add(slot);

            key++;
        }
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
