package grid;

import java.util.ArrayList;

public abstract class AbstractGrid {
    protected ArrayList<Slot> slots;
    protected RowList<Row> rows;
    protected ColumnList<Column> columns;
    protected BoxList<Box> boxes;

    public AbstractGrid() {
        slots = new ArrayList<Slot>();
        rows = new RowList<Row>();
        columns = new ColumnList<Column>();
        boxes = new BoxList<Box>();

        createGroups();
    }

    private void createGroups() {
        for (int key = 0; key < 9; key++) {
            rows.add(new Row(key));
            columns.add(new Column(key));
            boxes.add(new Box(key));
        }
    }

    protected void setDefaults(int[] defaults) {
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

    public ArrayList<Slot> getSlots() {
        return slots;
    }
}
