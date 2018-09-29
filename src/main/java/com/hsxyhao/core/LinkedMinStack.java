package com.hsxyhao.core;

import java.util.ArrayList;
import java.util.List;

public class LinkedMinStack extends AbstractMinStack {

    private List<Integer> linkedMin = new ArrayList<>();

    @Override
    public void pushValue(int value) {
        if (linkedMin.size() == 0) {
            linkedMin.add(value);
        } else {
            int currentMin = linkedMin.get(linkedMin.size() - 1);
            if (currentMin > value) {
                linkedMin.add(value);
            } else {
                linkedMin.add(currentMin);
            }
        }
        this.data.add(value);
    }

    @Override
    public int popValue() {
        int len = this.data.size();
        if (len > 0) {
            this.linkedMin.remove(len - 1);
            return this.data.remove(len - 1);
        }
        return -1;
    }

    @Override
    public int getMin() {
        int len = this.linkedMin.size();
        if (len > 0) {
            return this.linkedMin.get(len - 1);
        }
        return -1;
    }
}
