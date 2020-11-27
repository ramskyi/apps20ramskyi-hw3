package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator comparator;
    public SortDecorator(SmartArray array, MyComparator comp) {
        super(array);
        comparator = comp;
        sorting();
    }

    private void sorting() {
        Arrays.sort(getSmartArray().toArray(), comparator);
    }

    public Object[] toArray() {
        return getSmartArray().toArray();
    }

    public String operationDescription() {
        return "SortDecorator";
    }

    public int size() {
        return getSmartArray().size();
    }
}
