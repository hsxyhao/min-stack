package com.hsxyhao.core;

public class MinStack extends AbstractMinStack {

    private int min;

    public MinStack() {
        super();
        this.min = Integer.MAX_VALUE;
    }

    @Override
    public void pushValue(int value) {
        if (min > value) {
            min = value;
        }
        this.data.add(value);
    }

    @Override
    public int popValue() {
        if (this.data.size() <= 0) {
            return -1;
        }
        int returnValue = this.data.remove(this.data.size() - 1);
        if (returnValue == min) {
            this.min = _getMin();
        }
        return returnValue;
    }

    @Override
    public int getMin() {
        return min;
    }

}