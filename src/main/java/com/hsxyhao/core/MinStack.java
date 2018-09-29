package com.hsxyhao.core;

public class MinStack extends AbstractMinStack {

    private Integer min;

    public MinStack() {
        super();
    }

    @Override
    public void pushValue(int value) {
        if (min > value) {
            min = value;
        }
        this.data.add(value);
    }

    @Override
    public Integer popValue() {
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
    public Integer getMin() {
        return min;
    }

}