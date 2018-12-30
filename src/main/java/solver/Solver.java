package solver;

import grid.Grid;
import grid.Slot;
import grid.group.Group;
import grid.group.row.Row;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solver {
    private static final int MAX_TIMEOUT = 500;
    private final Grid grid;
    private int timeout = 0;

    public Solver(Grid grid) {
        this.grid = grid;
    }

    public void solve() {
        Optional<Integer> mostFilledValue = grid.getMostFilledValue();

        while (mostFilledValue.isPresent() && timeout < MAX_TIMEOUT) {
            List<Slot> slots = grid.getSlotsFor(mostFilledValue.get());

            for (Slot slot : slots) {
                Row row = slot.getRow();
                find(row, slot);
            }
            timeout++;
        }

        System.out.println("Solved");
    }

    private void find(Group<? extends Group> group, Slot slot) {
        List<? extends Group> relatedGroups = group.relations();

        System.out.println(group.getClass().getSimpleName() + " (" + group.getKey() + "): " + relatedGroups.stream()
                .map(Group::getKey)
                .collect(Collectors.toList()));
        if (relatedGroups.stream().allMatch(relatedGroup -> relatedGroup.contains(slot.getValue()))) {
            System.out.println(group.getClass().getSimpleName() + " group already finished!");
            return;
        }
        Optional<? extends Group> relatedGroupWithoutValue = relatedGroups.stream()
                .filter(relatedGroup -> !relatedGroup.contains(slot.getValue()))
                .findFirst();

        if (!relatedGroupWithoutValue.isPresent()) {
            System.out.println("To many related " + group.getClass().getSimpleName() + "s without value");
            return;
        }
        System.out.println("Found single related " + group.getClass().getSimpleName() + " without value (" + relatedGroupWithoutValue.get() + ")");
    }
}
