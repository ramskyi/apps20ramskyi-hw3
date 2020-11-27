package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    public DistinctDecorator(SmartArray array) {
        super(array);
        unique();
    }

    private void unique() {
        Object[] oldArray = getSmartArray().toArray();
        ArrayList<Object> newArray = new ArrayList<>();

        for (Object item : oldArray) {
            boolean absent = true;
            for (Object item2 : newArray) {
                if (item2.equals(item)) {
                    absent = false;
                    break;
                }
            }
            if (absent) {
                newArray.add(item);
            }
        }
        setSmartArray(new BaseArray(newArray.toArray()));
    }

    public Object[] toArray() {
        return getSmartArray().toArray();
    }

    public String operationDescription() {
        return "DistinctDecorator";
    }

    public int size() {
        return getSmartArray().size();
    }
}
