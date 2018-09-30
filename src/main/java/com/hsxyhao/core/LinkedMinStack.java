package com.hsxyhao.core;

import java.util.ArrayList;
import java.util.List;

public class LinkedMinStack extends AbstractMinStack {

    private List<Integer> linkedMin = new ArrayList<>();

    @Override
    public void pushValue(int value) {
        this.data.add(value);
        if (this.linkedMin.size() == 0) {
            this.linkedMin.add(0);
        } else {
            int minIndex = getMinIndex();
            if (value < this.data.get(minIndex)) {
                this.linkedMin.add(this.data.size() - 1);
            }
        }
    }

    @Override
    public Integer popValue() throws NullPointerException {
        int len = this.data.size();
        if (len > 0) {
            Integer popValue = this.data.remove(len - 1);
            int minIndex = getMinIndex();
            if (len - 1 == minIndex) {
                this.linkedMin.remove(this.linkedMin.size() - 1);
            }
            return popValue;
        }
        return null;
    }

    private int getMinIndex() {
        if (this.linkedMin.size() > 0) {
            return this.linkedMin.get(this.linkedMin.size() - 1);
        }
        return -1;
    }

    @Override
    public Integer getMin() {
        int minIndex = getMinIndex();
        if (minIndex >= 0) {
            return this.data.get(minIndex);
        }
        return null;
    }
}
