package grid.group.column;

import grid.group.Group;
import grid.group.Groups;

public class Column extends Group<Column> {
    public Column(Columns columns, int key) {
        super(columns, key);
    }

    @Override
    public Groups<Column> relations() {
        return relations;
    }
}
