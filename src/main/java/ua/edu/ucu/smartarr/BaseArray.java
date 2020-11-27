package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] wrapee;

    public BaseArray(Object[] array) {
        wrapee = array.clone();
    }

    public Object[] toArray() {
        return wrapee;
    }

    public String operationDescription() {
        return "BaseArray";
    }

    public int size() {
        return wrapee.length;
    }
}
