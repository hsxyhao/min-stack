package com.hsxyhao.core;


import com.hsxyhao.print.MinStackPrint;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMinStack implements IMinStack {

    List<Integer> data;

    private MinStackPrint print = new MinStackPrint();

    public abstract void pushValue(int value);
    public abstract Integer popValue();

    AbstractMinStack() {
        this.data = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        pushValue(value);
        pushPrint(print, value);
    }

    @Override
    public Integer pop() {
        int value = popValue();
        popPrint(print, value);
        return value;
    }

    @Override
    public Integer len() {
        return this.data.size();
    }

    @Override
    public List<Integer> getData() {
        return data;
    }

}

