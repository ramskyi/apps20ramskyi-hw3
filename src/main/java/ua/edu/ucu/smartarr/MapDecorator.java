package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction function;
    public MapDecorator(SmartArray array, MyFunction func) {
        super(array);
        function = func;
        mapping();
    }

    private void mapping() {
        Object[] oldArray = getSmartArray().toArray();
        int n = size();
        Object[] newArray = new Object[n];

        for (int i = 0; i < n; i++) {
            newArray[i] = function.apply(oldArray[i]);
        }
        setSmartArray(new BaseArray(newArray));
    }

    public Object[] toArray() {
        return getSmartArray().toArray();
    }

    public String operationDescription() {
        return "MapDecorator";
    }

    public int size() {
        return getSmartArray().size();
    }
}
