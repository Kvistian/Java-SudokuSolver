package grid;

import java.util.ArrayList;

public class RowList<Row> extends ArrayList<Row> {
    public RowList() {
        super();
    }

    public Row getFor(Slot slot) {
        int index = slot.getKey() / 9;

        return this.get(index);
    }
}
