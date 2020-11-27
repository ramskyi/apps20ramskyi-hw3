package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray array) {
        smartArray = array;
    }

    public void setSmartArray(SmartArray array) {
        smartArray = array;
    }

    public SmartArray getSmartArray() {
        return smartArray;
    }
}
