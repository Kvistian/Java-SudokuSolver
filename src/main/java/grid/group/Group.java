package grid.group;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import grid.Slot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

public abstract class Group<T extends Group> {
    protected final int key;
    protected final List<Slot> slots;
    protected final Groups<T> relations;

    protected Group(Groups<T> relations, int key) {
        this.relations = relations;
        this.key = key;
        slots = Lists.newArrayList();
    }

    public abstract List<T> relations();

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public int getKey() {
        return key;
    }

    public boolean contains(Integer value) {
        return slots.stream().anyMatch(slot -> Objects.equals(slot.getValue(), value));
    }

    static <T extends Group> T createFrom(Class<T> cls, Groups<T> relations, int key) {
        try {
            Constructor<T> constructor = cls.getConstructor(relations.getClass(), Integer.TYPE);

            return constructor.newInstance(relations, key);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new IllegalStateException("Failed to create group", e);
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("slots", slots)
                .toString();
    }
}
