package grid.group.row;

import com.google.common.collect.Lists;
import grid.group.Group;

import java.util.List;
import java.util.stream.Collectors;

public class Row extends Group<Row> {
    public Row(Rows rows, int key) {
        super(rows, key);
    }

    @Override
    public List<Row> relations() {
        List<Integer> relatedKeys = Lists.newArrayList();
        int prevKey = key;

        for (int i = 1; i < 3; i++) {
            int nextKey = prevKey + 1;

            if (nextKey == key) nextKey++;
            if (nextKey % 3 == 0) nextKey = nextKey - 3;
            if (nextKey == key) nextKey++;

            relatedKeys.add(nextKey);
            prevKey = nextKey;
        }
        System.out.println("key:" + key + " relatedKeys: " + relatedKeys);

        return relatedKeys.stream()
                .map(relations::get)
                .collect(Collectors.toList());
    }
}
