package grid;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Grid extends AbstractGrid {
    public Grid(int[] values) {
        super(values);
    }

    public Optional<Integer> getMostFilledValue() {
        return valueSlots.values().stream()
                .filter(slots -> slots.size() < 9)
                .max(Comparator.comparingInt(List::size))
                .map(slots -> slots.stream()
                        .findFirst()
                        .orElseThrow(IllegalStateException::new))
                .map(Slot::getValue);
    }

    public List<Slot> getSlotsFor(int value) {
        return valueSlots.get(value);
    }
}
