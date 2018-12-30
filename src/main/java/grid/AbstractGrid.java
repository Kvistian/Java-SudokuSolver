package grid;

import grid.group.box.Box;
import grid.group.box.Boxes;
import grid.group.column.Column;
import grid.group.column.Columns;
import grid.group.row.Row;
import grid.group.row.Rows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractGrid {
    protected final List<Slot> slots = new ArrayList<>();
    protected final Rows rows = new Rows();
    protected final Columns columns = new Columns();
    protected final Boxes boxes = new Boxes();
    protected final Map<Integer, List<Slot>> valueSlots = new HashMap<>();

    AbstractGrid(int[] initialValues) {
        for (int key = 0; key < initialValues.length; key++) {
            int value = initialValues[key];
            if (value == 0) {
                continue;
            }

            Slot slot = new Slot(key, value);
            Row row = rows.getFor(slot);
            Column column = columns.getFor(slot);
            Box box = boxes.getFor(slot);

            slot.setRelations(row, column, box);

            slots.add(slot);

            if (!valueSlots.containsKey(value)) {
                valueSlots.put(value, new ArrayList<>());
            }
            valueSlots.get(value).add(slot);
        }
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
