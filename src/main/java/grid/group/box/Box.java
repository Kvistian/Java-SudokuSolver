package grid.group.box;

import grid.group.Group;
import grid.group.Groups;

public class Box extends Group<Box> {
    public Box(Boxes boxes, int key) {
        super(boxes, key);
    }

    @Override
    public Groups<Box> relations() {
        return relations;
    }
}
