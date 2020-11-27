package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private final MyPredicate predicate;
    public FilterDecorator(SmartArray array, MyPredicate filter) {
        super(array);
        predicate = filter;
        filtering();
    }

    private void filtering() {
        Object[] oldArray = getSmartArray().toArray();
        ArrayList<Object> newArray = new ArrayList<>();

        for (Object item : oldArray) {
            if (predicate.test(item)) {
                newArray.add(item);
            }

        }
        setSmartArray(new BaseArray(newArray.toArray()));
    }

    public Object[] toArray() {
        return getSmartArray().toArray();
    }

    public String operationDescription() {
        return "FilterDecorator";
    }

    public int size() {
        return getSmartArray().size();
    }
}
