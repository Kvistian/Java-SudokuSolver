package grid.group;

import grid.Slot;
import java.util.ArrayList;

public abstract class Groups<T extends Group> extends ArrayList<T> {
    protected Groups(Class<T> contentCls) {
        this(contentCls, 9);
    }

    protected Groups(Class<T> contentCls, int size) {
        for (int key = 0; key < size; key++) {
            T group = Group.createFrom(contentCls, this, key);
            this.add(group);
        }
    }

    public abstract Group getFor(Slot slot);
}
