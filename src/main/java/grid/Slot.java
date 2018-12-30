package grid;

import com.google.common.base.MoreObjects;
import grid.group.box.Box;
import grid.group.column.Column;
import grid.group.row.Row;

public class Slot {

    private int key;
    private int value;
    private Row row;
    private Column column;
    private Box box;

    public Slot(int key, int value) {
        setValue(value);
        setKey(key);
    }

    public int getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }

    public Box getBox() {
        return box;
    }

    public void addRow(Row row) {
        this.row = row;
    }

    public void addColumn(Column column) {
        this.column = column;
    }

    public void addBox(Box box) {
        this.box = box;
    }

    public void setRelations(Row row, Column column, Box box) {
        this.row = row;
        this.column = column;
        this.box = box;

        this.row.addSlot(this);
        this.column.addSlot(this);
        this.box.addSlot(this);
    }

    public void setValue(int value) {
        this.value = value;
    }

    private void setKey(int key) {
        this.key = key;
    }

    private void setRow() {
        //row = key / 9;
    }

    private void setColumn() {
        //column = key % 9;
    }

    private void setBox() {
        //box = ((((row / 3) + 1) * 3) - 2) + (column / 3) - 1;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("value", value)
                .add("row", row.getKey())
                .add("column", column.getKey())
                .add("box", box.getKey())
                .toString();
    }
}
