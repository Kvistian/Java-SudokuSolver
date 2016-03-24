package grid;

import java.util.ArrayList;

public class ColumnList<Column> extends ArrayList<Column> {
    public ColumnList() {
        super();
    }

    public Column getFor(Slot slot) {
        int index = slot.getKey() % 9;

        return get(index);
    }
}
