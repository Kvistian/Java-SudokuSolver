package grid;

import java.util.ArrayList;

public abstract class Group {
    protected int key;
    protected ArrayList<Slot> slots;

    public Group() {
        slots = new ArrayList<Slot>();
    }

    protected int getKey() {
        return key;
    }

    protected void setKey(int key) {
        this.key = key;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }
}
