package com.hsxyhao.core;

import java.util.ArrayList;
import java.util.List;

public class MinStack extends AbstractMinStack {

    private int min;
    private int len;
    private List<Integer> data;

    public MinStack() {
        this.data = new ArrayList<>();
        this.len = 0;
        this.min = Integer.MAX_VALUE;
    }

    @Override
    public void pushValue(int value) {
        if (min > value) {
            min = value;
        }
        this.data.add(value);
        this.len++;
    }

    @Override
    public int popValue() {
        if (this.len <= 0) {
            return -1;
        }
        int returnValue = this.data.remove(this.len - 1);
        this.len--;
        if (returnValue == min) {
            this.min = _getMin();
        }
        return returnValue;
    }

    @Override
    public int len() {
        return len;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public List<Integer> getData() {
        return data;
    }

}