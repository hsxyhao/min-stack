package com.hsxyhao.core;

import com.hsxyhao.print.MinStackPrint;

import java.util.List;

public interface IMinStack {

    /**
     * 获取最小值
     *
     * @return min
     */
    int getMin();

    /**
     * 入栈
     *
     * @param value 值
     */
    void push(int value);

    /**
     * 出栈
     *
     * @return 栈顶
     */
    int pop();

    /**
     * 获取栈的长度
     *
     * @return len
     */
    int len();

    /**
     * 获取所有元素
     *
     * @return 栈元素
     */
    List<Integer> getData();

    default void pushPrint(MinStackPrint print, Integer value) {
        if (print == null) {
            return;
        }
        print.pushPrint(this, value);
    }

    default void popPrint(MinStackPrint print, Integer value) {
        if (print == null) {
            return;
        }
        print.popPrint(this, value);
    }

    default int _getMin() {
        if (getData().size() == 0) {
            return -1;
        }
        int min = getData().get(0);
        for (Integer datum : getData()) {
            if (min > datum) {
                min = datum;
            }
        }
        return min;
    }
}
